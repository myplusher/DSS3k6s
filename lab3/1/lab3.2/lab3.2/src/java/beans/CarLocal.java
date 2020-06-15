/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import model.Car;

/**
 *
 * @author Dmi3ev
 */
@Local
public interface CarLocal {
    
    public void add(Car car);
    
    public void update(Car car);
    
    public void remove(Car car);
    
    public List<Car> getAll();
    
    public Car getById(Long id);
}