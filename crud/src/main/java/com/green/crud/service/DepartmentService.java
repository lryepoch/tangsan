package com.green.crud.service;

import com.green.crud.bean.Department;
import com.green.crud.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDept() {
        return departmentMapper.selectByExample(null);
    }
}
