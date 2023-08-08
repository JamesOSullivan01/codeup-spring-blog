package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
//    @ResponseBody
    public String posts(Model model) {

        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

        @GetMapping("/posts/{id}")
//    @ResponseBody
    public String postId(@PathVariable int id, Model model) {

        Post post = new Post("Sample Title", "Sample Body");
        model.addAttribute("posts", post);

        return "posts/show";
        }

        @GetMapping("/posts/create")
//    @ResponseBody
    public String createPost(Model model) {
        //We have to use this to create an empty post to bind to the form data
            Post post = new Post();
            model.addAttribute("post", post);

        return "posts/create";
        }

        @PostMapping("/posts/create")
    public Object postPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        postDao.save(post);

        return "redirect:/posts";
        }


}
