package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "like_coments")
@Getter
@Setter
public class LikeComemnt {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;
    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
