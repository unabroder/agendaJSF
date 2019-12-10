/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import ejb.CategoriaFacadeLocal;
import ejb.NotasFacadeLocal;
import ejb.PersonaFacadeLocal;
import entity.Categoria;
import entity.Notas;
import entity.Persona;
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
@Named(value = "notasController")
@SessionScoped
public class NotasController implements Serializable {

    @EJB
    private NotasFacadeLocal notasEJB;
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    @EJB
    private PersonaFacadeLocal personaEJB;
    
    private Categoria categoria;
    private Persona persona;
    private Notas notas;
    private List<Categoria> listCateg;
    private List<Persona> listPerson;
    private List<Notas> lista;

    public List<Notas> getLista() {
        return lista;
    }

    public void setLista(List<Notas> lista) {
        this.lista = lista;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Categoria> getListCateg() {
        return listCateg;
    }

    public void setListCateg(List<Categoria> listCateg) {
        this.listCateg = listCateg;
    }

    public List<Persona> getListPerson() {
        return listPerson;
    }

    public void setListPerson(List<Persona> listPerson) {
        this.listPerson = listPerson;
    }

    @PostConstruct
    public void init() {
        notas = new Notas();
        categoria = new Categoria();
        persona = new Persona();
    }

    public void insertar() {
        try {
            notasEJB.create(notas);
        } catch (Exception e) {
        }
    }

    public void leerId(Notas nota) {
        try {
            notas = nota;
        } catch (Exception e) {
        }
    }

    public void modificar() {
        try {
            notasEJB.edit(notas);
            lista = notasEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void eliminar(Notas nota) {
        try {
            notas = nota;
            notasEJB.remove(nota);
            lista = notasEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void listar() {
        try {
            lista = notasEJB.findAll();
        } catch (Exception e) {
        }
    }

}
