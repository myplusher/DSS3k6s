/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUser;

import bean.SessionBeanForTransactionLocal;
import bean.UserSessionBeanLocal;
import bean.CarSessionBeanLocal;
import entities.Car;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class editUser extends HttpServlet {

    @EJB
    UserSessionBeanLocal userSBL;
    
    @EJB
    CarSessionBeanLocal carSBL;
    User u;
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        u = userSBL.find(id);
        request.setAttribute("user", u);
        List<Car> carList = carSBL.findAll();
        request.setAttribute("carList", carList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @EJB
    SessionBeanForTransactionLocal sbForTransaction;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        u.setName(request.getParameter("name"));        
        Car car = carSBL.find(Integer.parseInt(request.getParameter("car")));
        int cаr = 1;
        u.setCar(cаr);
        sbForTransaction.addUserEditList(u);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}