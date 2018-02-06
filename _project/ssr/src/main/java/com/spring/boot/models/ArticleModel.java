package com.spring.boot.models;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文章模型
 * @author wang_donggang
 */
public class ArticleModel {
	// 文章id
	private int id;
	// 用户id
	private int uid;
	// 用户名
	private String username;
	// 创建时间
	private String createTime;
	// 修改时间
	private String modifyTime;
	// 列表展示图片链接
	private String imgUrl;
	// 标题
	@NotNull(message = "标题不能为空")
	private String title;
	// 列表展示图片链接
	private MultipartFile img;
	// 标签
	private String label;
	// 内容
	@NotNull(message = "内容不能为空")
	private String content;
	// 阅读量
	private int readCount;

	public ArticleModel() {
	}

	public ArticleModel(int id,
						int uid,
					 String username,
					 String createTime,
					 String modifyTime,
					 String imgUrl,
					 String title,
					 String label,
					 String content,
						int readCount) {
		this.id = id;
		this.uid = uid;
		this.username = username;
		this.createTime = createTime;
		this.modifyTime = modifyTime;
		this.imgUrl = imgUrl;
		this.title = title;
		this.label = label;
		this.content = content;
		this.readCount = readCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

}
