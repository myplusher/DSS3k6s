/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.User;

/**
 *
 * @author Dmi3ev
 */
public class UserBean  implements UserLocal{
    
    @PersistenceContext(unitName = "lab03_newPU")
    private EntityManager entityManager;

    @Override
    public void add(User person) {
        entityManager.persist(person);
    }

    @Override
    public void update(User person) {
       entityManager.merge(person);
    }

    @Override
    public void remove(User person) {
        entityManager.remove(entityManager.merge(person));
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery(
                "SELECT p FROM User p").getResultList();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
    
}
