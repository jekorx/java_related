package com.spring.boot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章实体类
 * @author wang_donggang
 */
@Entity
@Table(name = "articles")
public class Article implements Serializable {

	private static final long serialVersionUID = -4963463090269810252L;

	@Id
	@GeneratedValue
	private int id;
	// 标题
	private String title;
	// 用户id
	private int uid;
	// 创建时间
	@Column(name = "create_time")
	private String createTime;
	// 修改时间
	@Column(name = "modify_time")
	private String modifyTime;
	// 列表展示图片链接
	@Column(name = "img_url")
	private String imgUrl;
	// 标签
	private String label;
	// 内容
	@Column(name = "content")
	private String content;
	// 阅读数量
	@Column(name = "read_count")
	private int readCount;

	public Article() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
