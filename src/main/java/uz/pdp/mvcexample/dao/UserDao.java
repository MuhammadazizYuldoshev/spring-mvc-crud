package uz.pdp.mvcexample.dao;

import org.springframework.stereotype.Service;
import uz.pdp.mvcexample.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao implements UserDaoInterface {


    @Override
    public List<User> allUsers() {
        List<User> list=new ArrayList<User>();

        try{
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                user.setLastname(rs.getString(3));
                user.setPhonenumber(rs.getString(4));
                list.add(user);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }

    @Override
    public int addUsers(User user) {
        int status = 0;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into users(firstname,lastname,phonenumber) values (?,?,?)");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getPhonenumber());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    @Override
    public int updateUsers(User user) {
        int status=0;
        try{
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "update users set firstname=?,lastname=?,phonenumber=? where id=?");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3,user.getPhonenumber());
            ps.setInt(4,user.getId());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;

    }

    @Override
    public int deleteUsers(int id) {
        int status=0;
        try{
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement("delete from users where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;

    }




    @Override
    public User findUserById(int id) {
        User user=new User();

        try{
            Connection con = getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                user.setLastname(rs.getString(3));
                user.setPhonenumber(rs.getString(4));
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return user;
    }








    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usercrud","postgres","root123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }


}
