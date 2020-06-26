/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Car;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CarSessionBeanLocal {
    public List<Car> findAll();
    public void create(Car c);
    public Car find(int id);
    public void remove(Car c);
}