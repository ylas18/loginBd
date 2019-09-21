/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Bean;

import a.com.Entity.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Yesid
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Persona usuario);

    void edit(Persona usuario);

    void remove(Persona usuario);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();

    Persona Login(Persona usuario);

}
