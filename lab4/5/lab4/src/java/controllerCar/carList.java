/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerCar;

import bean.CarSessionBeanLocal;
import entities.Car;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dmi3ev
 */
public class carList extends HttpServlet {

    @EJB
    CarSessionBeanLocal carSBL;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
            List<Car> carList = carSBL.findAll();
            request.setAttribute("carList", carList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("carList.jsp");
            requestDispatcher.forward(request, response);
        }catch (IOException | ServletException e) { 
            throw new ServletException(e.getMessage()); 
        }  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Car c = carSBL.find(id);
        carSBL.remove(c);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}