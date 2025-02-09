package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "amount", nullable = false)
    private double amount;
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;
    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
    @Column(name = "payment_time", nullable = false)
    private LocalDate paymentTime;
    @Column(name = "transaction_id", unique = true)
    private String transactionId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "vip_plan_id", nullable = false)
    private VipPlan vipPlan;
    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
