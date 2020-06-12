/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Dmi3ev
 */
public class Interceptor implements Serializable {
    @EJB
    CountCars countNews;
    
    public Object addInterceptor(InvocationContext context) throws Exception {
        countNews.add();
        return context.proceed();
    }
}
