package at.projectX.service.game;
import at.projectX.domain.Game;
import at.projectX.repository.GameRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        // via Crudrepository
        /*List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;*/

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM games");
        List<Game> games = (List<Game>)query.list();

        session.close();
        return games;


    }

    public Game getGame(Long id) {
        return gameRepository.findById(id).get();
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
