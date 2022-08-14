package uz.pdp.mvcexample.dao;

import uz.pdp.mvcexample.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public interface UserDaoInterface {

    public List<User> allUsers();

    public int addUsers(User user);

    public int updateUsers(User user);

    public int deleteUsers(int id);

    public User findUserById(int id);

    public Connection getConnection();






}
