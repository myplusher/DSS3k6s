/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Car;

/**
 *
 * @author Dmi3ev
 */
@Stateless
public class CarBean implements CarLocal{
    
    @PersistenceContext(unitName = "lab03_newPU")
    private EntityManager entityManager;
    
    @Override
    public void add(Car car) {
        entityManager.persist(car);
    }

    @Override
    public void update(Car car) {
       entityManager.merge(car);
    }

    @Override
    public void remove(Car car) {
        entityManager.remove(entityManager.merge(car));
    }

    @Override
    public List<Car> getAll() {
        return entityManager.createQuery(
                "SELECT w FROM Work w").getResultList();
    }

    @Override
    public Car getById(Long id) {
        return entityManager.find(Car.class, id);
    }
    
}