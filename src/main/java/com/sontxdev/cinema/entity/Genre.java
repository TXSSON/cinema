package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "genres")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "genre_name", nullable = false)
    private String name;
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;
    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
