/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Controller;

import a.com.Entity.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Bean en cual se encarga de la session del Administrador
 *
 * @author Yesid
 */
@Named(value = "controllerAdmin")
@SessionScoped
public class ControllerAdmin implements Serializable {

    /*
     Creamos el objeto persona para validar la session
     */
    private Persona per;

    /**
     * Metodo el cual valida la session. Valida si la persona tiene session o
     * no, para el rol Administrador
     *
     * @return Retorna un String con el nombre del xhtml al cual se redirecciona
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
        return "administrador";
    }

    /**
     * Metodo el cual destruye la session del usuario Administrador
     *
     * @return Retorna el String con el nombre del index para redireccionar al
     * index. xhtml
     */
    public String cerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("Session terminada");
        return "index";

    }

    public ControllerAdmin() {
    }

}
