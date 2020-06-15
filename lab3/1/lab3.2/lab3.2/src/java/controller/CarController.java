/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import beans.CarLocal;

/**
 *
 * @author Dmi3ev
 */
public class CarController {
    @EJB
    private CarLocal carLocal;
    
    private Car car = new Car();
    
    protected void goGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("cars", carLocal.getAll());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/allUsers.jsp");
        dispatcher.forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    String act = request.getParameter("act");
    RequestDispatcher dispatcher;
    
    switch (act){
        case ("edit"):
            car.setModel(request.getParameter("model"));
            car.setNumber(request.getParameter("number"));
            car.setDistance(Integer.parseInt(request.getParameter("distance")));
            carLocal.update(car);
            
            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("create"):
            car = new Car();
            car.setModel (request.getParameter("model"));
            car.setNumber(request.getParameter("number"));
            car.setDistance(Integer.parseInt(request.getParameter("distance")));
            carLocal.add(car);
            
            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("delete"):
            carLocal.remove(car);
            break;
        default:
            dispatcher=request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }
    }
}