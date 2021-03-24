package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin //跨域

public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK, "find all brands", brands);
    }

    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "findById", brand);
    }

    @PutMapping(value = "/{id}")
    public Result<Integer> update(@PathVariable(value = "id")Integer id, @RequestBody Brand brand){
        brand.setId(id);
        return new Result<>(true, StatusCode.OK, "update", brandService.update(brand));
    }

    @DeleteMapping(value = "/{id}")
    public Result<Integer> update(@PathVariable(value = "id")Integer id){
        return new Result<>(true, StatusCode.OK, "delete finish", brandService.delete(id));
    }

    @PostMapping(value = "/search" )
    public Result<List<Brand>> findList(@RequestBody(required = false) Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true,StatusCode.OK,"查询成功",list);
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPageList(@RequestBody(required = false) Brand brand,
                                            @PathVariable  int page, @PathVariable  int size){
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);

        return new Result<>(true,StatusCode.OK,"查询成功", pageInfo);
    }
}
