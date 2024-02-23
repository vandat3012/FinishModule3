package com.example.testmodule3.model.service.student;

import com.example.testmodule3.dto.DTOStudent;
import com.example.testmodule3.model.Classes;
import com.example.testmodule3.model.Student;
import com.example.testmodule3.model.service.classs.IClassService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.testmodule3.config.ConnectionJDBC.getConnection;

public class StudentService implements IStudentService {
    @Override
    public List<DTOStudent> findAll() {
        List<DTOStudent> dtoStudents = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select s.id,s.name,s.dates,s.email,s.address,s.phone,c.nameC\n" +
                    "from student s \n" +
                    "join class c \n" +
                    "on s.id_class = c.id\n" +
                    "order by s.id asc;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate dates = LocalDate.parse(String.valueOf(resultSet.getDate("dates")));
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String nameC = resultSet.getString("nameC");
                ;
                DTOStudent dtoStudent = new DTOStudent(id, name, dates, email, address, phone, nameC);
                dtoStudents.add(dtoStudent);
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoStudents;
    }

    @Override
    public void create(Student student) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name,email,dates,address,phone,id_class) values\n" +
                    "(?,?,?,?,?,?);");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, String.valueOf(student.getDates()));
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setInt(6,student.getId_class());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(int id) {
        Connection connection = getConnection();
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String email  = resultSet.getString("email");
                LocalDate dates = LocalDate.parse(String.valueOf(resultSet.getDate("dates")));
                String address  = resultSet.getString("address");
                String phone  = resultSet.getString("phone");
                int id2 = resultSet.getInt("id_class");
                student = new Student(id1,name,email,dates,address,phone,id2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student \n" +
                    "where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DTOStudent> findByName(String name) {
        List<DTOStudent> dtoStudents = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select s.id,s.name,s.dates,s.email,s.address,s.phone,c.nameC\n" +
                    "from student s \n" +
                    "join class c \n" +
                    "on s.id_class = c.id\n" +
                    "where s.name like ?;");
            preparedStatement.setString(1,"%" + name +  "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String names  = resultSet.getString("name");
                String email  = resultSet.getString("email");
                LocalDate dates = LocalDate.parse(String.valueOf(resultSet.getDate("dates")));
                String address  = resultSet.getString("address");
                String phone  = resultSet.getString("phone");
                String nameC = resultSet.getString("nameC");
                DTOStudent dtoStudent= new DTOStudent(id1,names,dates,email,address,phone,nameC);
                dtoStudents.add(dtoStudent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dtoStudents;

    }

}
