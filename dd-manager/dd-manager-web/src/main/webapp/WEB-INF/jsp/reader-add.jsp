<%--
  User: Administrator
  Date: 2017/11/16
  Time: 8:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">读者昵称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="r_name" name="r_name"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td class="label">读者密码：</td>
                <td>
                    <input class="easyui-validatebox" type="password" id="r_pwd" name="r_pwd"
                            data-options="required:true,validType:'length[6,20]'">
                </td>
            </tr>
            <tr>
                <td class="label">确认密码：</td>
                <td>
                    <input class="easyui-validatebox" type="password" id="r_rpwd" name="r_rpwd"
                           required="required" validType="equals['#r_pwd']">
                </td>
            </tr>
            <tr>
                <td class="label">读者手机：</td>
                <td>
                    <input id="r_phone" class="easyui-validatebox" data-options="required:true,validType:'mobile'" />
                </td>
            </tr>
            <tr>

            </tr>
            <tr>

            </tr>
            <tr>

            </tr>
            <tr>

            </tr>

            <tr>

            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
        <input name="paramData" id="paramData" style="display:none;">
    </form>
</div>
<script>
    $.extend($.fn.validatebox.defaults.rules, {
        equals: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: '密码不一致'
        },
        mobile: {//value值为文本框中的值
            validator: function (value) {
                var reg = /^1[3|4|5|7|8|9]\d{9}$/;
                return reg.test(value);
            },
            message: '号码格式不正确'
        }
    });
</script>
