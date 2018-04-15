package at.projectX.service.game;
import at.projectX.domain.Game;
import at.projectX.repository.GameService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {


    private Configuration con = new Configuration().configure().addAnnotatedClass(Game.class);

    private SessionFactory sessionFactory = con.buildSessionFactory();

    public List<Game> getAllGames() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Game");
            List<Game> games = (List<Game>) query.list();
            return games;
        } catch (RuntimeException error){
            throw error;
        } finally {
            session.close();
        }
    }

    public Game getGame(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Game where id = :id");
            query.setParameter("id", id);
            Game game = (Game) query.getSingleResult();
            return game;
        } catch (RuntimeException error){
            throw error;
        } finally {
            session.close();
        }
    }

    public void addGame(Game game) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(game);
        } catch (RuntimeException error){
            throw error;
        } finally {
            session.close();
        }

    }

    public void updateGame(Game game) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(game);
            session.getTransaction().commit();
        } catch (RuntimeException error){
            throw error;
        } finally {
            session.close();
        }
    }

    public void deleteGame(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete Game where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (RuntimeException error){
            throw error;
        } finally {
            session.close();
        }
    }
}
