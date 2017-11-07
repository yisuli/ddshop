<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>
<script>
    $("#dg").datagrid({
       url:"items",
        striped:true,
        pagination:true,
        rownumbers:true,
        fit:true,
        pageSize:20,
        pageList:[20,50,100],
        columns:[[
            {field:'ck',checkbox:true},
            {field:"id",title:"商品编号",width:100},
            {field:"title",title:"商品名称",width:100},
            {field:"price",title:"价格",width:100,align:"right"}
        ]]
    });
</script>
