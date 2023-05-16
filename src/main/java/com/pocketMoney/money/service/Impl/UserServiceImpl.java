package com.pocketMoney.money.service.Impl;

import com.pocketMoney.money.model.user;
import com.pocketMoney.money.reporiste.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){this.userRepository = userRepository;}

    public void save(user user) {
        userRepository.save(user);
    }

    public List<user> findAllusers() {
        List<user> user = userRepository.findAll();
        return user;
    }
    public user findUserById(int userId) {
        user user=userRepository.findById(userId);

      return user;
    }

//    private User mapTouser(User user) {
//        User user = user.builder()
//                .id(User.getId())
//                .amount(.getamount())
//        .created_on(.getcreated_on())
//        .name(.getname_on());
//        .update_on(.getupdate_on);
//        .build();
//        return  user;
//
//    }

}
