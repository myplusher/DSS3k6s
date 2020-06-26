/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Car;
import entities.User;
import javax.ejb.Local;

@Local
public interface SessionBeanForTransactionLocal {
    //метод для транзакции в бд пользователей
    public void addUser();
    //метод для транзакции в бд автомобилей
    public void addCar();
    
    public void addCarList(Car c);
    public void addUserList(User u);
    public void addUserEditList(User u);
}