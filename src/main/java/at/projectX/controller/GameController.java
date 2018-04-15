package at.projectX.controller;

import at.projectX.domain.Game;
import at.projectX.service.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @RequestMapping("/games/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameService.getGame(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/games")
    public void addGame(@RequestBody Game game) {
        gameService.addGame(game);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/games/{id}")
    public void updateUser(@RequestBody Game game, @PathVariable String id) {
        gameService.updateGame(game);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/games/{id}")
    public void deleteUser(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
