package ma.formation.jpa;

import ma.formation.jpa.dao.DaoImplJPA;
import ma.formation.jpa.dao.IDao;
import ma.formation.jpa.dao.article.ArticleDaoImplJPA;
import ma.formation.jpa.dao.article.IArticleDao;
import ma.formation.jpa.service.model.Article;
import ma.formation.jpa.service.model.User;

public class Test {
    public static void main(String[] args) {
        IDao dao = new DaoImplJPA();
        dao.deleteAll();
        dao.save(User.builder().username("user01").password("user01").build());
        dao.save(User.builder().username("user02").password("user02").build());
        dao.save(User.builder().username("user03").password("user03").build());
        dao.save(User.builder().username("user04").password("user04").build());
        dao.save(User.builder().username("user05").password("user05").build());

        IArticleDao daoArticle = new ArticleDaoImplJPA();
        daoArticle.deleteAll();
        daoArticle.save(Article.builder().description("PC PORTABLE HP").price(30.0).quantity(15000).build());
        daoArticle.save(Article.builder().description("PC PORTABLE DELL").price(20.0).quantity(12000).build());
        daoArticle.save(Article.builder().description("TV LG").price(100.0).quantity(7500).build());
        daoArticle.save(Article.builder().description("TV SONY").price(10.0).quantity(8500).build());
        daoArticle.save(Article.builder().description("CAMERA SONY").price(12.0).quantity(2500).build());
        daoArticle.save(Article.builder().description("DD 100G").price(27.0).quantity(500).build());
    }
}
