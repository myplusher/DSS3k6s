/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author Роман
 */
@Singleton
public class CountCars {
    int count;
    
    @PostConstruct
    public void init() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
    
    public void add() {
        ++count;
    }
}