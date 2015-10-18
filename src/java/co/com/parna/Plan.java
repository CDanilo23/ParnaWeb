/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parna;


import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Plan implements Serializable {
    
    private Integer id;
    private String nombre;
    private String imagenParque;
    private Double costoTempAltaNiños;
    private Double costoTempBajaNiños;
    private Double costoTempAltaAdultos;
    private Double costoTempBajaAdultos;
    private String horario;
    private String imagenMapa;
    
    
    public static final java.lang.String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    public Plan() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenParque() {
        return imagenParque;
    }

    public void setImagenParque(String imagenParque) {
        this.imagenParque = imagenParque;
    }

    public Double getCostoTempAltaNiños() {
        return costoTempAltaNiños;
    }

    public void setCostoTempAltaNiños(Double costoTempAltaNiños) {
        this.costoTempAltaNiños = costoTempAltaNiños;
    }

    public Double getCostoTempBajaNiños() {
        return costoTempBajaNiños;
    }

    public void setCostoTempBajaNiños(Double costoTempBajaNiños) {
        this.costoTempBajaNiños = costoTempBajaNiños;
    }

    public Double getCostoTempAltaAdultos() {
        return costoTempAltaAdultos;
    }

    public void setCostoTempAltaAdultos(Double costoTempAltaAdultos) {
        this.costoTempAltaAdultos = costoTempAltaAdultos;
    }

    public Double getCostoTempBajaAdultos() {
        return costoTempBajaAdultos;
    }

    public void setCostoTempBajaAdultos(Double costoTempBajaAdultos) {
        this.costoTempBajaAdultos = costoTempBajaAdultos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagenMapa() {
        return imagenMapa;
    }

    public void setImagenMapa(String imagenMapa) {
        this.imagenMapa = imagenMapa;
    }
}
