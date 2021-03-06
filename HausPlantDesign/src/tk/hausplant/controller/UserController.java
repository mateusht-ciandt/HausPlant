package tk.hausplant.controller;

import tk.hausplant.model.User;
import tk.hausplant.dao.ConnectMSSQLServer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User Service
 * 
 * @author mateusht
 */
public class UserController extends AbstractController{
    
    /**
     * Method to get all users from database
     * @return list of users
     */
    public List<User> getUsers()  {
        final List<User> users;
        try{
            users  = new ArrayList<>();
            ResultSet result = con.dbConnect("SELECT * FROM USER_;");
            while(result.next()){
                users.add(new User(result.getInt(1), result.getString(2)));
            }
            return users;
        }catch (SQLException ex){
            System.err.println("Error get users");
        }
        return new ArrayList<>();
    }
}
