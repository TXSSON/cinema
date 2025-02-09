package com.sontxdev.cinema.entity;

import com.sontxdev.cinema.enums.MovieStatusEnum;
import com.sontxdev.cinema.enums.SubScriptionEnum;
import com.sontxdev.cinema.enums.TypeMovieEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(name = "movie_name", nullable = false)
    private String name;
    @Column(name = "director", nullable = false)
    private String director;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "rating", nullable = false)
    private BigDecimal rating;
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeMovieEnum type;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "length_or_episodes")
    private int lengthOrEpisodes;
    @Column(name = "top_number")
    private int topNumber;
    @Column(name = "url_poster_image")
    private String urlPosterImage;
    @Column(name = "subscription")
    @Enumerated(EnumType.STRING)
    private SubScriptionEnum subscription;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MovieStatusEnum status;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(
            name = "region_id",
            nullable = false
    )
    private Region region;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id", nullable = false)
    private Period period;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genreList = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id")
    )
    private List<Cast> castList = new ArrayList<>();
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Video> videoList = new ArrayList<>();

    //    @Column(name = "create_at")
//    private LocalDate  createAt;
//    @Column(name = "create_by")
//    private String createBy;
//    @Column(name = "update_at")
//    private LocalDate  updateAt;
//    @Column(name = "update_by")
//    private String updateBy;



}
