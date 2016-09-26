<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'dataDicManage.jsp' starting page</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;

	function openAddDataDicDialog() {
		$('#dlg').dialog({
			title : '添加数据字典',
			width : 650,
			height : 200,
			closed : false,
			cache : false,
			modal : true
		});
		url = '${pageContext.request.contextPath}/dataDic/save.do';
	}

	function saveDataDic() {
		var datadicname = $("#datadicname").combobox("getText");
		var datadicvalue = $("#datadicvalue").val();
		if (datadicname == "" || datadicname == null) {
			$.messager.alert('系统提示', '数据字典名不能为空！');
			return;
		}
		if (datadicvalue == "" || datadicvalue == null) {
			$.messager.alert('系统提示', '数据字典值不能为空！');
			return;
		}

		$.post(url, {
			datadicname : datadicname,
			datadicvalue : datadicvalue
		}, function(result) {
			if (result.success) {
				$.messager.alert('系统提示', '保存成功！');
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
				resetValue();
			} else {
				$.messager.alert('系统提示', '保存失败！');
			}
		}, "json");
	}

	function openDataDicModifyDialog() {
		var selectedRows = $('#dg').datagrid('getSelections');
		if (selectedRows.length != 1) {
			$.messager.alert('系统提示', '请选择要修改的数据!');
			return;
		}
		var row = selectedRows[0];

		$('#dlg').dialog({
			title : '修改数据字典',
			width : 650,
			height : 200,
			closed : false,
			cache : false,
			modal : true
		});
		$('#fm').form('load', row);
		url = '${pageContext.request.contextPath}/dataDic/save.do?id=' + row.id;
	}

	function deleteDataDicDialog() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if (selectedRows.length == 0) {
			$.messager.alert('系统提示', '请选择要删除的数据!');
			return;
		}
		var strIds = [];
		for ( var i = 0; i < selectedRows.length; i++) {
			strIds.push(selectedRows[i].id);
		}

		var ids = strIds.join(",");

		$.messager.confirm('系统提示', "您确定要删除这<font color=red>"
				+ selectedRows.length + "</font>条数据吗？", function(r) {
			if (r) {
				$.post('${pageContext.request.contextPath}/dataDic/delete.do',
						{
							ids : ids
						}, function(result) {
							if (result.success) {
								$.messager.alert('系统提示', '数据删除成功！');
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert('系统提示', '数据删除失败，请联系系统管理员！');
							}
						}, "json");
			}
		});
	}

	function searchDataDic(){
		 $("#dg").datagrid('load',{
		 	"datadicname":$("#s_datadicname").combobox('getValue'),
		 	"datadicvalue":$("#s_datadicvalue").val()
		 });
	}

	function closeDataDicDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}

	function resetValue() {
		$("#datadicname").combobox("setValue", "");
		$("#datadicvalue").val("");
	}
</script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="margin: 1px">
	<table id="dg" class="easyui-datagrid" toolbar='#tb' fitColumns="true"
		url="${pageContext.request.contextPath}/dataDic/list.do"
		pagination="true" rownumbers="true" fit="true">
		<thead>
			<tr>
				<th checkbox="true" align="center"></th>
				<th data-options="field:'id'" width='50' align="center">编号</th>
				<th data-options="field:'datadicname'" width="100" align="center">数据字典</th>
				<th data-options="field:'datadicvalue'" width="100" align="center">数据字典值</th>
			</tr>
		</thead>
	</table>

	<div id="tb">
		<div>
			<a href="javascript:openAddDataDicDialog()" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true">添加</a> <a
				href="javascript:openDataDicModifyDialog()"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true">修改</a> <a
				href="javascript:deleteDataDicDialog()" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true">删除</a>
		</div>

		<div>
			数据字典名：<input id="s_datadicname" name="s_datadicname"
				class="easyui-combobox"
				data-options="panelHeight:'auto', valueField:'datadicname',textField:'datadicname',url:'${pageContext.request.contextPath}/dataDic/findDataDicName.do'" />
			数据字典值： <input id="s_datadicvalue" name="s_datadicvalue"
				class="easyui-validatebox" data-options="required:true" />
				<a href="javascript:searchDataDic()" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog" style="width:400px;height:200px;"
		data-options="resizable:true,modal:true" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<tr>
				<td>数据字典名：</td>
				<input id="datadicname" name="datadicname" class="easyui-combobox"
					data-options="panelHeight:'auto', valueField:'datadicname',textField:'datadicname',url:'${pageContext.request.contextPath}/dataDic/findDataDicName.do'" />
				<td>数据字典值：</td>
				<input id="datadicvalue" name="datadicvalue"
					class="easyui-validatebox" data-options="required:true" />
			</tr>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:saveDataDic()" class="easyui-linkbutton"
			data-options="iconCls:'icon-save',plain:true">保存</a> <a
			href="javascript:closeDataDicDialog()" class="easyui-linkbutton"
			data-options="iconCls:'icon-cancel',plain:true">关闭</a>
	</div>
</body>
</html>
