package ma.formation.jpa.dao.article;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import ma.formation.jpa.dao.DatabaseManager;
import ma.formation.jpa.service.model.Article;

public class ArticleDaoImplJPA implements IArticleDao {
    private EntityManager session;

    @Override
    public List<Article> findAll() {
        List<Article> articles = null;
        try {
            session = DatabaseManager.getSessionFactory().createEntityManager();
            articles = session.createQuery("from Article", Article.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return articles;
    }

    @Override
    public void save(Article article) {
        EntityTransaction tx = null;
        try {
            session = DatabaseManager.getSessionFactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            session.merge(article);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteAll() {
        EntityTransaction tx = null;
        try {
            session = DatabaseManager.getSessionFactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            session.createQuery("delete from Article").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public Article findById(Integer id) {
        Article article = null;
        try {
            session = DatabaseManager.getSessionFactory().createEntityManager();
            article = session.find(Article.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return article;
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction tx = null;
        try {
            session = DatabaseManager.getSessionFactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            Article article = session.find(Article.class, id);
            if (article != null) {
                session.remove(article);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
