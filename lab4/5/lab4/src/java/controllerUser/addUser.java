/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUser;

import bean.CarSessionBeanLocal;
import bean.SessionBeanForTransactionLocal;
import entities.Car;
import entities.User;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addUser extends HttpServlet {
    
    @EJB
    CarSessionBeanLocal carSBL;
    User u;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            List<Car> carList = carSBL.findAll();
            request.setAttribute("carList", carList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("addUser.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }  
    }

        @EJB
    SessionBeanForTransactionLocal sbForTransaction;
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("addUser.jsp");
            requestDispatcher.forward(request, response);
        }
}