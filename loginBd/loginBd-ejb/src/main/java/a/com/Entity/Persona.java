/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.com.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author Yesid
 */
/**
 * Creamos la entidad para la conexion a la base de datos
 *
 * @author Yesid
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    /**
     * Creamos una variable la cual es la llave proncipal y es autoincrementable
     * en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Creamos la variable nombre la cual almacena el nombre del usuario
     */
    @Column
    private String nombre;
    /**
     * Vreamos una variable username la cual almacena el usuarui con el cual la
     * persona va a realizar el login
     */
    @Column
    private String username;
    /**
     * Variable que almacena la contraseña con la que se va a validad la session
     */
    @Column
    private String pass;
    /**
     * Variable la cual almacena el rol del usuario
     */
    @Column
    private int rol;

    /**
     * Lectura del id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Escritura del id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Lectura del nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Escritura del nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Lectura del usuario
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Escritura del usuario
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Lectura de la contraseña
     *
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**
     * Escritura de la contraseña
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Lectura del rol
     *
     * @return
     */
    public int getRol() {
        return rol;
    }

    /**
     * Escritura del rol
     *
     * @param rol
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

}
