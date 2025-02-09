package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vip_plans")
@Setter
@Getter
public class VipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "vip_plan_name", nullable = false, unique = true)
    private String vipPlanName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(mappedBy = "vipPlanId")
    private List<User> listUsers;

    @OneToMany(mappedBy = "vipPlan")
    private List<Payment> listPayments;
    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
