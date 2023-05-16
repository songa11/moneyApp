package com.pocketMoney.money.reporiste;


import com.pocketMoney.money.model.user;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Integer> {
    user findById(int id);
    Optional<user>findByname(String url);
    @Query("select b from user b where b.studentDeposit=?1")
    List<user>getAllUserDeposit(user Us);
}
