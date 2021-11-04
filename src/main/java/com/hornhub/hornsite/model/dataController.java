package com.hornhub.hornsite.model;

import com.hornhub.hornsite.entities.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.jsp.jstl.core.*;

public class dataController {
    private static dataController instance = new dataController();
    private List<user> data;

    public static dataController getInstance(){
        return instance;
    }

    private dataController() {
        data = new ArrayList<>();
    }

    public void addUser(user user){
        data.add(user);
    }

    public List<String> list(){
        return data.stream().map(user::getUsername).collect(Collectors.toList());
    }
}
