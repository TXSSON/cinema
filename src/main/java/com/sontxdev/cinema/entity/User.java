package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.GenderEnum;
import com.sontxdev.cinema.enums.SourceVipEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
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
    private LocalDate  vipStartDate;
    @Column(name = "vip_end_date")
    private LocalDate  vipEndDate;
    @Column(name = "source_vip")
    @Enumerated(EnumType.STRING)
    private SourceVipEnum sourceVipEnum;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "vip_plan_id")
    private VipPlan vipPlan;

    @OneToMany(mappedBy = "user")
    private List<Payment> paymentList;
    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;
    @OneToMany(mappedBy = "user")
    private List<LikeComment> likeCommentList;

    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
