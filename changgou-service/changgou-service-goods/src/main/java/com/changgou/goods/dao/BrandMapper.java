package com.changgou.goods.dao;

import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    @Select(value = "select tb_brand.*\n" +
            "from tb_brand,tb_category_brand\n" +
            "where tb_category_brand.category_id = #{categoryId}\n" +
            "and tb_brand.id = tb_category_brand.brand_id")
    List<Brand> findByCategory(Integer categoryId);
}
