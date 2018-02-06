package com.spring.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.entities.Comment;

/**
 * 评论-数据量访问组件接口
 * @author wang_donggang
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
