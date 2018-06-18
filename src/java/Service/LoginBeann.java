/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.UsuarioHbmDao;
import Entities.Usuario;
import View.MyUtil;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Dao.IUsuarioDao;

/**
 *
 * @author Fran
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBeann implements Serializable {

    private Usuario usuario;
    private IUsuarioDao usuarioDao;
    private boolean loggedIn = false;
    FacesMessage message = null;

    public LoginBeann() {
        this.usuarioDao = new UsuarioHbmDao();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMessage(FacesMessage message) {
        this.message = message;
    }

    public FacesMessage getMessage() {
        return message;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void verificarLogin() {
        if (!this.isLoggedIn()) {
            MyUtil.redireccionar("login.xhtml");
        }
    }

    public void verificarLoginDeInicio() {
        if (!this.isLoggedIn()) {
            MyUtil.redireccionar("faces/Views/login.xhtml");
        }
    }

    public void login() {
        this.usuario = this.usuarioDao.login(this.usuario);
        String direccion = "";

        if (this.usuario != null) {
            setLoggedIn(true);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombre());
            setMessage(message);
            if (this.usuario.getEmail().equalsIgnoreCase("222@gmail.com")) {
                MyUtil.redireccionar("administracion.xhtml");
            }
            MyUtil.redireccionar("inicio.xhtml");

        } else {
            setLoggedIn(false);
            this.usuario = new Usuario();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Email y/o contraseña incorrecta");
            setMessage(message);
            direccion = "#";
        }
        
            FacesContext.getCurrentInstance().addMessage(null, message);
//             PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
//             PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
    }
    public String logOut() {
        setLoggedIn(false);
        return "login";
    }
}