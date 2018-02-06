//全局变量，每页分10条
var gPageSize = 10;
/*
 * 分页工具（必须在<ul class="pagination"></ul>中）
 * pageNum：当前第几页
 * pageSize：每页多少条
 * totalPage：总页数
 * calbak：回调函数，点击页面跳转，加载新数据的方法
 */
jQuery.fn.page = function(pageNum, pageSize, totalPage, calbak) {
    var $pager = $(this).empty(),
        firstEnable = pageNum != 1,
        prevEnable = pageNum - 1 > 0,
        nextEnable = totalPage - pageNum > 0,
        lastEnable = pageNum != totalPage,
        pages = '',
        showNum = 9,
        i,
        halfPage = (showNum - 3) / 2;

    pages += '<li class="' + (firstEnable ? '' : 'disabled') + '">' +
        '<a href="javascript:void(0)" page="1">&lt;&lt;</a>' +
        '</li>' +
        '<li class="' + (prevEnable ? '' : 'disabled') + '">' +
        '<a href="javascript:void(0)" page="' + (+pageNum - 1) + '">&lt;</a>' +
        '</li>';

    if (totalPage <= showNum) {
        for (i = 1; i <= totalPage; i++) {
            pages += '<li class="' + (i == pageNum ? 'active' : '') + '"><a href="javascript:void(0)" page="' + i + '">' + i + '</a></li>';
        }
    } else {
        if (pageNum - halfPage > 1) {
            pages += '<li class=""><a href="javascript:void(0)" page="1">1</a></li>';
            if (pageNum - halfPage > 2) {
                pages += '<li class="disabled ellipsis"><a href="javascript:void(0)">···</a></li>';
            }
            if (totalPage - pageNum - halfPage > 0) {
                for (i = pageNum - halfPage; i <= pageNum + halfPage; i++) {
                    pages += '<li class="' + (i == pageNum ? 'active' : '') + '"><a href="javascript:void(0)" page="' + i + '">' + i + '</a></li>';
                }
                if (totalPage - pageNum - halfPage > 1) {
                    pages += '<li class="disabled ellipsis"><a href="javascript:void(0)">···</a></li>';
                }
                pages += '<li class=""><a href="javascript:void(0)" page="' + totalPage + '" >' + totalPage + '</a></li>';
            } else {
                for (i = totalPage - showNum + 2; i <= totalPage; i++) {
                    pages += '<li class="' + (i == pageNum ? 'active' : '') + '"><a href="javascript:void(0)" page="' + i + '">' + i + '</a></li>';
                }
            }
        } else {
            for (i = 1; i < (totalPage > showNum ? showNum - 1 : showNum); i++) {
                pages += '<li class="' + (i == pageNum ? 'active' : '') + '"><a href="javascript:void(0)" page="' + i + '">' + i + '</a></li>';
            }
            if (totalPage - pageNum - halfPage > 2) {
                pages += '<li class="disabled ellipsis"><a href="javascript:void(0)">···</a></li>';
            }
            pages += '<li class=""><a href="javascript:void(0)" page="' + totalPage + '">' + totalPage + '</a></li>';
        }
    }

    pages += '<li class="' + (nextEnable ? '' : 'disabled') + '">' +
        '<a href="javascript:void(0)" page="' + (+pageNum + 1) + '">&gt;</a>' +
        '</li>' +
        '<li class="' + (lastEnable ? '' : 'disabled') + '">' +
        '<a href="javascript:void(0)" page="' + totalPage + '">&gt;&gt;</a>' +
        '</li>';

    /*pages += '<li class="noStyle">' +
        '（第<input type="text" value="' + pageNum + '">' +
        '<a href="javascript:void(0)" onclick="calbak(this.previousSibling.value)">跳转</a>' +
        '&nbsp;&nbsp;共' + totalPage + '页' + allCount + '条）</li>")' +
        '<li class="noStyle"></li>';*/

    $pager.append(pages);

    $pager.find('>li >a').click(function() {
        var item = $(this).parent();
        if (!item.hasClass('disabled') && !item.hasClass('active')) {
            calbak($(this).attr('page'));
        }
    });

    return $pager;
};

// 时间格式化
function toDate(date, fmt) {
    return date != null ? new Date(date).pattern(fmt || 'yyyy-MM-dd HH:mm:ss') : '';
}

// 时间格式化
Date.prototype.pattern = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份           
        "d+": this.getDate(), //日           
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时           
        "H+": this.getHours(), //小时           
        "m+": this.getMinutes(), //分           
        "s+": this.getSeconds(), //秒           
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度           
        "S": this.getMilliseconds() //毫秒           
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};

// 数组转json
function arrayToJson(o) {
    var r = [];
    if (typeof o == "string") return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
    if (typeof o == "object") {
        if (!o.sort) {
            for (var i in o)
                r.push(i + ":" + arrayToJson(o[i]));
            if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
                r.push("toString:" + o.toString.toString());
            }
            r = "{" + r.join() + "}";
        } else {
            for (var i = 0; i < o.length; i++) {
                r.push(arrayToJson(o[i]));
            }
            r = "[" + r.join() + "]";
        }
        return r;
    }
    return o.toString();
}