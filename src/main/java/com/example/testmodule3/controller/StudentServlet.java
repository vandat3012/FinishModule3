package com.example.testmodule3.controller;

import com.example.testmodule3.dto.DTOStudent;
import com.example.testmodule3.model.Classes;
import com.example.testmodule3.model.Student;
import com.example.testmodule3.model.service.classs.ClassService;
import com.example.testmodule3.model.service.classs.IClassService;
import com.example.testmodule3.model.service.student.IStudentService;
import com.example.testmodule3.model.service.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

@WebServlet (name = "studentServlet",urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    static IClassService iClassService = new ClassService();
    static IStudentService iStudentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create" :
                showFormCreate(req,resp);
                break;
            case "delete" :
                deleteStudent(req,resp);
                break;
            default:
                showAllStudent(req,resp);
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        iStudentService.delete(id);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("create.jsp");
        List<Classes> list = iClassService.findAllC();
        req.setAttribute("classes",list);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAllStudent(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        List<DTOStudent> dtoStudents = iStudentService.findAll();
        req.setAttribute("dtoStudent",dtoStudents);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create" :
                createStudent(req,resp);
                break;
            case "find" :
                finByName(req,resp);
            default:
                showAllStudent(req,resp);
        }
    }

    private void finByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        List<DTOStudent> products = iStudentService.findByName(name);
        req.setAttribute("dtoStudent",products);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("idC"));
        Student student = new Student(name,email,date,address,phone,id);
        iStudentService.create(student);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
