package com.green.crud.controller;

import com.green.crud.bean.Department;
import com.green.crud.service.DepartmentService;
import com.green.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取全部部门
     * @return
     */
    @RequestMapping("depts")
    public Msg getDept() {
        List<Department> list = departmentService.getDept();
        return Msg.success().add("depts", list);
    }
}
