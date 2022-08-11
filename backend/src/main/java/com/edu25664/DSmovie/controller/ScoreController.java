package com.edu25664.DSmovie.controller;

import com.edu25664.DSmovie.dto.MovieDTO;
import com.edu25664.DSmovie.dto.ScoreDTO;
import com.edu25664.DSmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO salveScore(@RequestBody ScoreDTO scoreDTO) {
        MovieDTO dto = service.saveScore(scoreDTO);
        return dto;
    }

}
