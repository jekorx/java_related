<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="common/head.jsp"%>
    <title>list</title>
</head>
<body>
    <div class="container">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h3>秒杀商品列表</h3>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>商品名称</th>
                            <th>秒杀数量</th>
                            <th>秒杀开始时间</th>
                            <th>秒杀结束时间</th>
                            <th>秒杀创建时间</th>
                            <th>详情</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sk" items="${list}">
                            <tr>
                                <td>${sk.name}</td>
                                <td>${sk.number}</td>
                                <td>
                                    <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td>
                                    <a href="/seckill/${sk.seckillId}/detail" class="btn btn-info" target="_blank">link</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
<%@ include file="common/foot.jsp"%>
</html>