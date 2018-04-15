package at.projectX.repository;

import at.projectX.domain.Game;

import java.util.List;

public interface GameService {
    List<Game> getAllGames();
    Game getGame(Long id);
    void addGame(Game game);
    void updateGame(Game game);
    void deleteGame(Long id);
}
