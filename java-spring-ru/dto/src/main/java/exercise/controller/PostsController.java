package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> getPosts() {
        // Получаем все комментарии
        List<Comment> comments = commentRepository.findAll();

        // Группируем комментарии по postId
        Map<Long, List<CommentDTO>> commentsByPostId = comments.stream()
                .collect(Collectors.groupingBy(
                        Comment::getPostId,
                        Collectors.mapping(this::toDTO, Collectors.toList())
                ));

        List<PostDTO> posts = postRepository.findAll().stream()
                .map(post -> {
                    PostDTO postDTO = toDTO(post);
                    List<CommentDTO> postComments = commentsByPostId.getOrDefault(post.getId(), List.of());
                    postDTO.setComments(postComments);
                    return postDTO;
                })
                .toList();

        return posts;
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO getPostById(@PathVariable Long id) {
        // Получаем пост по ID
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        // Получаем комментарии для данного поста
        List<CommentDTO> comments = commentRepository.findByPostId(post.getId())
                .stream()
                .map(this::toDTO)
                .toList();

        // Маппим пост в PostDTO
        PostDTO postDTO = toDTO(post);
        postDTO.setComments(comments); // Добавляем комментарии

        return postDTO;
    }

    private PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setBody(post.getBody());
        postDTO.setTitle(post.getTitle());
        postDTO.setId(post.getId());
        return postDTO;
    }

    private CommentDTO toDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setBody(comment.getBody());
        commentDTO.setId(comment.getId());
        return commentDTO;
    }

}
// END
