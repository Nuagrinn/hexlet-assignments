package exercise;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPost(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(post);
    }



    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        posts.add(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post post) {
        var oldPost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if(oldPost.isPresent()) {
            var post1 = oldPost.get();
            post1.setId(post.getId());
            post1.setBody(post.getBody());
            post1.setTitle(post.getTitle());
            return ResponseEntity.ok(post);
        } else {
            return new ResponseEntity<>(post, HttpStatus.NO_CONTENT);
        }
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
