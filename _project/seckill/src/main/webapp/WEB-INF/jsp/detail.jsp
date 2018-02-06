<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/tags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="common/head.jsp"%>
    <title>${seckill.name}</title>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>${seckill.name}</h2>
        </div>
        <div class="panel-body">
            <h3 class="text-center text-danger">
                <span class="glyphicon glyphicon-time"></span>
                <span class="glyphicon" id="seckill-box"></span>
            </h3>
        </div>
    </div>
</div>
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" class="form-control" id="killPhoneKey" placeholder="填写手机号">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <span class="glyphicon" id="killPhoneMessage"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>Submit
                </button>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="common/foot.jsp"%>
<!-- cookie操作 -->
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- 倒计时 -->
<script src="https://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<!--引入js-->
<script src="/resources/js/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function() {
        seckill.detail.init({
            seckillId: ${seckill.seckillId},
            startTime: ${seckill.startTime.time},
            endTime: ${seckill.endTime.time}
        });
    });
</script>
</html>