package com.cergy.javaav.Services;

import com.cergy.javaav.models.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao {
    public List<User> listAll() {
        List<User> list = new ArrayList<>();
        /*User u = new User();
        u.setLastname("Leponge");
        u.setFirstname("Bob");
        u.setEmail("bob@gmail.com");
        u.setPhone("0123456789");
        list.add(u);
        u = new User();
        u.setLastname("Man");
        u.setFirstname("Bat");
        u.setEmail("bat@gmail.com");
        u.setPhone("0123456789");
        list.add(u);*/

        try(Connection co = DriverManager.getConnection("jdbc:mysql://locahost:3306/javaav", "root", "vincent")) {
            try(Statement st = co.createStatement()){
                String sql = "SELECT * FROM users;";
                try(ResultSet result = st.executeQuery(sql)){
                    while(result.next()){
                        User u = new User();
                        u.setLastname(result.getString("lastname"));
                        u.setFirstname(result.getString("firstname"));
                        u.setEmail(result.getString("email"));
                        u.setPhone(result.getString("phone"));
                        list.add(u);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
