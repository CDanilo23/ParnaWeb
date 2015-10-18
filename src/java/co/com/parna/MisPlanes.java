/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parna;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class MisPlanes implements Serializable{
   
    private ArrayList<Plan> misProductos = new ArrayList<Plan>();
    
    public MisPlanes(){
    }

    public ArrayList<Plan> getMisProductos() {
        return misProductos;
    }

    public void setMisProductos(ArrayList<Plan> misProductos) {
        this.misProductos = misProductos;
    }
    
    public void agregarPlan(Plan catalogo){
        misProductos.add(catalogo);
    }
    
    public void removerProducto(Plan catalogo){
        misProductos.remove(catalogo);
    }
}
