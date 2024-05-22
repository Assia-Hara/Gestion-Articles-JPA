package ma.formation.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formation.jpa.service.IService;
import ma.formation.jpa.service.ServiceImpl;

@WebServlet("/deleteArticle.do")
public class DeleteArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                request.setAttribute("articleId", id);
                request.getRequestDispatcher("/view/deleteArticle.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid article ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Article ID is required");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteArticle(id);
        response.sendRedirect("articles.do");
    }
}
