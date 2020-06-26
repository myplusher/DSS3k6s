/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Car;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import entities.User;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

 

@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class SessionBeanForTransaction implements SessionBeanForTransactionLocal {

    @EJB
    CarSessionBeanLocal carSBL;
    User u;
    
    List<User> userList = new ArrayList<>();
    List<User> userEditList = new ArrayList<>();
    List<Car> carList = new ArrayList<>();

    @Override
    public void addUserList(User u) {
        userList.add(u);
    }

    @Override
    public void addCarList(Car c) {
        carList.add(c);
    }
    
    @Override
    public void addUserEditList(User u) {
        userEditList.add(u);
    }

    @Resource javax.transaction.UserTransaction ut;
    
    
    @EJB
    UserSessionBeanLocal userSBL;
    
    
    @Override
    public void addUser(){
        try {
        ut.begin();
        for(User u: userList){
            userSBL.create(u);
        }
        for(User u: userEditList){
            userSBL.edit(u);
        }
        ut.commit();
        
        }catch (Exception ex) {
            Logger.getLogger(SessionBeanForTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            userList=new ArrayList<>();
            userEditList = new ArrayList<>();
        }
    } 
    
    @Override
    public void addCar(){
        try {
        
        ut.begin();
        for (Car c: carList){
            carSBL.create(c);
        }
        ut.commit();
        
        }catch (Exception ex) {
            Logger.getLogger(SessionBeanForTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            carList = new ArrayList<>();
        }
    } 
}