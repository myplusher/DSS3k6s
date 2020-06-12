/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.IDAO;
import beans.IStatefullBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import controller.CountCars;

/**
 *
 * @author Dmi3ev
 */
public class AddCar extends HttpServlet {
    
    @EJB 
    private IDAO dao;
    
    @EJB
    private IStatefullBean sb;
    
    @EJB 
    private CountCars countCar;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try { 
            request.getRequestDispatcher("addCar.jsp").forward(request, response);
        } catch (Exception e) { 
            throw new ServletException(e.getLocalizedMessage());
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try {
            Car car = new Car();
            car.setModel(request.getParameter("model"));
            sb.addModel(car.getModel());
            car.setNumber(request.getParameter("number"));
            car.setDistance(Integer.parseInt(request.getParameter("distance")));
            dao.create(car);
            countCar.add();
            response.sendRedirect("cars");
        } catch (Exception e) {
            throw new ServletException(e.getLocalizedMessage());       
        }
    }
    
    @Override
    public String getServletInfo() {
        return "";
    }
}