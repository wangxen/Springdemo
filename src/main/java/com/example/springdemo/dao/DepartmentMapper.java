package com.example.springdemo.dao;

import com.example.springdemo.model.Department;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated
     */
    Department selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated
     */
    List<Department> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Department record);
}