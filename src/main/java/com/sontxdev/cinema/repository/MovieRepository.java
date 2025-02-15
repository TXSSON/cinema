package com.sontxdev.cinema.repository;

import com.sontxdev.cinema.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
}
