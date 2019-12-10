/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Notas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author roberto.alferesusam
 */
@Stateless
public class NotasFacade extends AbstractFacade<Notas> implements NotasFacadeLocal {

    @PersistenceContext(unitName = "conexionPU")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public NotasFacade() {
        super(Notas.class);
    }
}
