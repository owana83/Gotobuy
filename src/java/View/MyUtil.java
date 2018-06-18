/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.faces.context.FacesContext;

/**
 *
 * @author Fran
 */
public class MyUtil {
    
    public static String baseUrl(){
        return "http://localhost:8080/Gotobuy/faces/";
    }
    
    public static String basePathLogin(){
        return "/Gotobuy/faces/";
    }
    
    public static void redireccionar(String url){
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
