package com.edu25664.DSmovie.services;

import com.edu25664.DSmovie.dto.MovieDTO;
import com.edu25664.DSmovie.dto.ScoreDTO;
import com.edu25664.DSmovie.entities.Movie;
import com.edu25664.DSmovie.entities.Score;
import com.edu25664.DSmovie.entities.User;
import com.edu25664.DSmovie.repositories.MovieRepository;
import com.edu25664.DSmovie.repositories.ScoreRepository;
import com.edu25664.DSmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ScoreService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()){
           sum = sum + score.getValue();
        }
        double avg = sum / movie.getScores().size();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());


        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }

}
