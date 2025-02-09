package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "casts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "day_of_birth", nullable = false)
    private LocalDate dayOfBirth;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Column(name = "url_image_avatar")
    private String urlImageAvatar;
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;
    @ManyToMany(mappedBy = "castList")
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
