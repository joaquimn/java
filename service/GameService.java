package service;

import domain.Game;
import domain.User;

import repository.GameRepository;
import repository.UserRepository;

import java.util.UUID;


public class GameService {

    static UserRepository userRepository = new UserRepository();
    static GameRepository gameRepository = new GameRepository();


    public Game getGameByName(String gameName){
        Game game = null;

        if( gameName != "")
        {
            game = gameRepository.getGameByName(gameName);
        }




        return game;
    }

    public boolean addGame( User user, Game game){

        //boolean chkUser = userRepository.getUserById(user);

        // before addGame, do:
        // check userId
        // check gameId
        // both (must exist) true -> insert is going to happen into the games_users table
        // should this method being in the business layer?!


        return true;
    }

}
