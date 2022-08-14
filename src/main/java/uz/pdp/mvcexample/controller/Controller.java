package uz.pdp.mvcexample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import uz.pdp.mvcexample.dao.UserDao;
import uz.pdp.mvcexample.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserDao userDao;


    //userlarni korish
    @RequestMapping("/")
    public String homepage(Model model){
        List<User> users = userDao.allUsers();
        model.addAttribute("users",users);

        return "home-page";
    }


    //show add users form
    @RequestMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("title","ADD USERS");
        return "user-add";
    }

    //userni qoshish formasidan keyin tekshiruv
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public RedirectView addHandleUser(@ModelAttribute User user, HttpServletRequest request) {

        int status = userDao.addUsers(user);
        if (status > 0) {
            System.out.println("user = " + user);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(request.getContextPath() + "/");
            return redirectView;


        }

        return null;
    }


    //delete user
    @RequestMapping("/delete/{id}")
    public RedirectView deleteUser(@PathVariable("id") int id, HttpServletRequest request){
        userDao.deleteUsers(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }


    //update user
    @RequestMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id,Model model){
        User userById = userDao.findUserById(id);
        model.addAttribute("user",userById);
        return "update-user";
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RedirectView updateUser(@ModelAttribute User user, HttpServletRequest request) {

        int status = userDao.updateUsers(user);
        if (status > 0) {
            System.out.println("user = " + user);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(request.getContextPath() + "/");
            return redirectView;


        }

        return null;
    }


}
