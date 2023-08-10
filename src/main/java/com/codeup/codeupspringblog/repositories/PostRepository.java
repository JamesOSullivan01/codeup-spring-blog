package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
//How we access the DAO in spring boot
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
}
