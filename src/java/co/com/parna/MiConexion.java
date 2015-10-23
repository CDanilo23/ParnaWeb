package co.com.parna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class MiConexion implements Serializable {

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String sampleProperty;

    private PropertyChangeSupport propertySupport;
    //variable que habre la conexion
    static java.sql.Statement st;

    public MiConexion() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public MisPlanes consultarDatos() {
        MisPlanes misPlanes = new MisPlanes();
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/ParnaDB", "root", "123456");
            st = conexion.createStatement();
            ResultSet result = st.executeQuery("select * from ROOT.PLAN ");

            while (result.next()) {
                Plan plan = new Plan();
                plan.setId(result.getInt(1));
                plan.setImagenParque(result.getString(2));
                plan.setCostoTempAltaAdultos(result.getDouble(3));
                plan.setCostoTempBajaAdultos(result.getDouble(4));
                plan.setCostoTempAltaNiños(result.getDouble(5));
                plan.setCostoTempBajaNiños(result.getDouble(6));
                plan.setHorario(result.getString(7));
                plan.setImagenMapa(result.getString(8));
                plan.setNombre(result.getString(9));
                misPlanes.agregarPlan(plan);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return misPlanes;
    }

    public MisPlanes ingresarOrden(String nombre, String direccion, String telefono, String ciudad, String pais, MisPlanes misPlanes) {
        String sql = "";
        String id = "";
        String fecha = "";
        String iditem = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        fecha = date.toString();
        id = sdf.format(date);
        MisPlanes micatalogo = new MisPlanes();

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");// Indica el driver para buscar el motor de la conexión de la base de datos.
            Connection conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/ParnaDB", "root", "123456");
            java.sql.PreparedStatement preparedStatement = conexion.prepareStatement("insert into orden(id, nombre, direccion, telefono, ciudad, pais) values(?,?,?,?,?,?)"); //Objeto del objeto connection,se llama la conexión y se crea un Statement.
            Integer idOrden = obtenerMaxId("orden");
            preparedStatement.setInt(1, obtenerMaxId("orden"));
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, direccion);
            preparedStatement.setString(4, telefono);
            preparedStatement.setString(5, ciudad);
            preparedStatement.setString(6, pais);
//            sql = "insert into orden(id, nombre, direccion, telefono, ciudad, pais) values(" + maxId != null ? maxId : 1 + ",'" + nombre + "','" + direccion + "','" + telefono + "','" + ciudad + "','" + pais + "')";
            preparedStatement.executeUpdate(); //Objeto que ejecuta la consulta.
            
            for(Plan plan : misPlanes.getMisProductos()){
                preparedStatement = conexion.prepareStatement("insert into plan_orden(id, id_orden, id_plan, nombre_parque,costo_ingreso) values (?,?,?,?,?)");
                preparedStatement.setInt(1, obtenerMaxId("plan_orden"));
                preparedStatement.setInt(2, idOrden);
                preparedStatement.setInt(3, plan.getId());
                preparedStatement.setString(4, plan.getNombre());
                preparedStatement.setDouble(5, plan.getCostoTempAltaAdultos());
                preparedStatement.executeUpdate();
            }
           
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return micatalogo;
    }

    private Integer obtenerMaxId(String tabla) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");// Indica el driver para buscar el motor de la conexión de la base de datos.
        Connection conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/ParnaDB", "root", "123456");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select max(id) from root.");
        stringBuilder.append(tabla);
        java.sql.Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(stringBuilder.toString());
        Integer idMax = null;
        while(rs.next()){
            idMax = rs.getInt(1);
        }
        statement.close();
        return idMax>=1 ? idMax+1 : 1;
    }

}
