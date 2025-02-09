package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "roleId")
    private List<User> listUsers;


    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;

}
