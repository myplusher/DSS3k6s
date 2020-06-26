/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bean.SessionBeanForTransactionLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

   
public class TransactionControllers extends HttpServlet {

    @EJB
    SessionBeanForTransactionLocal sbForTransaction;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action.equals("user"))sbForTransaction.addUser(); 
        else sbForTransaction.addCar();
        requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}