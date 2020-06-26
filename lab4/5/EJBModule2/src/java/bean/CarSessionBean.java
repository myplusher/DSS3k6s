/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.CarSessionBeanLocal;
import entities.Car;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarSessionBean implements CarSessionBeanLocal {

    @PersistenceContext(unitName = "EJBModule2")
    private EntityManager em;
    
    @Override
    public List<Car> findAll() {
        List <Car> carList
                =em.createQuery("SELECT r FROM Car r").getResultList();
        return carList;
    }

    @Override
    public Car find(int id) {
        Car car = em.find(Car.class, id);        
        return car;
    }
    
     @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void create(Car c) {
        em.persist(c);
        if (c.getModel().equals("1"))throw new EJBException();
    }
    
    @Override
    public void remove(Car c) {
        em.remove(em.merge(c));
    }
}