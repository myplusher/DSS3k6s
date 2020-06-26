/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.User;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJBException;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
    
    @PersistenceContext(unitName = "EJBModule1")
    private EntityManager em;
    
    @Override
    public List<User> findAll() {
        List <User> userList
                =em.createQuery("SELECT u FROM User u").getResultList();
        return userList;
    }
    
    @Override
    public List<User> findAllStudent() {
        List <User> userList
                =em.createQuery("select u from User u WHERE u.role.name='student'").getResultList();
        return userList;
    }
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void create(User u) {
        em.persist(u);
        if (u.getName().equals("1"))throw new EJBException();
    }

    @Override
    public void edit(User u) {
        em.merge(u);
    }
    
    @Override
    public void remove(User u) {
        em.remove(em.merge(u));
    }
     
    @Override    
    public User find(int id) {
        return em.find(User.class, id);
    }   
}