package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "periods")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "period_name")
    private String name;
    @OneToMany(mappedBy = "period")
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
