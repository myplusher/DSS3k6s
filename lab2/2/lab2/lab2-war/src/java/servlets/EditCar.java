/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CarDAO;
import dao.IDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;

/**
 *
 * @author Dmi3ev
 */
public class EditCar extends HttpServlet {
    @EJB 
    private IDAO dao;
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            int id = Integer.parseInt(request.getParameter("id"));
            Car car = dao.getById(id);
            request.setAttribute("car", car);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCar.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Car car = dao.getById(id);
        
        car.setModel(request.getParameter("model"));
        car.setNumber(request.getParameter("number"));
        car.setDistance(Integer.parseInt(request.getParameter("distance")));
        dao.update(car);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cars.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
