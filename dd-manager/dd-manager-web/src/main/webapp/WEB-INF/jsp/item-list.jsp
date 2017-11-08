<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>
<script>
    var toolbar = [{
        iconCls: 'icon-add',
        text: '新增',
        handler: function () {
            console.log('add');
        }
    }, {
        iconCls: 'icon-remove',
        text: '删除',
        handler: function () {
            var selections = $('#dg').datagrid('getSelections');
            console.log(selections);
            if (selections.length == 0) {
                //客户没有选择记录
                $.messager.alert('提示', '请至少选中一条记录！');
                return;
            }
            //至少选中了一条记录
            //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
            //function(r) 如果用户点击的是"确定"，那么r=true
            $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                if (r) {
                    //为了存放id的集合
                    var ids = [];
                    //遍历选中的记录，将记录的id存放到js数组中
                    for (var i = 0; i < selections.length; i++) {
                        ids.push(selections[i].id);
                    }
                    //把ids异步提交到后台
                    $.post(
                        //url:请求后台的哪个地址来进行处理，相当于url,String类型
                        'items/batch',
                        //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                        {'ids[]':ids},
                        //callback:后台处理成功的回调函数，相当于success，function类型
                        function(data){
                            //alert(data);
                            $('#dg').datagrid('reload');
                        },
                        //dataType:返回的数据类型，如：json，String类型
                        'json'
                    );

                }
            });
        }
    }, {
        iconCls: 'icon-edit',
        text: '编辑',
        handler: function () {
            console.log('edit');
        }
    }, {
        iconCls: 'icon-up',
        text: '上架',
        handler: function () {
            var selections = $('#dg').datagrid('getSelections');
            //console.log(selections);
            if (selections.length == 0) {
                //客户没有选择记录
                $.messager.alert('提示', '请至少选中一条记录！');
                return;
            }
            //至少选中了一条记录
            //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
            //function(r) 如果用户点击的是"确定"，那么r=true
            $.messager.confirm('确认', '您确认想要上架商品吗？', function (r) {
                if (r) {
                    //为了存放id的集合
                    var ids = [];
                    //遍历选中的记录，将记录的id存放到js数组中
                    for (var i = 0; i < selections.length; i++) {
                        ids.push(selections[i].id);
                    }
                    //把ids异步提交到后台
                    $.post(
                        //url:请求后台的哪个地址来进行处理，相当于url,String类型
                        'items/batchup',
                        //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                        {'ids[]':ids},
                        //callback:后台处理成功的回调函数，相当于success，function类型
                        function(data){
                            //alert(data);
                            $('#dg').datagrid('reload');
                        },
                        //dataType:返回的数据类型，如：json，String类型
                        'json'
                    );

                }
            });
        }
    }, {
        iconCls: 'icon-down',
        text: '下架',
        handler: function () {
            var selections = $('#dg').datagrid('getSelections');
            //console.log(selections);
            if (selections.length == 0) {
                //客户没有选择记录
                $.messager.alert('提示', '请至少选中一条记录！');
                return;
            }
            //至少选中了一条记录
            //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
            //function(r) 如果用户点击的是"确定"，那么r=true
            $.messager.confirm('确认', '您确认想要下架商品吗？', function (r) {
                if (r) {
                    //为了存放id的集合
                    var ids = [];
                    //遍历选中的记录，将记录的id存放到js数组中
                    for (var i = 0; i < selections.length; i++) {
                        ids.push(selections[i].id);
                    }
                    //把ids异步提交到后台
                    $.post(
                        //url:请求后台的哪个地址来进行处理，相当于url,String类型
                        'items/batchdown',
                        //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                        {'ids[]':ids},
                        //callback:后台处理成功的回调函数，相当于success，function类型
                        function(data){
                            //alert(data);
                            $('#dg').datagrid('reload');
                        },
                        //dataType:返回的数据类型，如：json，String类型
                        'json'
                    );

                }
            });
        }
    }];
    $("#dg").datagrid({
       url:"items",
        toolbar: toolbar,
        striped:true,
        pagination:true,
        rownumbers:true,
        fit:true,
        pageSize:20,
        pageList:[20,50,100],
        columns:[[
            {field:'ck',checkbox:true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100},
            {field: 'sellPoint', title: '卖点', width: 100},
            {field: 'status', title: '状态', width: 100,formatter:function(value,row,index){
                console.group();
                console.log(value);
                console.log(row);
                console.log(index);
                console.groupEnd();
                switch (value){
                    case 1:
                        return '正常';
                        break;
                    case 2:
                        return '下架';
                        break;
                    case 3:
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            {field: 'catName', title: '分类名称', width: 100},
            {field: 'price', title: '价格', width: 100},
            {field: 'created', title: '创建时间', width: 100,formatter:function(value,row,index){
                return moment(value).format('LLL');
            }},
            {field: 'updated', title: '修改时间', width: 100,formatter:function(value,row,index){
                return moment(value).format('LLL');
            }}
        ]]
    });
</script>
