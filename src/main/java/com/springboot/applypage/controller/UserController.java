package com.springboot.applypage.controller;

import com.springboot.applypage.data.dto.ChangeUserDto;
import com.springboot.applypage.data.dto.UserDto;
import com.springboot.applypage.data.entity.User;
import com.springboot.applypage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<UserDto> getUser(Long sid){
        UserDto userDto = userService.getUser(sid);
        System.out.println(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(savedUser);
    }

    @PutMapping()
    public ResponseEntity<UserDto> changeUser(
            @RequestBody ChangeUserDto changeUserDto) throws Exception{
        UserDto userDto = userService.changeUser(
                changeUserDto.getSid(),
                changeUserDto.getRole());
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(Long sid) throws Exception{
        userService.deleteUser(sid);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
