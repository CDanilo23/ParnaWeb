package co.com.parna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.com.parna.Catalogo;
import co.com.parna.MiCatalogo;
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
    
    public MiCatalogo consultarDatos() {
         MiCatalogo micatalogo = new MiCatalogo();
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:derby://localhost:1527/MiSitioPlusDB", "root", "123456");
            st = conexion.createStatement();
            ResultSet result = st.executeQuery("select * from ROOT.CATALOGO ");
            
            while(result.next()){
                Catalogo catalogo = new Catalogo();
                catalogo.setId(result.getInt(1));
                catalogo.setNombre(result.getString(2));
                catalogo.setPrecio(result.getDouble(3));
                catalogo.setImagen(result.getString(4));
                micatalogo.agregarProducto(catalogo);
            }
        } catch (ClassNotFoundException ex){
              Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          catch( SQLException ex) {
            Logger.getLogger(MiConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return micatalogo;
    }

}
