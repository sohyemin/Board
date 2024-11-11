package study.board.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import study.board.domain.user.dto.UserInfo;
import study.board.domain.user.dto.UserRequest;
import study.board.domain.user.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void signUp(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        log.info("유저 생성에 성공했습니다 : {}", userRequest.getName());
    }

    @GetMapping("/user")
    public List<UserInfo> getUserList() {
        return userService.getUserList();
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") Long userId,
                               @RequestBody UserRequest userRequest){
        userService.updateUser(userId, userRequest);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
    }

    @DeleteMapping("/user")
    public void deleteUserAll() {
        userService.deleteAll();
    }
}
