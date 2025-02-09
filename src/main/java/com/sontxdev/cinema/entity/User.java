package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.Gender;
import com.sontxdev.cinema.enums.SourceVip;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "vip_start_date")
    private Date vipStartDate;
    @Column(name = "vip_end_date")
    private Date vipEndDate;
    @Column(name = "source_vip")
    private SourceVip sourceVip;
//    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role roleId;

    @ManyToOne
    @JoinColumn(name = "vip_plan_id")
    private VipPlan vipPlanId;

    @OneToMany(mappedBy = "user")
    private List<Payment> listPayments;
    @OneToMany(mappedBy = "user")
    private List<Comment> listComments;
    @OneToMany(mappedBy = "user")
    private List<LikeComemnt> listLikeComemnts;
}
