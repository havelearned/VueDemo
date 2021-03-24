package com.yinghua.vuespringboot;

import com.yinghua.vuespringboot.pojo.DMovies;
import com.yinghua.vuespringboot.reponsitory.DMoviesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VueSpringbootApplicationTests {

    @Autowired
    DMoviesRepository repository;

    @Test
    void contextLoads() {
        DMovies m = new DMovies();
        m.setMMovieName("老骑兵2");
        m.setMDirector("张大坎");
        m.setMProtagonist("郑爽");
        m.setMSupport("罗志祥");
        m.setMScreen("2021-3-24");
        m.setMDesc("他们都是管理大师");
        DMovies save = repository.save(m);
        System.out.println(save);//ids for this class must be manually assigned before calling save() 主键是自增的
    }

}
