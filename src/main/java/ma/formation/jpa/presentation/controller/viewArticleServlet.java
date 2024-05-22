package ma.formation.jpa.presentation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formation.jpa.service.IService;
import ma.formation.jpa.service.ServiceImpl;
import ma.formation.jpa.service.model.Article;

import java.io.IOException;

@WebServlet("/viewArticle.do")
public class viewArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                Integer id = Integer.parseInt(idParam);
                Article article = service.getArticleById(id);
                if (article != null) {
                    request.setAttribute("article", article);
                    request.getRequestDispatcher("/view/viewArticle.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Article not found");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid article ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Article ID is required");
        }
    }
}
