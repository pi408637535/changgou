package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    /**
     * find all
     */
    List<Brand> findAll();
    Brand findById(Integer id);
    int update(Brand brand);
    int delete(Integer id);

    /**
     * 条件查询
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);
    PageInfo<Brand> findPage(int page, int size);

    /**
     * 分页+条件
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

    List<Brand> findByCategory(Integer categoryId);
}
