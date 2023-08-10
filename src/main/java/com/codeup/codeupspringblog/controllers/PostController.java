package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;

    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }




    @GetMapping("/posts")
//    @ResponseBody
    public String posts(Model model) {

        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

        @GetMapping("/posts/show/{id}")
//    @ResponseBody
    public String postId(@PathVariable long id, Model model) {

//        Post post = postDao.findById(id);
            Post post = postDao.findById(id);
        model.addAttribute("post", post);

        return "posts/show";
        }

        @GetMapping("/posts/create")
//    @ResponseBody
    public String createPost(Model model) {
        //We have to use this to create an empty post to bind to the form data
//            Post post = new Post();
//            postDao.save(post);
            model.addAttribute("post", new Post());

        return "posts/create";
        }

        @PostMapping("/posts/create")
    public String postPost(@ModelAttribute Post post) {
            User user = userDao.findUserById(1);

            Post newPost = new Post(post.getTitle(), post.getBody(), user);


        postDao.save(newPost);

        return "redirect:/posts";
        }

    @GetMapping("/posts/edit/{id}")
    public String createEdit(@PathVariable long id, Model model) {
        Optional<Post> optionalPost = Optional.ofNullable(postDao.findById(id));

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "posts/edit";
        } else {
            // Handle the case where the post is not found
            // You might redirect or show an error message
            return "redirect:/posts"; // For example, redirect back to the posts list
        }
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@ModelAttribute Post editedPost){
        Post existingPost = postDao.findById(editedPost.getId()).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        existingPost.setTitle(editedPost.getTitle());
        existingPost.setBody(editedPost.getBody());

        postDao.save(existingPost);

        return "redirect:/posts";
    }


}
