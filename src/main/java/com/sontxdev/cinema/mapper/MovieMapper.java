package com.sontxdev.cinema.mapper;

import com.sontxdev.cinema.dto.response.MovieResponse;
import com.sontxdev.cinema.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieResponse movieToMovieResponse(Movie movie);
}
