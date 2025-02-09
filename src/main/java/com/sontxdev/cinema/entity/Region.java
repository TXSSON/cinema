package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "regions")
@Getter
@Setter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "region_name")
    private String name;
    @OneToMany(mappedBy = "region")
    private List<Movie> listMovies;
    @OneToMany(mappedBy = "region")
    private List<Cast> listCasts;
    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;

}
