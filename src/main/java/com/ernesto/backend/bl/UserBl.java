package com.ernesto.backend.bl;

import com.ernesto.backend.dao.UserDao;
import com.ernesto.backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserBl {

    private UserDao userDao;

    @Autowired
    public UserBl(UserDao userDao){
        this.userDao=userDao;
    }

    public ArrayList<UserModel> findAllActives(){
        return  this.userDao.findAllActives();
    }

}
