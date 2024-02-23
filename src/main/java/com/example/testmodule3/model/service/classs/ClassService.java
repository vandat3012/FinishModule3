package com.example.testmodule3.model.service.classs;


import com.example.testmodule3.model.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.testmodule3.config.ConnectionJDBC.getConnection;

public class ClassService implements IClassService{
    @Override
    public List<Classes> findAllC() {
        List<Classes> classList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from class");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nameC");
                Classes classes = new Classes(id,name);
                classList.add(classes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classList;
    }
}
