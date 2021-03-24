package com.yinghua.vuespringboot.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity //严格对应数据库中的表名称
@Data
@Table(name = "d_movies")
public class DMovies {
    @Id //指定id
    @Column(name = "M_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mId;

    @Column(name = "M_movie_name")
    private String mMovieName;

    @Column(name = "M_director")
    private String mDirector;

    @Column(name = "M_protagonist")
    private String mProtagonist;

    @Column(name = "M_support")
    private String mSupport;

    @Column(name = "M_screen")
    private String mScreen;

    @Column(name = "M_desc")
    private String mDesc;
}
