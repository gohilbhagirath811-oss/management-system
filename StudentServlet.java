package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            Student s = new Student();
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setCourse(request.getParameter("course"));
            s.setCountry(request.getParameter("country"));

            dao.saveStudent(s);
            response.sendRedirect("index.jsp");
        }

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteStudent(id);
            response.sendRedirect("index.jsp");
        }

        if ("update".equals(action)) {
            Student s = new Student();
            s.setId(Integer.parseInt(request.getParameter("id")));
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setCourse(request.getParameter("course"));
            s.setCountry(request.getParameter("country"));

            dao.updateStudent(s);
            response.sendRedirect("index.jsp");
        }
    }
}