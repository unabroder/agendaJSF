/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
/**
 *
 * @author roberto.alferesusam
 */
public class Usuario implements Serializable {

    @Id
    @JoinColumn(name = "idusuario", referencedColumnName = "idpersona", nullable = false)
    @OneToOne(cascade = CascadeType.PERSIST)
    private Persona idusuario;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "pass")
    private String pass;

    @JoinColumn(name = "tipo", referencedColumnName = "idtipo", nullable = false)
    @ManyToOne
    private TipoUsuario tipo;

    @Column(name = "estado")
    private boolean estado = true;

    public Persona getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Persona idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idusuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + '}';
    }

}
