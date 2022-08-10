package com.edu25664.DSmovie.repositories;

import com.edu25664.DSmovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
