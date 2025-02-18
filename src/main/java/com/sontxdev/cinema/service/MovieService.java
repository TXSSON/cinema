package com.sontxdev.cinema.service;

import com.sontxdev.cinema.dto.response.MovieResponse;
import com.sontxdev.cinema.entity.Movie;
import com.sontxdev.cinema.mapper.MovieMapper;
import com.sontxdev.cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieResponse> findAll() {
        List<Movie>  movieList =  this.movieRepository.findAll();
        return movieList.stream().map(movieMapper::movieToMovieResponse).collect(Collectors.toList());
    }
    public MovieResponse findById(String id) {
        Movie movie = this.movieRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Không tồn tại movie có id này!"));
        return movieMapper.movieToMovieResponse(movie);
    }

}
