package com.spring.boot.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.config.domains.Result;
import com.spring.boot.config.domains.ResultEnum;
import com.spring.boot.entities.Article;
import com.spring.boot.models.ArticleModel;
import com.spring.boot.repositories.ArticleRepository;
import com.spring.boot.services.ArticleService;
import com.spring.boot.utils.ResultUtil;

/**
 * 文章相关控制器
 * @author wang_donggang
 */
@RestController
@RequestMapping("/app/v1/article")
public class ArticleController {
	
	// ArticleRepository注入
	@Autowired
	private ArticleRepository articleRepository;
	
	// ArticleService注入
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 保存(由于put请求无法使用formdata提交带有文件的请求，使用post请求同时添加和删除)
	 * @param model
	 * @param bindingResult
	 * @param request
	 * @return
	 */
	@PostMapping("")
	public Result<Article> save(@Valid ArticleModel model,
								BindingResult bindingResult,
								HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			// 如果验证失败，返回失败信息
			return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
		}
		Article article = articleService.save(model, request);
		return ResultUtil.success(article);
	}
	
	/**
	 * 分页查询
	 * @param pn
	 * @param ps
	 * @return
	 */
	@GetMapping("/{pn}/{ps}")
	public Result<Page<ArticleModel>> queryArticles(
			@PathVariable("pn") int pn,
			@PathVariable("ps") int ps) {
		Pageable pageable = new PageRequest(pn - 1, ps);
		Page<ArticleModel> page = articleService.queryArticles(pageable);
		return ResultUtil.success(page);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public Result<String> delete(@PathVariable("id") int id) {
		try {
			articleRepository.delete(id);
			return ResultUtil.success();
		} catch (EmptyResultDataAccessException ce) {
			return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS);
		} catch (Exception e) {
			return ResultUtil.error(ResultEnum.FAILED);
		}
	}
	
}
