package com.yinghua.vuespringboot.controller;

import com.yinghua.vuespringboot.pojo.DMovies;
import com.yinghua.vuespringboot.reponsitory.DMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {
    @Autowired
    private DMoviesRepository dMoviesRepository;

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean present = dMoviesRepository.findById(id).isPresent();
        if (present) {
            dMoviesRepository.deleteById(id);
            return "success";
        } else {
            return "error";
        }
    }

    @PutMapping("/update")
    public String UpdateById(@RequestBody() DMovies dMovies) {
        DMovies result = dMoviesRepository.save(dMovies);
        if (result != null) {
            System.out.println(result);
            return "success";
        } else {
            return "error";
        }

    }

    @GetMapping("/findById/{id}")
    public DMovies findById(@PathVariable("id") Integer id) {
        return dMoviesRepository.findById(id).get();
    }

    /**
     * 添加保存到数据库中
     */
    @PostMapping("/save")
    public String Save(@RequestBody DMovies movies) {
        DMovies request = dMoviesRepository.save(movies);
        if (request != null) {
            System.out.println(request);
            return "success";
        } else {
            return "error";
        }

    }

    /**
     * 查询所有movies
     * @return
     */
    @GetMapping(value = "/findAll", produces = "application/json;charset=utf-8")
    public List<DMovies> getDMovies() {

        return dMoviesRepository.findAll();
    }


    /**
     * getDMovies() 方法是 分页操作
     *
     * @param page :当前页面
     * @param size :页面大小
     * @return Page<DMovies>
     */

    @GetMapping(value = "/findAll/{page}/{size}", produces = "application/json;charset=utf-8")
    public Page<DMovies> getDMovies(@PathVariable("page") Integer page,
                                    @PathVariable("size") Integer size) {
        Pageable pagebel = PageRequest.of(page - 1, size);
        Page<DMovies> all = dMoviesRepository.findAll(pagebel);


        return all;
    }
}
