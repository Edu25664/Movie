package com.edu25664.DSmovie.repositories;

import com.edu25664.DSmovie.entities.Score;
import com.edu25664.DSmovie.entities.ScorePK;
import com.edu25664.DSmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
