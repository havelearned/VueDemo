package com.yinghua.vuespringboot.reponsitory;

import com.yinghua.vuespringboot.pojo.DMovies;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DMoviesRepositoryTest {
    @Autowired
    private DMoviesRepository dMoviesRepository;


    @Test
    void delete(){
        boolean present = dMoviesRepository.findById(34).isPresent();
        if (present) {
            dMoviesRepository.deleteById(34);

        }else{
            System.out.println(present);
        }
    }

    @Test
    void Update(){
        DMovies m = new DMovies();
        m.setMId(35);
        m.setMMovieName("老骑兵3");
        m.setMDirector("张大坎");
        m.setMProtagonist("郑爽");
        m.setMSupport("罗志祥");
        m.setMScreen("2021-3-24");
        m.setMDesc("他们都是管理大师");
        DMovies save = dMoviesRepository.save(m);
        System.out.println(save);
    }

    @Test
    public void Test01(){
        List<DMovies> all = dMoviesRepository.findAll();

        System.out.println(all);
    }



    @Test
    void findAllById(){
        /**
         * findById(Integer) 传递id
         * get() 获取对应的对象 ,它的源码中 java.util,Optional<T> 给获取的对象又包装了一层,防止出现空异常
         * */
        DMovies dMovies = dMoviesRepository.findById(1).get();
        System.out.println(dMovies);
    }

}
