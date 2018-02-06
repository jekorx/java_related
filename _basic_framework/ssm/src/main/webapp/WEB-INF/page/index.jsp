<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="page/util" prefix="page" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<style type="text/css">
		.pagination{text-align:center;list-style:none;margin:20px 0px;padding:0px;}
		.pagination>li{display:inline;}
		.pagination>li>a{font-family:"SimSun";padding:6px 12px;text-decoration:none;border:1px solid #d4d4d4;border-radius:0px!important;color:#2283c5;background-color:#fff;margin:0 -1px 0 0;}
		.pagination>li.active>a,.pagination>li.active>a:hover{background-color:#6faed9;border-color:#6faed9;color:#fff;}
		.pagination>li.disabled>a,.pagination>li.disabled>a:hover{background-color:#f7f7f7;border-color:#d9d9d9;color:#c5c5c5;cursor:not-allowed;}
		.pagination>li.disabled.ellipsis>a,.pagination>li.disabled.ellipsis>a:hover{font-family:"Microsoft YaHei";padding:3px 12px 4px;}
		.pagination>li.noStyle>input{width:30px;font-size:16px;margin:0px 5px;text-align:center;}
		.pagination>li.noStyle>a,.pagination>li.noStyle>a:hover{padding:0px;border:0px!important;}
	</style>
</head>
<body>
<table border="1">
	<c:forEach var="emp" items="${page.list }">
		<tr>
			<td>${emp.empId }</td>
			<td>${emp.name }</td>
			<td>${emp.sex }</td>
			<td>${emp.age }</td>
			<td>${emp.department.depId }</td>
			<td>${emp.department.depName }</td>
		</tr>
	</c:forEach>
	<tr>
		<td style="text-align:center" colspan="6">
			<page:page pageSize="${page.pageSize }" pageNo="${page.pageNum }" url="emp/getEmps/{pn}/{ps}" totalPage="${page.pages }"></page:page>
		</td>
	</tr>
</table>
<hr>
<table border="1">
	<tbody id="depTable"></tbody>
	<tfoot>
		<tr>
			<td style="text-align:center" colspan="2">
				<!-- 此处用于分页 -->
				<ul class="pagination" id="depPage"></ul>
			</td>
		</tr>
	</tfoot>
</table>
<button type="button" id="getDempBtn">获取部门json</button>
<script type="text/javascript" src="resources/libs/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript">
	$('#getDempBtn').click(function() {
		getDepList(1, gPageSize);
	});
function getDepList(pageNum, pageSize) {
	var table = $('#depTable').empty(),
		pn,
		ps,
		totalPage,
		i,
		j,
		d,
		e;
	$.ajax({
		url: 'dep/getAllDeps/' + pageNum + '/' + pageSize,
		type: 'get'
	}).success(function(result) {
		if (result.status == 'OK') {
			//alert(result.msg);
			d = result.data.list;
			pn = result.data.pageNum;
			ps = result.data.pageSize;
			totalPage = result.data.pages;
			if (d != null && d.length > 0) {
				for (i = 0; i < d.length; i++) {
					table.append(
						'<tr>' +
							'<td>' + d[i].depId + '</td>' +
							'<td>' + d[i].depName + '</td>' +
						'</tr>'
					);
				}
				// 调用分页工具 (当前页数：pn, 每页条数：ps, 总页数：totalPage, 点击后重新绘制页面)
				$('#depPage').page(pn, ps, totalPage, function(clickedPageNum) {
					getDepList(clickedPageNum, gPageSize);
				});
			}
		} else {
			alert(result.msg);
		}
	});
}
</script>
</body>
</html>
