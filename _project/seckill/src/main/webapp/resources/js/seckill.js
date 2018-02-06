var seckill = {
    // 封装秒杀相关ajax的url
    url: {
        now: function() {
            return '/seckill/time/now';
        },
        exposer: function(id) {
            return '/seckill/' + id + '/exposer';
        },
        execution: function(id, md5) {
            return '/seckill/' + id + '/' + md5 + '/execution';
        }
    },
    // 封装详情页秒杀逻辑
    detail: {
        init: function(params) {
            var phone = $.cookie('phone');
            // 验证手机号
            if (!seckill.validatePhone(phone)) {
                var killPhoneModal = $('#killPhoneModal');
                killPhoneModal.modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
                $('#killPhoneBtn').click(function() {
                    var inputPhone = $('#killPhoneKey').val();
                    if (seckill.validatePhone(inputPhone)) {
                        $.cookie('phone', inputPhone, {expires: 7, path: '/seckill'});
                        window.location.reload();
                    } else {
                        $('#killPhoneMessage').hide()
                            .html('<label class="label label-danger">手机号错误</label>')
                            .show(300);
                    }
                });
            } else {
                // 已登录
                // 计时交互
                var seckillId = params['seckillId'],
                    startTime = params['startTime'],
                    endTime = params['endTime'];
                $.get(seckill.url.now(), {}, function(res) {
                    if (res.code == 0) {
                        seckill.countDown(seckillId, res.data, startTime, endTime);
                    } else {
                        console.log(res.msg);
                    }
                }, 'json');
            }
        }
    },
    seckillHandler: function(seckillId, node) {
        node.hide()
            .html('<button class="btn btn-primary btn-large" id="killBtn">开始秒杀</button>');
        $.post(seckill.url.exposer(seckillId), {}, function(res) {
            if (res.code == 0) {
                var exposer = res.data;
                if (exposer.exposed) {
                    var md5 = exposer.md5;
                    $('#killBtn').one('click', function() {
                        $(this).addClass('disabled');
                        $.post(seckill.url.execution(seckillId, md5), {}, function(result){
                            if (result.code == 0) {
                                var killResult = result.data,
                                    stateInfo = killResult.stateInfo;
                                node.html('<span class="label label-success">' + stateInfo + '</span>');
                            } else if (result.code > 0) {
                                node.html('<span class="label label-danger">' + result.msg + '</span>');
                            } else {
                                console.log(result.msg);
                            }
                        }, 'json');
                    });
                    node.show();
                } else {
                    seckill.countDown(seckillId, exposer.now, exposer.start, exposer.end);
                }
            } else {
                console.log(res.msg);
            }
        }, 'json');
    },
    countDown: function(seckillId, now, start, end) {
        var seckillBox = $('#seckill-box');
        if (now > end) {
            seckillBox.html("秒杀结束！");
        } else if (now < start) {
            var killTime = new Date(start + 1000);
            seckillBox.countdown(killTime, function(event) {
                var fmt = event.strftime('秒杀倒计时：%D天 %H小时 %M分 %S秒');
                seckillBox.html(fmt);
            }).on('finish.countdown', function() {
                seckill.seckillHandler(seckillId, seckillBox);
            });
        } else {
            seckill.seckillHandler(seckillId, seckillBox);
        }
    },
    validatePhone: function(phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        } else {
            return false;
        }
    }
};
