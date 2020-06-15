/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import beans.UserLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import beans.CarLocal;

@Named("usersController")
@SessionScoped
public class UserController extends HttpServlet {
    
    @EJB
    private UserLocal userLocal;
    @EJB
    private CarLocal carLocal;
    
    private User user = new User();
    
    protected void goGet(HttpServletRequest request,
            HttpServletResponse response) 
                throws ServletException, IOException {
        request.setAttribute("users", carLocal.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showUser.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) 
            throws ServletException, IOException {
    String act = request.getParameter("act");
    RequestDispatcher dispatcher;
    switch (act){
        case ("edit"):
            user.setName(request.getParameter("name"));
            user.setDriving(Integer.parseInt(request.getParameter("driving")));
            user.setCar(carLocal.getById(Long.parseLong(
                    request.getParameter("car"))));
            userLocal.update(user);
            dispatcher =
                request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("create"):
            user = new User();
            user.setName(request.getParameter("name"));
            user.setDriving(Integer.parseInt(request.getParameter("driving")));
            user.setCar(carLocal.getById(Long.parseLong(
                    request.getParameter("car"))));
            userLocal.add(user);
            dispatcher =
                request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("delete"):
            userLocal.remove(user);
            break;
        default:
            dispatcher=request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
    }
    }
}