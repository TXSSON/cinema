package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "vip_plans")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(name = "vip_plan_name", nullable = false, unique = true)
    private String vipPlanName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "vipPlan")
    private List<User> userList;

    @OneToMany(mappedBy = "vipPlan")
    private List<Payment> paymentList;
    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
