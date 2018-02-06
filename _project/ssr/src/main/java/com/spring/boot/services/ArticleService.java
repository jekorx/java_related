package com.spring.boot.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.boot.config.domains.Constants;
import com.spring.boot.entities.Article;
import com.spring.boot.entities.User;
import com.spring.boot.models.ArticleModel;
import com.spring.boot.repositories.ArticleRepository;
import com.spring.boot.utils.CookieUtil;
import com.spring.boot.utils.DateUtil;
import com.spring.boot.utils.FileUtil;

/**
 * 文章业务逻辑处理
 * @author wang_donggang
 */
@Service
public class ArticleService {
	
	// 注入ArticleRepository
	@Autowired
	private ArticleRepository articleRepository;
	
	// 注入UserService
	@Autowired
	private UserService userService;
	
	/**
	 * 保存文章
	 * @param model
	 * @return
	 */
	public Article save(ArticleModel model, HttpServletRequest request) {
		// 根据Request获取cookie
		Cookie[] cookies = request.getCookies();
		// 获取token
		String token = CookieUtil.getCookieByKey(cookies, Constants.USER_TOKEN);
		// 获取用户信息
		User user = userService.getLoginUser(token);
		// 创建文章对象
		Article article = new Article();
		if (model.getId() != 0) {
			// 如果有id，为修改，将id赋值给Article对象
			article.setId(model.getId());
		}
		// 设置相关属性
		article.setTitle(model.getTitle());
		article.setUid(user.getId());
		String nowStr = DateUtil.getStrTimeNow();
		article.setCreateTime(nowStr);
		article.setModifyTime(nowStr);
		article.setLabel(model.getLabel());
		// 文章内容
		article.setContent(model.getContent());
		
		// 图片
		String imgUrl = FileUtil.fileUpload(model.getImg(), "article");
		article.setImgUrl(imgUrl);
		// 保存
		return articleRepository.save(article);
	}
	
	/**
	 * 分页查询业务逻辑
	 * @param pageable
	 * @return
	 */
	public Page<ArticleModel> queryArticles(Pageable pageable) {
		// 分页的结果
		Page<Object> page = articleRepository.queryArticles(pageable);
		// 获得分页对象中的结果
		List<Object> objList = page.getContent();
		// 存放结果的list
		List<ArticleModel> list = new ArrayList<ArticleModel>();
		// 遍历分页对象中的结果
		for (Object row : objList) {
			// 每一行数据被存放在数组中
			Object[] cells = (Object[]) row;
			// 将与查询语句中对应的顺序取出放到ArticleModel对象中，并add到list
			list.add(new ArticleModel(
					cells[0] != null ? Integer.parseInt(cells[0].toString()) : -1,
					cells[1] != null ? Integer.parseInt(cells[1].toString()) : -1,
					cells[2] != null ? cells[2].toString() : "",
					cells[3] != null ? cells[3].toString() : "",
					cells[4] != null ? cells[4].toString() : "",
					cells[5] != null ? cells[5].toString() : "",
					cells[6] != null ? cells[6].toString() : "",
					cells[7] != null ? cells[7].toString() : "",
					cells[8] != null ? cells[8].toString() : "",
					cells[9] != null ? Integer.parseInt(cells[9].toString()) : 0
					));
		}
		// 将转换后的结构重新组装到分页对象中，并返回
		return new PageImpl<ArticleModel>(list, pageable, page.getTotalElements());
	}
	
}
