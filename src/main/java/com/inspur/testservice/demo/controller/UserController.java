package com.inspur.testservice.demo.controller;

import com.inspur.testservice.demo.domain.UserDomain;
import com.inspur.testservice.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户",notes = "根据UserDomain对象创建用户")
    @PostMapping("/add")
    public int addUser(UserDomain user) {
        return userService.addUser(user);
    }

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("{id}")

    public UserDomain getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

}
