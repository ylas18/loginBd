/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Bean;

import a.com.Entity.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yesid
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Persona> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Persona.class);
    }

    /**
     * Metodo el cual realiza la consulta en la base de datos del usuario. Se
     * realiza la consulta enviando los parametros que vienen del controlador y
     * guardamos el resultado de la consulta en una lista. Si la lista no esta
     * vacia nos posicionamos en la posicion 0 para obtener el resultado de la
     * consulta
     *
     * @param usu Parametros que vienen del controller
     * @return Retornamos el objeto Persona
     */
    @Override
    public Persona Login(Persona usu) {
        Persona usuario = null;
        String consulta;
        try {
            consulta = "FROM Persona p WHERE p.username = ?1 AND p.pass = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usu.getUsername());
            query.setParameter(2, usu.getPass());
            List<Persona> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
        }
        return usuario;
    }
}
