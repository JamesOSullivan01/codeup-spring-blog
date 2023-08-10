package com.codeup.codeupspringblog.controllers;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
//            model.addAttribute("post", post);

        return "posts/create";
        }

        @PostMapping("/posts/create")
    public String postPost(@RequestParam String title, @RequestParam String body) {
            User user = userDao.findUserById(1);

            Post post = new Post(title, body, user);


        postDao.save(post);

        return "redirect:/posts";
        }
}
