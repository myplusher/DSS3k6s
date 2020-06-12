/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.ejb.EJB;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import dao.IDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 *
 * @author Роман
 */
public class AllCars extends HttpServlet{
    @EJB 
    private IDAO dao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try { 
            List<Car> cars = dao.getAll();
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("carsList.jsp").forward(request, response);
        } catch (Exception e) { 
            throw new ServletException(e.getLocalizedMessage()); 
        }    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        try{
            request.getRequestDispatcher("carsList.jsp")
                    .forward(request,response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }    
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}
