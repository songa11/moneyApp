package com.pocketMoney.money.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private String rname;
    private String amount;
    @ManyToOne()
    private Student studentDeposit;
    @CreationTimestamp
    @Column(name="createdOn")
    private LocalDateTime created_on;
    @UpdateTimestamp
    @Column(name="updateOn")
    private LocalDateTime updated_on;


}
