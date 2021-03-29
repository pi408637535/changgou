package com.changgou.goods.dao;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.pojo.Spec;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Spec的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface SpecMapper extends Mapper<Spec> {
    @Select(value = "SELECT tb_spec.*\n" +
            "from tb_spec,tb_category\n" +
            "where tb_category.id = #{categoryId}\n" +
            "and tb_spec.template_id = tb_category.template_id")
    List<Spec> findByCategory(Integer categoryId);
}
