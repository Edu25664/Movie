package com.edu25664.DSmovie.services;

import com.edu25664.DSmovie.dto.MovieDTO;
import com.edu25664.DSmovie.entities.Movie;
import com.edu25664.DSmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;
    @Transactional
    public Page<MovieDTO> findAll(Pageable pageable) {
          Page<Movie> result = repository.findAll(pageable);
          Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
          return page;
    }
    @Transactional
    public MovieDTO findById(Long id) {
        Movie result = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }
}
