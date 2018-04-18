package com.example.springdemo.server;

import com.example.springdemo.dao.DepartmentMapper;
import com.example.springdemo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "department")
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @CachePut(key="#department.id")
    public Department save(Department department){
        System.out.println("保存 id="+ department.getId()+" 的数据；");
        this.departmentMapper.insert(department);
        return department;
    }

    @CachePut(key = "#department.id")
    public Department update(Department department) {
        System.out.println("修改 id=" + department.getId() + " 的数据;");
        this.departmentMapper.updateByPrimaryKey(department);
        return department;
    }

    @Cacheable(key = "#id")
    public Department getDepartmentById(Integer id) {
        System.out.println("获取 id=" + id + " 的数据;");
        Department department = this.departmentMapper.selectByPrimaryKey(id);
        System.out.println(department.getId());
        return department;
    }

    @CacheEvict(key = "#id")
    public void delete(Integer id) {
        System.out.println("删除 id=" + id + " 的数据;");
        this.departmentMapper.deleteByPrimaryKey(id);
    }
}
