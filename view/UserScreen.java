package view;

import domain.City;
import domain.Province;
import domain.User;
import domain.Game;
import service.GameService;
import service.UserService;

import java.sql.SQLException;
import java.util.UUID;


public class UserScreen {

    private static UserService userService = new UserService();
    private static GameService gameService = new GameService();

    public static void main(String[] args) throws SQLException {

        //PROVINCE DATA
        int provinceId = 1;
        String provinceName = "Alberta";

        //CITY DATA
        Province cityProvinceObj = new Province(provinceId, provinceName);
        int cityId = 33;
        String cityName = "Brooks";


        // USER DATA
        String userId = null;
        String userName = null;
        String userEmail = "cljoaquimn@gmail.com";
        String postalCode = null;
        City cityUserObj = null;;
        int flgActive = 0;
        String picture = null;
        String password = "nfsmw2006";
        String createdAt = null;



        Game game = gameService.getGameByName("a");


    }
}
