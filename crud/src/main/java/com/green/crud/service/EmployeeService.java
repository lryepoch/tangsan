package com.green.crud.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.green.crud.bean.Employee;
import com.green.crud.bean.EmployeeExample;
import com.green.crud.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public PageInfo<Employee> getEmps(int pn, int page) {
        PageHelper.startPage(pn,page);
        List<Employee> list = employeeMapper.selectByExampleWithDept(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(list, 5);
        return pageInfo;
    }

    public int checkUserName(String name) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.or().andEmpNameEqualTo(name);
        int count = employeeMapper.countByExample(employeeExample);
        return count;
    }

    public int saveEmps(Employee employee) {
        int flag = employeeMapper.insertSelective(employee);
        return flag;
    }

    public Employee getEmp(int id) {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(id);
        return employee;
    }

    public int updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int deleteEmp(int empId) {
        return employeeMapper.deleteByPrimaryKey(empId);
    }

    public int deleteBatch(List<Integer> empIds) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.or().andEmpIdIn(empIds);
        int count = employeeMapper.deleteByExample(employeeExample);
        return count;
    }
}
