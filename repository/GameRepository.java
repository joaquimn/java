package repository;

import domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GameRepository extends Dbtools {

    public Game getGameByName(String gameNameP){
        Game game = null;

        makeJDBCConnection();

        try{

            String query = "select * from view_games where game_name like ?";
            prepareStat = varConn.prepareStatement(query);

            prepareStat.setString(1, "%"+gameNameP+"%");


            ResultSet rs = prepareStat.executeQuery();
            List<Game> games = new ArrayList<Game>();

            while (rs.next()) {
                String gameId = rs.getString("game_id" );
                String gameName = rs.getString("game_name" );
                String description = null;
                String cover = null;
                boolean flgActive = false;
                String released = null;
                String createdAt = null;
                Genre genre = null;
                Platform platform = null;
                Producer producer = null;
                Region region = null;
                Status status = null;

                Game newGame = new Game(gameId,gameName, description, cover, flgActive, released,createdAt, genre, platform, producer,  region, status );
                games.add(newGame);





                /*
                *   private String gameId;
                    private String gameName;
                    private String description;
                    private String cover;
                    private boolean flgActive;
                    private String released;
                    private String createdAt;
                    private Genre genre;
                    private Platform platform;
                    private Producer producer;
                    private Region region;
                    private Status status;
                * */


            }

            for(Game aGame : games){
                System.out.println(aGame.getGameName());
            }


        } catch (SQLException e){
            e.getErrorCode();
        } finally {
            closeConnection(varConn);
        }

        return game;
    }

}
