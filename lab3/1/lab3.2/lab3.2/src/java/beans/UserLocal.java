/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;
import model.User;

/**
 *
 * @author Dmi3ev
 */
@Local
public interface UserLocal {
    
    public void add(User user);
    
    public void update(User user);
    
    public void remove(User user);
    
    public List<User> getAll();
    
    public User getById(Long id);
}