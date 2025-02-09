package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "casts")
@Getter
@Setter
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "day_of_birth", nullable = false)
    private Date dayOfBirth;

    @Column(name = "gender")
    private Gender gender;
    @Column(name = "url_image_avatar")
    private String urlImageAvatar;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;
    @ManyToMany(mappedBy = "setCast")
    private Set<Movie> movies = new HashSet<>();
    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
