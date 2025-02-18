package com.sontxdev.cinema.controller.client;

import com.sontxdev.cinema.dto.response.ApiResponse;
import com.sontxdev.cinema.dto.response.MovieResponse;
import com.sontxdev.cinema.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ApiResponse<List<MovieResponse>> getAllMovies() {
        return ApiResponse.<List<MovieResponse>>builder()
                .result(movieService.findAll())
                .build();
    }
    @GetMapping("/{id}")
    public ApiResponse<MovieResponse> getMovieById(@PathVariable String id) {
        return ApiResponse.<MovieResponse>builder()
                .result(movieService.findById(id))
                .build();
    }
}
