package com.yinghua.vuespringboot.reponsitory;

import com.yinghua.vuespringboot.pojo.DMovies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DMoviesRepository extends JpaRepository<DMovies,Integer> {

}
