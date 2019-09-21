/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Controller;

import a.com.Bean.UsuarioFacadeLocal;
import a.com.Entity.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yesid
 */
@Named(value = "controllerLogin")
@SessionScoped
public class ControllerLogin implements Serializable {

    @EJB(beanName = "UsuarioFacade")
    private UsuarioFacadeLocal usuarioFacadeLocal;

    private Persona usuario;
    private Persona usu;

    public UsuarioFacadeLocal getUsuarioFacadeLocal() {
        return usuarioFacadeLocal;
    }

    public void setUsuarioFacadeLocal(UsuarioFacadeLocal usuarioFacadeLocal) {
        this.usuarioFacadeLocal = usuarioFacadeLocal;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public Persona getUsu() {
        return usu;
    }

    public void setUsu(Persona usu) {
        this.usu = usu;
    }

    @PostConstruct
    public void init() {
        usuario = new Persona();
        usu = new Persona();
    }

    public ControllerLogin() {
    }

    public String empezarLogin() {
        String redireccion = "index";
        try {
            usu = usuarioFacadeLocal.Login(usuario);
            if (usu != null) {
                FacesContext fCtx = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
                session.setAttribute("usuario", usu);
                if (usu.getRol() == 1) {
                    redireccion = "administrador";
                } else {
                    redireccion = "cliente";
                }
            } else {
                System.out.println("usuario invalido");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Datos Incorrectos"));
            }
        } catch (Exception e) {
        }
        return redireccion;
    }

}
