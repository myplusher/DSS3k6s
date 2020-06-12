/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.IDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Роман
 */
public class DeleteCar extends HttpServlet{
    
    @EJB 
    private IDAO dao;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       dao.delete(Integer.parseInt(request.getQueryString()));
       response.sendRedirect("cars");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       dao.delete(Integer.parseInt(request.getQueryString()));
       response.sendRedirect("cars");
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}