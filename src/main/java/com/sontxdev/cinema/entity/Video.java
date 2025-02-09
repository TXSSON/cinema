package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "videos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column( name = "url_video", nullable = false)
    private String url;
    @Column(name = "episode")
    private int episode;
    @ManyToOne
    @JoinColumn(
            name = "movie_id", nullable = false
    )
    private Movie movie;
    @OneToMany(mappedBy = "video")
    private List<Comment> listComments;
    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
