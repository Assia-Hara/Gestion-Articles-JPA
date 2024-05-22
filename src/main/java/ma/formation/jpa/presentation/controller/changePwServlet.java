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

@WebServlet("/changePw.do")
public class changePwServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DaoImplJPA dao = new DaoImplJPA();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/changePw.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (username == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = dao.getUserByUsername(username);

        if (user == null || !hashPasswordMD5(currentPassword).equals(user.getPassword())) {
            request.setAttribute("error", "Current password is incorrect");
            request.getRequestDispatcher("/view/changePw.jsp").forward(request, response);
            return;
        }

        if (newPassword == null || confirmPassword == null || !newPassword.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match or missing information");
            request.getRequestDispatcher("/view/changePw.jsp").forward(request, response);
            return;
        }

        user.setPassword(hashPasswordMD5(newPassword));
        dao.save(user);

        response.sendRedirect(request.getContextPath() + "/login.do");
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
