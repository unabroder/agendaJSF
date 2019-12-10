/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Notas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author roberto.alferesusam
 */
@Local
public interface NotasFacadeLocal {

    public void create(Notas nota);

    public void edit(Notas nota);

    public void remove(Notas nota);

    Notas find(Object id);

    List<Notas> findAll();
}
