/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Dmi3ev
 */
@Stateful
@SessionScoped
public class StatefullBean implements IStatefullBean, Serializable {
    
    private List<String> modelList = new ArrayList<>();

    @PostConstruct
    private void init() {
        modelList = new ArrayList<>();
    }
    
    @Override
    public void addModel(String title) {
        modelList.add(title);
    }

    @Override
    public List<String> returnList() {
        return modelList;
    }
}
