package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.MovieStatus;
import com.sontxdev.cinema.enums.SubScription;
import com.sontxdev.cinema.enums.TypeMovie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating", nullable = false)
    private double rating = 0.0;

    @Column(name = "type", nullable = false)
    private TypeMovie type;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "length_or_episodes")
    private int lengthOrEpisodes;

    @Column(name = "top")
    private int top;

    @Column(name = "url_poster_image")
    private String urlPosterImage;

    @Column(name = "subscription")
    private SubScription subscription;

    @Column(name = "status")
    private MovieStatus status;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> setGenre = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id")
    )
    private Set<Cast> setCast = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Video> setVideo = new HashSet<>();

    //    @Column(name = "create_at")
//    private Date createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private Date updateAt;
//    @Column(name = "update_by")
//    private String updateBy;



}
