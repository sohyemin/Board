package study.board.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.board.domain.user.dto.UserInfo;
import study.board.domain.user.dto.UserRequest;
import study.board.domain.user.repository.UserRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void createUser(UserRequest user) {
        userRepository.save(user.of());
    }

    @Override
    public List<UserInfo> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo getUser(Long userId) {
        return null;
    }

    @Override
    public void updateUser(Long userId, UserRequest user) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public void deleteAll() {

    }
}
