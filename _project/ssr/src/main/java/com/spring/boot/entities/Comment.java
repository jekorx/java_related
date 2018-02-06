package com.spring.boot.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 评论实体类
 * @author wang_donggang
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

	private static final long serialVersionUID = 8472465299551096120L;

	@Id
	@GeneratedValue
	private int id;
	// 文章id
	@Column(name = "aid")
	private int aid;
	// 评论用户id
	@Column(name = "uid")
	private int uid;
	// 评论内容
	@Column(name = "comment")
	private String comment;
	// 评论时间
	@Column(name = "time")
	private String time;

	public Comment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
