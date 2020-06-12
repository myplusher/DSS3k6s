/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.spi.Interceptor;
import javax.interceptor.Interceptors;
import model.Car;

/**
 *
 * @author Dmi3ev
 */
@Stateless
public class CarDAO implements IDAO {
    
    private static final Logger LOGGER = Logger.getLogger(CarDAO.class.getName());
    
    private final String url = "jdbc:mysql://localhost:3306/lab01?useSSL=false&useUnicode=true&serverTimezone=UTC";
    private final String username = "root";
    private final String password = "root";
    private static Connection connection;
    
    @PostConstruct
    private void init() {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            LOGGER.warning("Error getting connection");
        }
    }
    
    @Override
    public List<Car> getAll() {
       List<Car> carsList = new ArrayList<>();
       String request = "SELECT*FROM CARS";
       try {
           PreparedStatement stmt = connection.prepareStatement(request);
           ResultSet result = stmt.executeQuery();
           while (result.next()) {
               Car car = new Car();
               car.setId(result.getInt(1));
               car.setModel(result.getString(2));
               car.setNumber(result.getString(3));
               car.setDistance(Integer.parseInt(result.getString(4)));
               carsList.add(car);
           }
           return carsList;
       } catch (Exception e) {
           LOGGER.warning("ERROR" + e.getMessage());
           return null;
       }
    }

    @Override
    public Car getById(int id) {
       String request = "SELECT*FROM CARS WEHERE id="+id;
       try {
           PreparedStatement stmt = connection.prepareStatement(request);
           ResultSet result = stmt.executeQuery();
           Car car = new Car();
           if (result.next()) {
           car.setId(result.getInt(1));
           car.setModel(result.getString(2));
           car.setNumber(result.getString(3));
           car.setDistance(Integer.parseInt(result.getString(4)));
           }
           return car;
       } catch (Exception e) {
           LOGGER.warning("ERROR" + e.getMessage());
           return null;
       }
    }

    @Override
    public void delete(int id) {
        String request = "DELETE FROM CARS WEHERE id="+id;
       try {
           PreparedStatement stmt = connection.prepareStatement(request);
           stmt.setInt(1,id);
           stmt.executeUpdate();
       } catch (Exception e) {
           LOGGER.warning("ERROR" + e.getMessage());
       }
    }

    @Override
    public void update(Car model) {
        String request = "UPDATE CARS SET model = ?, number = ?, distance = ? WHERE id ="+model.getId();
       try {
           PreparedStatement stmt = connection.prepareStatement(request);
           stmt.setString(1,model.getModel());
           stmt.setString(2, model.getNumber());
           stmt.setInt(3, model.getDistance());
           stmt.executeUpdate();
       } catch (Exception e) {
           LOGGER.warning("ERROR" + e.getMessage());
       }
    }
    
    @Override
    @Interceptors(Interceptor.class)
    public Car create(Car model) {
       String request = "INSERT INTO CARS (model, number, distance) VALUES(?,?,?)";
       try {
           PreparedStatement stmt = connection.prepareStatement(request,
                   PreparedStatement.RETURN_GENERATED_KEYS);
           stmt.setString(1, model.getModel());
           stmt.setString(2, model.getNumber());
           stmt.setInt(3, model.getDistance());
           stmt.executeUpdate();
           ResultSet resultSet = stmt.getGeneratedKeys();
           if (resultSet.next()) {
               model.setId(resultSet.getInt(1));     
           }
           return model;
       } catch (Exception e) {
           LOGGER.warning("ERROR" + e.getMessage());
           return null;
       }
    }
}