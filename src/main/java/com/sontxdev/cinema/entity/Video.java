package com.sontxdev.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "videos")
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;
}
