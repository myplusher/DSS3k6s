/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Роман
 */
@Local
public interface IStatefullBean {
    
    public void addModel(String titleList);
    
    public List<String> returnList();
}
