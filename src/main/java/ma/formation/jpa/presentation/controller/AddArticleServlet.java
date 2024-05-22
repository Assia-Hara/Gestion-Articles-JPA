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

@WebServlet("/addArticle.do")
public class AddArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/addArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        Article article = new Article();
        article.setDescription(description);
        article.setQuantity((int) quantity);
        article.setPrice(price);

        service.saveArticle(article);

        response.sendRedirect("articles.do");
    }
}
