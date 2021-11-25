package com.cergy.javaav.Services;

import com.cergy.javaav.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Service
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> listAll() {
        //List<User> list = new ArrayList<>();
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
//stage 1 JDBC
        /*try(Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaav", "root", "vincent")) {
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
        return list;*/
//stage 2: spring-jdbc
        /*String sql = "SELECT * FROM users;";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {

                @Override
                public User mapRow(ResultSet result, int rowNum) throws SQLException {
                    User u = new User();
                    u.setLastname(result.getString("lastname"));
                    u.setFirstname(result.getString("firstname"));
                    u.setEmail(result.getString("email"));
                    u.setPhone(result.getString("phone"));
                    return u;
            }
        });
        return list;*/

//stage 3: spring-jdbc auto mapper
        String sql = "SELECT * FROM users;";
        List<User> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        return list;
    }

    public int add(User user){
        String sql = "INSERT INTO users (lastname, firstname, email, phone) VALUES (?, ?, ?, ?);";
        return jdbcTemplate.update(sql, user.getLastname(), user.getFirstname(), user.getEmail(), user.getPhone());
    }

    public User findById(int userId) {
        String sql = "SELECT * FROM users WHERE id=? ;";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), userId);
    }
}
