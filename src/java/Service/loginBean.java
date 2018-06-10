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
import org.primefaces.PrimeFaces;
import Dao.IUsuarioDao;

/**
 *
 * @author Fran
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private Usuario usuario;
    private IUsuarioDao usuarioDao;

    public loginBean() {
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

    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "http://localhost:8080/Gotobuy";

        this.usuario = this.usuarioDao.login(this.usuario);

        if (this.usuario != null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombre());
            ruta = MyUtil.basePathLogin() + "Views/inicio.xhtml";
//            ruta = "http://localhost:8080/Gotobuy/faces/Views/inicio.xhtml";

        } else {
            loggedIn = false;
            this.usuario = new Usuario();
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Email y/o contraseña incorrecta");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);

    }

}