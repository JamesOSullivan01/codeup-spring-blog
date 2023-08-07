package com.codeup.codeupspringblog.controllers;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
//    @ResponseBody
    public String posts(Model model) {

        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Title 1", "Body 1"));
        posts.add(new Post("Title 2", "Body 2"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

        @GetMapping("/posts/{id}")
//    @ResponseBody
    public String postId(@PathVariable String id, Model model) {

        Post post = new Post("Sample Title", "Sample Body");
        model.addAttribute("posts", post);

        return "posts/show";
        }

//        @GetMapping("/posts/create")
////    @ResponseBody
//    public String createPost(@PathVariable String create) {
//
//
//        return "Forms for creating posts";
//        }
//
//        @PostMapping("/posts/create")
////    @ResponseBody
//    public Object postPost(@PathVariable String createPost) {
//
//
//        return "Forms for creating posts";
//        }


}
