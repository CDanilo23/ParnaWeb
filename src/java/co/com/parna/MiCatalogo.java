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
public class MiCatalogo implements Serializable{
   
    private ArrayList<Catalogo> misProductos = new ArrayList<Catalogo>();
    
    public MiCatalogo(){
    }

    public ArrayList<Catalogo> getMisProductos() {
        return misProductos;
    }

    public void setMisProductos(ArrayList<Catalogo> misProductos) {
        this.misProductos = misProductos;
    }
    
    public void agregarProducto(Catalogo catalogo){
        misProductos.add(catalogo);
    }
    
    public void removerProducto(Catalogo catalogo){
        misProductos.remove(catalogo);
    }
}
