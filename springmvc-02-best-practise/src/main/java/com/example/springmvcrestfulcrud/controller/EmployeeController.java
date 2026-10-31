package com.example.springmvcrestfulcrud.controller;

import com.example.springmvcrestfulcrud.bean.Employee;
import com.example.springmvcrestfulcrud.common.R;
import com.example.springmvcrestfulcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*
* CORS policy:跨域资源共享策略
*浏览器为了确认安全,默认遵循同源策略(请求要去的服务器和当前项目所在的服务器是同一个源(同一个服务器),如果不是,浏览器会阻止请求)
*
* 浏览器:localhost:/employee/1
* 页面商要发的请求:localhost:8080/employee/1
*   /以前的东西必须完全一样,浏览器才能发送请求
*
* 跨域问题
*1.前端自己解决
* 2.后端解决:允许前端跨域请求
*  原理:服务器给浏览器中添加字段:Access-Control-Allow-Origin=*
* */

@CrossOrigin//允许前端跨域请求
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /*
    *code:业务的状态码,200是,剩下都是失败,前后端一起商订不同的业务状态显示不同的效果
    * msg:"msg"是业务的描述信息,比如,查询成功,删除失败,新增失败等"
    * data:"data"服务器返回的数据,比如,查询成功,删除失败,新增失败等
    * {
    *
    *   "code":200,
    *  "msg":"查询成功",
    * "data":{
    *     "id":1,
    *     "name":"张三",
    *  }
    *
    * 前端统一处理,接受服务器数据
    *  1.前端发送请求,接受服务器数据
    * 2.判断状态码,成功就显示数据,失败就显示提示消息
    * */


    //@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/employee/{id}")
    public R get(@PathVariable("id") Long id) {
        System.out.println("查询用户,目标方法执行.....");

        Employee employeeById = employeeService.getEmployeeById(id);//调用service层的方法
        return R.ok(employeeById);
    }
@DeleteMapping(value = "/employee/{id}")
    //@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return R.ok();
    }
    //@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)

    public String update(@PathVariable("id") Long id, Employee employee) {
        employeeService.updateEmployee(employee);
        return "ok";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public R save(@RequestBody  Employee employee) {
        employeeService.saveEmployee(employee);
        return R.ok();
    }
    //查询所有员工
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public R all(){
        employeeService.getAllEmployees();
        return R.ok();
    }
}
