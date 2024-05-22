package ma.formation.jpa.presentation.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ma.formation.jpa.dao.DaoImplJPA;
import ma.formation.jpa.service.model.User;

@WebServlet("/addUser.do")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoImplJPA dao = new DaoImplJPA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddUserServlet: doGet called");
        request.getRequestDispatcher("/view/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddUserServlet: doPost called");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (username == null || password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            request.setAttribute("AccountCreationError", "Passwords do not match or missing information.");
            request.getRequestDispatcher("/view/addUser.jsp").forward(request, response);
        } else {
            // Hash the password using MD5
            String hashedPassword = hashPasswordMD5(password);

            User user = new User();
            user.setUsername(username);
            user.setPassword(hashedPassword); // Store the hashed password

            dao.save(user);

            response.sendRedirect(request.getContextPath() + "/login.do");
        }
    }

    private String hashPasswordMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            BigInteger no = new BigInteger(1, digest);
            String hashedPassword = no.toString(16);
            while (hashedPassword.length() < 32) {
                hashedPassword = "0" + hashedPassword;
            }
            return hashedPassword;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
