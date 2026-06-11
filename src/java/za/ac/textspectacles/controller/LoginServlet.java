package za.ac.textspectacles.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            request.login(username, password);
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            String role = request.isUserInRole("manager") ? "manager" : request.isUserInRole("agent") ? "agent" : "admin";
            session.setAttribute("role", role);
            session.setAttribute("displayName", username);

            if (request.isUserInRole("manager")) {
                response.sendRedirect(request.getContextPath() + "/manager/managerHome.jsp");
            } else if (request.isUserInRole("agent")) {
                response.sendRedirect(request.getContextPath() + "/agent/agentHome.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } catch (ServletException e) {
            request.setAttribute("error", "Login failed. Please check username, password and file realm configuration.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
