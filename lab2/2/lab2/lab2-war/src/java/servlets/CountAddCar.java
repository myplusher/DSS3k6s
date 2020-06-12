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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.CountCars;

/**
 *
 * @author Dmi3ev
 */
public class CountAddCar extends HttpServlet{
    
    @EJB 
    private CountCars countCars;
    
    @EJB
    private IStatefullBean sb;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("countAdd", countCars.getCount());
       List<String> list =sb.returnList();
       request.setAttribute("modeleAdd", list);
       request.getRequestDispatcher("count-add-car.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "";
    }
}
