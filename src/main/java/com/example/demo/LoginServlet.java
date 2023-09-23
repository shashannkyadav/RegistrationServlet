package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "Login Servlet Testing",urlPatterns = { "/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user",value = "Shashank"),
                @WebInitParam(name = "password", value = "Ydava@123")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the login form
        String user = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        // You should validate the username and password here.
        // For example, check them against a database of users.
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("pwd");

        if (userID.equals(user) && password.equals(pwd)) {
            // Successful login
            request.setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);}
        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request,response);
        }
    }

    private boolean isValidUser(String username, String password) {
        // In a real application, you should perform proper user authentication here,
        // such as checking against a database of users and hashed passwords.
        // For simplicity, we'll just use a hardcoded username and password.
        return "user".equals(username) && "password".equals(password);
    }
}
