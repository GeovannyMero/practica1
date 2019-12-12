/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.productoDAO;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelos.producto;

/**
 *
 * @author jeffe
 */
@ManagedBean
@RequestScoped
public class productoBean {
    private producto prod = new producto();
    private List<producto> listaProducto;

    public List<producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public producto getProd() {
        return prod;
    }

    public void setProd(producto prod) {
        this.prod = prod;
    }
    
    public void registrar() throws Exception{
        productoDAO dao;
        try {
            dao = new productoDAO();
            dao.registrar(prod);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarProducto() throws Exception{
        productoDAO dao;
        
        try {
            dao = new productoDAO();
            listaProducto = dao.listarProductos();
        } catch (Exception e) {
            throw e;
        }
        //return listaProducto;
    }
  
}
