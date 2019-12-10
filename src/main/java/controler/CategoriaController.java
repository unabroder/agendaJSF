/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import ejb.CategoriaFacadeLocal;
import entity.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author roberto.alferesusam
 */
@Named(value = "categoriaController")
@SessionScoped
public class CategoriaController implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    private List<Categoria> lista;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getLista() {
        return lista;
    }

    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }

//sirve como constructor
    @PostConstruct
    public void init() {
        categoria = new Categoria();
    }

    public void insertar() {
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
        }
    }

    public void listar() {
        try {
            lista = categoriaEJB.findAll();
        } catch (Exception e) {
        }
    }
    
    public void leerId(Categoria cat){
        try {
            categoria = cat;
        } catch (Exception e) {
        }
    }
    
     public void modificar(){
        try {
            categoriaEJB.edit(categoria);
            lista = categoriaEJB.findAll();
        } catch (Exception e) {
        }
    }
     
      public void eliminar(Categoria cat){
        try {
            this.categoria = cat;
            categoriaEJB.remove(categoria);
            lista = categoriaEJB.findAll();
        } catch (Exception e) {
        }
    }
}
