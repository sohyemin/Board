package study.board.domain.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.board.domain.user.dto.UserInfo;
import study.board.domain.user.dto.UserRequest;
import study.board.domain.user.entity.User;
import study.board.domain.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
        return userRepository.findAll().stream()
                .map(UserInfo::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserInfo getUser(Long userId) {
        return null;
    }

    @Override
    public void updateUser(Long userId, UserRequest user) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> {
            log.error("대상이 존재하지 않습니다.");
            throw new RuntimeException("can't find a data by id : " + userId);
        });

        findUser.update(user.of());
        log.info("데이터 변경에 성공했습니다.");
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        log.info("데이터 삭제에 성공했습니다 : {}", userId);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
        log.info("모든 데이터가 삭제되었습니다.");
    }
}
