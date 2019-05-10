//重新计算屏幕高度
$(function () {
    $(window).resize(function () {
        var scrollWidth = $(window).width();
        $('.right').width(scrollWidth - 242);
    }).resize();

    //一个导航卡打开后，其余的关闭
    $(".collapse").on('show.bs.collapse', function (){
        $("a", $(this).prev()).addClass('active');
        $(this).parent().siblings("div").children(".collapse").collapse('hide');
    });

    //真正打开后，关闭其他
    $(".collapse").on('shown.bs.collapse', function (){
        $(this).parent().siblings("div").children(".collapse").collapse('hide');
    });

    $(".collapse").on('hide.bs.collapse', function (){
        $("a", $(this).prev()).removeClass('active');
    });
});

//分页组件
$.fn.extend({
    // curPage 当前页数 pageSize 一页几条  totalCount 总条数
    page: function (options) {
        //初始化参数
        var curPage = options.curPage;
        var pageSize = options.pageSize;
        var totalCount = options.totalCount;
        var init = options.init;
        var callback = options.callback;
        //回调函数
        if (init == false) {
            if (callback) {
                callback(curPage);
            }
        } else{
            var _self = $(this);
            _self.empty();
            //计算最后的page
            var lastPage = Math.ceil(totalCount / pageSize);
            //前一页，第一页
            if (curPage > 1) {
                $('<li><a>&laquo;</a></li>').attr('onclick', '$(this).page({"curPage":1 ,"init": false, "callback":' + callback + '})').appendTo(_self);
                $('<li><a>&lt;</a></li>').attr('onclick', '$(this).page({"curPage":' + (curPage - 1) + ',"init": false, "callback":' + callback + '})').appendTo(_self);
            } else if (totalCount > 0) {
                $('<li><a>&laquo;</a></li>').attr("class", "disabled").appendTo(_self);
                $('<li><a>&lt;</a></li>').attr("class", "disabled").appendTo(_self);
            }
            // 当前页在最后5页中
            if (lastPage - curPage < 5) {
                for (var i = 4; i >= 0; i--) {
                    if (lastPage - i > 0) {
                        var li = $('<li/>').attr('onclick', '$(this).page({"curPage":' + (lastPage - i) + ',"init": false, "callback":' + callback + '})').appendTo(_self);
                        if (curPage == (lastPage - i)) {
                            li.addClass('active');
                        }
                        $('<a/>').text(lastPage - i).appendTo(li);
                        li.appendTo(_self);
                    }
                }
            } else {
                for (var i = 0; i < 5; i++) {
                    if (curPage + i <= lastPage) {
                        var li = $('<li/>').attr('onclick', '$(this).page({"curPage":' + (curPage + i) + ',"init": false, "callback":' + callback + '})').appendTo(_self);
                        if (i == 0) {
                            li.addClass('active');
                        }
                        $('<a/>').text(curPage + i).appendTo(li);
                        li.appendTo(_self);
                    }
                }
                if (lastPage - curPage != 5) {
                    $('<li><a>...</a></li>').attr('onclick', '$(this).page({"curPage":' + (curPage + 5) + ',"init": false, "callback":' + callback + '})').appendTo(_self);
                }
                $('<li><a>' + lastPage + '</a></li>').attr('onclick', '$(this).page({"curPage":' + lastPage + ',"init": false, "callback":' + callback + '})').appendTo(_self);
            }

            //最后一页，下一页
            if (curPage < lastPage) {
                $('<li><a>&gt;</a></li>').attr('onclick', '$(this).page({"curPage":' + (curPage + 1) + ',"init": false, "callback":' + callback + '})').appendTo(_self);
                $('<li><a>&raquo;</a></li>').attr('onclick', '$(this).page({"curPage":' + lastPage + ',"init": false, "callback":' + callback + '})').appendTo(_self);
            } else if (totalCount > 0) {
                $('<li><a>&gt;</a></li>').attr("class", "disabled").appendTo(_self);
                $('<li><a>&raquo;</a></li>').attr("class", "disabled").appendTo(_self);
            }
        }
    }
});

//查询结果显示
function formatUserRepo(repo) {
    if (repo.loading) return repo.text;
    var markup = "<div class='select2-result-repository clearfix'>" +
        "<div class='select2-result-repository__title'>" + repo.text + "</div>";

    if (repo.deptName) {
        markup += "<div class='select2-result-repository__description'>" + repo.deptName + "</div>";
    }
    return markup;
}

//选中结果显示
function formatUserRepoSelection(repo) {
    return repo.text;
}