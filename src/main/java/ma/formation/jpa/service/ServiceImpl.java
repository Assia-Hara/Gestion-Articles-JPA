package ma.formation.jpa.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import ma.formation.jpa.dao.DaoImplJPA;
import ma.formation.jpa.dao.IDao;
import ma.formation.jpa.dao.article.ArticleDaoImplJPA;
import ma.formation.jpa.dao.article.IArticleDao;
import ma.formation.jpa.service.model.Article;
import ma.formation.jpa.service.model.User;

public class ServiceImpl implements IService {
    private IDao dao = new DaoImplJPA();
    private IArticleDao articleDao = new ArticleDaoImplJPA();

    @Override
    public List<Article> getAllArticle() {
        return articleDao.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        articleDao.save(article);
    }

    @Override
    public void deleteAllArticles() {
        articleDao.deleteAll();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleDao.findById(id);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleDao.delete(id);
    }

    @Override
    public boolean checkAccount(String username, String password) {
        User u = dao.getUserByUsername(username);
        if (u == null)
            return false;

        // Hash the input password and compare it with the stored hashed password
        String hashedPassword = hashPasswordMD5(password);
        return hashedPassword.equals(u.getPassword());
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
