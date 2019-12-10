/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author roberto.alferesusam
 */
import ejb.PersonaFacadeLocal;
import entity.Persona;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "personaController")
@SessionScoped

public class PersonaController implements Serializable {

    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    private List<Persona> lista;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLista() {
        return lista;
    }

    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }

    @PostConstruct
    public void init() {
        persona = new Persona();
        lista = personaEJB.findAll();
    }

    public void insertar() {
        try {
            personaEJB.create(persona);
        } catch (Exception e) {
        }
    }

    public void listar() {
        try {
            lista = personaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void leerId(Persona per) {
        try {
            persona = per;
        } catch (Exception e) {
        }
    }

    public void modificar() {
        try {
            personaEJB.edit(persona);
            lista = personaEJB.findAll();
        } catch (Exception e) {
        }
    }

    public void eliminar(Persona per) {
        try {
            this.persona = per;
            personaEJB.remove(persona);
            lista = personaEJB.findAll();
        } catch (Exception e) {
        }
    }
}
