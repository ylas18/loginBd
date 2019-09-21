/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Controller;

import a.com.Entity.Persona;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Bean en cual se encarga de la session del Cliente
 *
 * @author Yesid
 */
@Named(value = "controllerClie")
@SessionScoped
public class ControllerClie implements Serializable {

    /**
     * Objeto persona el cual se usa para la validacion del usuario en el
     * sistema
     */
    private Persona per;

    /**
     * Metodo que valida la session del Cliente. Si esta activa o inactiva
     *
     * @return Retorna un String que lleva el nombre de la pagina a la cual se
     * redirige el sistema
     */
    public String validarSession() {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);

        try {
            per = (Persona) session.getAttribute("usuario");

        } catch (Exception e) {
        }

        if (per == null) {
            return "index";
        }
        return "cliente";
    }

    /**
     * Metodo el cual se encarga de destruir la session y redirigir
     *
     * @return Retorna un String con el nombre de la pagina a la caul se va a
     * redirigir
     */
    public String cerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("Session terminada");
        return "index";

    }

    public ControllerClie() {
    }

}
