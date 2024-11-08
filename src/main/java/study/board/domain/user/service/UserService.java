package study.board.domain.user.service;

import study.board.domain.user.dto.UserInfo;
import study.board.domain.user.dto.UserRequest;

import java.util.List;

public interface UserService {

    //Create
    public void createUser(UserRequest user);

    //Read
    public List<UserInfo> getUserList();
    public UserInfo getUser(Long userId);

    //Update
    public void updateUser(Long userId, UserRequest user);

    //Delete
    public void deleteUser(Long userId);
    public void deleteAll();
}
