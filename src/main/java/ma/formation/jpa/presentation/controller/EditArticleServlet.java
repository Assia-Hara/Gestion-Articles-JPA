package ma.formation.jpa.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formation.jpa.service.IService;
import ma.formation.jpa.service.ServiceImpl;
import ma.formation.jpa.service.model.Article;

@WebServlet("/editArticle.do")
public class EditArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                Integer id = Integer.parseInt(idParam); // Ensure Integer type
                Article article = service.getArticleById(id);
                if (article != null) {
                    request.setAttribute("article", article);
                    request.getRequestDispatcher("/view/editArticle.jsp").forward(request, response);
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        Article article = new Article();
        article.setId(id);
        article.setDescription(description);
        article.setQuantity(quantity);
        article.setPrice(price);

        service.saveArticle(article);

        response.sendRedirect("articles.do");
    }
}
