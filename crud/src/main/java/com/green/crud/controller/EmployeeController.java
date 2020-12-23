package com.green.crud.controller;

import com.github.pagehelper.PageInfo;
import com.green.crud.bean.Employee;
import com.green.crud.service.EmployeeService;
import com.green.crud.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 分页查询所有带部门员工
     *
     * @param pn
     * @return
     */
    @RequestMapping("emps")
    public Msg getEmps(@RequestParam(value = "pn", defaultValue = "2") Integer pn, @RequestParam(value = "page", defaultValue = "5") Integer page) {
        PageInfo<Employee> list = employeeService.getEmps(pn, page);
        return Msg.success().add("page", list);
    }


    /**
     * 对姓名进行校验
     */
    @RequestMapping("checkUserName")
    public Msg checkUserName(String name) {
        int flag = employeeService.checkUserName(name);
        if (flag != 0) {
            return Msg.success().add("desc","当前用户名已存在");
        }
        return Msg.fail();
    }

    /**
     * 保存新增员工信息
     */
    @RequestMapping("saveEmps")
    public Msg saveEmps(@RequestBody Employee employee) {
        int flag = employeeService.saveEmps(employee);
        if (flag != 0) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 查询待修改员工数据
     */
    @RequestMapping("getEmp")
    public Msg getEmp(int id) {
        Employee employee = employeeService.getEmp(id);
        if (employee != null) {
            return Msg.success().add("emp", employee);
        }
        return Msg.fail();
    }

    /**
     * 提交待修改的员工信息
     */
    @RequestMapping("updateEmp")
    public Msg updateEmp(@RequestBody Employee employee) {
        int flag = employeeService.updateEmp(employee);
        if (flag != 0) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 单个删除员工数据
     * @return
     */
    @RequestMapping("deleteEmp")
    public Msg deleteEmp(int empId){
        int flag = employeeService.deleteEmp(empId);
        if (flag != 0) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 批量删除员工数据
     */
    @RequestMapping("deleteBatch")
    public Msg deleteBatch(@RequestParam("empIds[]") List<Integer> empIds){
        int flag = employeeService.deleteBatch(empIds);
        if (flag != 0) {
            return Msg.success();
        }
        return Msg.fail();
    }

}
