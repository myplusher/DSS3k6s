/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Car;

/**
 *
 * @author Dmi3ev
 */
public interface IDAO {
    
    public List<Car> getAll();
    
    public Car getById(int id);
    
    public void delete(int id);
    
    public void update(Car model);
    
    public Car create(Car model);
}
