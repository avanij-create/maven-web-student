package com.practice;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "Student";
        }

        response.getWriter().println(
            "<!DOCTYPE html><html><head><title>Student Portal</title></head>" +
            "<body style='font-family:Arial;margin:40px'>" +
            "<h1>Welcome, " + escapeHtml(name) + "!</h1>" +
            "<p>Your Maven Web application is running on Tomcat.</p>" +
            "<p>Servlet path: /hello</p>" +
            "<a href='index.jsp'>Back to home</a>" +
            "</body></html>"
        );
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;");
    }
}
