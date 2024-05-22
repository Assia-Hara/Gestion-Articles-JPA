package ma.formation.jpa.service;

import ma.formation.jpa.service.model.Article;
import ma.formation.jpa.service.model.User;

import java.util.List;

public interface IService {
    List<Article> getAllArticle();
    void saveArticle(Article article);
    void deleteAllArticles();
    Article getArticleById(Integer id);
    void deleteArticle(Integer id);

    boolean checkAccount(String username, String password);
}
