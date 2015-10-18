package co.com.parna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            
            while(result.next()){
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
        } catch (ClassNotFoundException ex){
              Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          catch( SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return misPlanes;
    }

}
