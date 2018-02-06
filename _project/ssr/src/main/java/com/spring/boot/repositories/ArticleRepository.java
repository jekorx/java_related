package com.spring.boot.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.entities.Article;

/**
 * 文章-数据量访问组件接口
 * @author wang_donggang
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	// hql分页查询，Article和User关联
	@Query(value = "select "
				  + "a.id as id,"
			     + "a.uid as uid,"
			   + "u.uName as username,"
          + "a.createTime as createtime,"
          + "a.modifyTime as modifytime,"
              + "a.imgUrl as imgurl,"
               + "a.title as title,"
               + "a.label as label,"
             + "a.content as content,"
           + "a.readCount as readcount "
          + "from Article as a, User as u where a.uid = u.id")
	public Page<Object> queryArticles(Pageable pageable);

	
}
