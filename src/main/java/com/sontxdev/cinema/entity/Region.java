package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "regions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "region_name", nullable = false)
    private String name;
    @OneToMany(
            mappedBy = "region",
            fetch = FetchType.LAZY
    )
    private List<Movie> movieList;
    @OneToMany(
            mappedBy = "region",
            fetch = FetchType.LAZY
    )
    private List<Cast> castList;
    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;

}
