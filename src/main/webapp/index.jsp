<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>新闻热点事件排行榜</title>
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/demo/demo.css">
</head>
<body>
<input type="text" name="hotcontent" /> <input type="button" name="btn_hotcontent" onclick="seachByhotcontent()" value="查询"/>
<table id="dg" title="My Hots" class="easyui-datagrid" style="width:700px;height:450px"
       url="hot/getHots"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="keyword" width="50">热点主题</th>
        <th field="hotcontent" width="50">关键词</th>
        <th field="searchsum" width="50">搜索指数</th>
        <th field="createdate" width="50">创建时间</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newHot()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editHot()">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeHot()">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="showHot()">查看评论</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">Hot Information</div>
    <form id="fm" method="post" novalidate>
        <div class="fitem">
            <label>热点主题:</label>
            <input name="keyword" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>关键字:</label>
            <input name="hotcontent" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>搜索指数:</label>
            <input name="searchsum">
        </div>
        <div class="fitem">
            <label>创建时间:</label>
            <input name="createdate" class="easyui-validatebox" type="date">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveHot()">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
</body>
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<style type="text/css">
    #fm{
        margin:0;
        padding:10px 30px;
    }
    .ftitle{
        font-size:14px;
        font-weight:bold;
        color:#666;
        padding:5px 0;
        margin-bottom:10px;
        border-bottom:1px solid #ccc;
    }
    .fitem{
        margin-bottom:5px;
    }
    .fitem label{
        display:inline-block;
        width:80px;
    }
</style>

<script type="text/javascript">
    function showHot() {
        url="com/showcomments?id="+row.id;
    }
    
    function seachByhotcontent() {
        $.getJSON("hot/getHotsSeach", {hotcontent: $("input[name='hotcontent']").val()}, function (result) {
                $('#dg').datagrid('reload');
        });
    }
    
    var url;
    function newHot(){
        $('#dlg').dialog('open').dialog('setTitle','New Hot');
        $('#fm').form('clear');
        url = 'hot/save_hot';
    }
    function editHot(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('setTitle','Edit Hot');
            $('#fm').form('load',row);
            url = 'hot/update_hot?id='+row.id;
        }
    }
    function saveHot(){
        $('#fm').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.success){
                    $('#dlg').dialog('close');		// close the dialog
                    $('#dg').datagrid('reload');	// reload the hot data
                } else {
                    $.messager.show({
                        title: 'Error',
                        msg: result.msg
                    });
                }
            }
        });
    }
    function removeHot(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('Confirm','确定要删除吗?',function(r){
                if (r){
                    $.post('hot/remove_hot',{id:row.id},function(result){
                        if (result.success){
                            $('#dg').datagrid('reload');	// reload the hot data
                        } else {
                            $.messager.show({	// show error message
                                title: 'Error',
                                msg: result.msg
                            });
                        }
                    },'json');
                }
            });
        }
    }
</script>
</html>
