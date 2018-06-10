/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import View.MyUtil;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Fran
 */
@ManagedBean
@ApplicationScoped
public class appBean {

    /**
     * Creates a new instance of appBean
     */
    public appBean() {
    }
    
    public String getBaseUrl(){
        return MyUtil.baseUrl();
    }
    
}
