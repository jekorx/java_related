package com.test.project.util.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageUtilTag extends SimpleTagSupport {
	// 请求url
	private String url;
	// url的pageNo占位符
	private final String pnFlg = "{pn}";
	// url的pageSize占位符
	private final String psFlg = "{ps}";
	// 总记录数
	//private int allCount = 0;
	// 总页数
	private int totalPage = 0;
	// 当前所在页数
	private int pageNo = 1;
	// 每页记录数
	private int pageSize = 10;
	// 显示的页码数量
	private final int showNum = 9;
	// 当前页前后页码的数量
	private final int halfNum = (showNum - 3) / 2;
	
	@Override
	public void doTag() throws JspException, IOException {
		this.url = this.url.replace(psFlg, this.pageSize + "");
		// 跳至第一页是否可用
		boolean firstEnable = this.pageNo != 1;
		// 跳至前一页是否可用
		boolean prevEnable = this.pageNo - 1 > 0;
		// 跳至下一页是否可用
		boolean nextEnable = totalPage - this.pageNo > 0;
		// 跳至最后一页是否可用
		boolean lastEnable = this.pageNo != totalPage;
		// 用于遍历计数
		int i;
		
		// 用于存放分页的内容
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("<ul class=\"pagination\">");
		
		strBuf.append("<li class=\"" + (firstEnable ? "" : "disabled") + "\">");
		strBuf.append("<a href=\"" + (firstEnable ? url.replace(pnFlg, "1") : "javascript:void(0)") + "\">&lt;&lt;</a>");
		strBuf.append("</li><li class=\"" + (prevEnable ? "" : "disabled") + "\">");
		strBuf.append("<a href=\"" + (prevEnable ? url.replace(pnFlg, this.pageNo - 1 + "") : "javascript:void(0)") + "\">&lt;</a>");
		strBuf.append("</li>");
		
		if (totalPage <= showNum) {
			for (i = 1; i <= totalPage; i++) {
				strBuf.append("<li class=\"" + (i == pageNo ? "active" : "") + "\"><a href=\"" + (i == pageNo ? "javascript:void(0)" : url.replace(pnFlg, i + "")) + "\">" + i + "</a></li>");
			}
		} else {
			if (pageNo - halfNum > 1) {
				strBuf.append("<li class=\"\"><a href=\"" + url.replace(pnFlg, 1 + "") + "\">1</a></li>");
				if (pageNo - halfNum > 2) {
					strBuf.append("<li class=\"disabled ellipsis\"><a href=\"javascript:void(0)\">···</a></li>");
				}
				if (totalPage - pageNo - halfNum > 0) {
					for (i = pageNo - halfNum; i <= pageNo + halfNum; i++) {
						strBuf.append("<li class=\"" + (i == pageNo ? "active" : "") + "\"><a href=\"" + (i == pageNo ? "javascript:void(0)" : url.replace(pnFlg, i + "")) + "\">" + i + "</a></li>");
					}
					if (totalPage - pageNo - halfNum > 1) {
						strBuf.append("<li class=\"disabled ellipsis\"><a href=\"javascript:void(0)\">···</a></li>");
					}
					strBuf.append("<li class=\"\"><a href=\"" + url.replace(pnFlg, totalPage + "") + "\">" + totalPage + "</a></li>");
				} else {
					for (i = totalPage - showNum + 2; i <= totalPage; i++) {
						strBuf.append("<li class=\"" + (i == pageNo ? "active" : "") + "\"><a href=\"" + (i == pageNo ? "javascript:void(0)" : url.replace(pnFlg, i + "")) + "\">" + i + "</a></li>");
					}
				}
			} else {
				for (i = 1; i <= (totalPage > showNum ? showNum - 1 : showNum); i++) {
					strBuf.append("<li class=\"" + (i == pageNo ? "active" : "") + "\"><a href=\"" + (i == pageNo ? "javascript:void(0)" : url.replace(pnFlg, i + "")) + "\">" + i + "</a></li>");
				}
				if (totalPage - pageNo - halfNum > 2) {
					strBuf.append("<li class=\"disabled ellipsis\"><a href=\"javascript:void(0)\">···</a></li>");
				}
				strBuf.append("<li class=\"\"><a href=\"" + url.replace(pnFlg, totalPage + "") + "\">" + totalPage + "</a></li>");
			}
		}
		
		strBuf.append("<li class=\"" + (nextEnable ? "" : "disabled") + "\">");
		strBuf.append("<a href=\"" + (nextEnable ? url.replace(pnFlg, this.pageNo + 1 + "") : "javascript:void(0)") + "\">&gt;</a>");
		strBuf.append("</li><li class=\"" + (lastEnable ? "" : "disabled") + "\">");
		strBuf.append("<a href=\"" + (lastEnable ? url.replace(pnFlg, totalPage + "") : "javascript:void(0)") + "\">&gt;&gt;</a>");
		strBuf.append("</li>");
		
		/*strBuf.append("<li class=\"noStyle\">");
		strBuf.append("（第<input id=\"pageNumber\" type=\"text\" value=\"" + this.pageNo + "\">");
		strBuf.append("<a href=\"javascript:void(0)\" ");
		strBuf.append("onclick=\"window.open(this.getAttribute('rel').replace('" + pnFlg + "', this.previousSibling.value),'_self')\" rel=\"" + url + "\">跳转</a>");
		strBuf.append("&nbsp;&nbsp;共" + totalPage + "页/" + this.allCount + "条）</li>");
		strBuf.append("<li class=\"noStyle\"></li>");*/
		
		strBuf.append("</ul>");
		
		getJspContext().getOut().write(strBuf.toString());
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	/*public void setAllCount(int allCount) {
		this.allCount = allCount;
	}*/
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
