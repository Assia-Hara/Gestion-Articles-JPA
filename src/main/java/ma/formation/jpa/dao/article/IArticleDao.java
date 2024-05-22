package ma.formation.jpa.dao.article;

import java.util.List;
import ma.formation.jpa.service.model.Article;

public interface IArticleDao {
    List<Article> findAll();
    void save(Article article);
    void deleteAll();
    Article findById(Integer id); // Change to Integer
    void delete(Integer id); // Change to Integer
}
