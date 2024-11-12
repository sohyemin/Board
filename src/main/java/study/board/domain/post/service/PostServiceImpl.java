package study.board.domain.post.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.board.domain.post.dto.PostRequest;
import study.board.domain.post.dto.PostResponce;
import study.board.domain.post.repository.PostRepository;
import study.board.domain.user.entity.User;
import study.board.domain.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void createPost(PostRequest postRequest) {
        User findUser = userRepository.findById(postRequest.getUser_id())
                .orElseThrow(() -> {
                            log.error("대상이 존재하지 않습니다.");
                            throw new RuntimeException("There is no user : " + postRequest.getUser_id());
                        }
                );

        postRepository.save(postRequest.mapToEntity(findUser));
        log.info("포스트 완료");
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponce> getPostList() {
        return postRepository.findAll().stream()
                .map(PostResponce::mapToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponce> getPostByUserId(Long userId) {

        return postRepository.findByUser(
                userRepository.findById(userId)
                        .orElseThrow(() -> {
                            log.error("대상이 존재하지 않습니다.");
                            throw new RuntimeException("There is no user : " + userId);
                        })
        ).stream().map(PostResponce::mapToDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponce getPostByPostId(Long postId){
        return PostResponce.mapToDto(
                postRepository.findById(postId)
            .orElseThrow(() -> {
        log.error("대상이 존재하지 않습니다.");
        throw new RuntimeException("Can't find post By id : " + postId);
        })
        );
    }

    @Override
    public void updatePost(Long postId, PostRequest postRequest) {

    }

    @Override
    public void deleteById(Long postId) {

    }

    @Override
    public void deleteAll() {

    }
}
