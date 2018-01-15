<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'role.jsp' starting page</title>
<link rel="stylesheet" href="../layui/css/layui.css">

</head>
<body>
	<div class="layui-contain">
		<div class="layui-row layui-col-space5">
			<div class="layui-col-xs4">
				<fieldset class="layui-elem-field layui-field-title">
					<legend>角色列表</legend>
				</fieldset>
				<table id="roledata">
					<input style="display:" id="getroleid" />
				</table>
			</div>
			<div class="layui-col-xs8">
				<fieldset class="layui-elem-field layui-field-title">
					<legend id="resourcetitle">权限列表</legend>
				</fieldset>
				<table id="resourcedata"></table>
			</div>
		</div>
	</div>
	<script src="../js/jquery-3.2.1.js"></script>
	<script src="../layui/layui.all.js"></script>
	<script type="text/javascript">
		$(function() {
			roledata();
			layui.use('form', function() {
			var form = layui.form;
			//各种基于事件的操作，下面会有进一步介绍
			form.on('switch', function(data) {
				var roleid = $("#getroleid").val();
				var resourceid = data.value;
				var flag = data.elem.checked;
				console.log(roleid);//拿到roleid
				console.log(flag); //开关是否开启，true或者false
				console.log(resourceid); //开关value值，也可以通过data.elem.value得到
				updateroleresource(roleid,resourceid,flag);
				if(flag){
					$("#layre"+resourceid).show();
				}else{
					$("#layre"+resourceid).hide();
				}
			});
			})
		})
		
		function updateroleresource(roleid,resourceid,flag){
				$.post("updateroleresource"
					,{"roleid":roleid,"resourceid":resourceid,"flag":flag}
					,function(obj){
						layer.msg(obj);
					})
		}
		
		//根据角色id导入权限
		function resourcedata(roleid,rolename) {
			$("#resourcetitle").html(rolename+"的权限列表");
			$("#getroleid").val(roleid);
			layui.table.render({
				url : "findAllResource",
				where : {"roleid":roleid},
				elem : '#resourcedata',
				id : 'resourcedata',
				height : 'full-220',
				cols : [ [ //标题栏
					{
						field : 'rid',
						title : '编号',
						width : 60,
						align : 'center'
					}
					, {
						field : 'rname',
						title : '权限名称',
						width : 140,
						edit : "text",
						templet : "#rname_temp"
					}
					, {
						field : 'parentId',
						title : '父模块ID',
						width : 80,
						align : 'center',
					}
					, {
						field : 'useable',
						title : '是否授权',
						align : 'center',
						width : 100,
						templet : "#accredit_templet"
					}
					, {
						field : 'resourcelist',
						title : '具体权限',
						align : 'left',
						width : 400,
						templet : "#resource_templet"
					}
				] ]
			})
		}
	
		//导入角色信息表
		function roledata() {
			layui.table.render({
				url : "findAllRole",
				elem : '#roledata',
				id : 'roledata',
				height : 'full-220',
				cols : [ [ //标题栏
					{
						field : 'rid',
						title : '编号',
						width : 60,
						align : 'center'
					}
					, {
						field : 'rname',
						title : '角色名',
						width : 140,
						align : 'center',
						edit : "text"
					}
					, {
						field : 'rolelist',
						title : '查看权限',
						align : 'center',
						width : 200,
						templet : "#role_templet"
					}
				] ]
			})
		}
	</script>
	
	<script type="text/html" id="rname_temp">
	{{#	if(d.parentId==0){				}}
		{{d.rname}}	 
	{{#	}else{						}}
		&nbsp;&nbsp;&nbsp;-->{{d.rname}}
	{{#	}							}}
	</script>
	<script type="text/html" id="role_templet">
	 <input type="button"  name="status" value="查看权限"  class="layui-btn layui-btn-sm" onclick="resourcedata({{d.rid}},'{{d.rname}}')";>
	</script>
	
	<script type="text/html" id="accredit_templet">
	{{#	 if(d.parentId!=0){							}}
	 <input type="checkbox"  name="status" value="{{ d.rid }}" lay-skin="switch" lay-text="授权|禁用" lay-filter="status" {{ d.select == 1 ? 'checked' : '' }}>
	{{#  }											}}
	</script>
	
	<script type="text/html" id="resource_templet">
	{{#	 if(d.select==1 && d.parentId!=0){							}}
	<div id="layre{{d.rid}}">
		<input type="checkbox" name="{{ d.rid }}" value="insert" title="增加权限" {{ d.insert == 1 ? 'checked' : '' }}/>
		<input type="checkbox" name="{{ d.rid }}" value="update" title="修改权限" {{ d.update == 1 ? 'checked' : '' }}/>
		<input type="checkbox" name="{{ d.rid }}" value="delete" title="删除权限" {{ d.delete == 1 ? 'checked' : '' }}/>
	</div>
	{{#  }else{										}}
	<div id="layre{{d.rid}}" style="display:none">
		<input type="checkbox" name="{{ d.rid }}" value="insert" title="增加权限" {{ d.insert == 1 ? 'checked' : '' }}/>
		<input type="checkbox" name="{{ d.rid }}" value="update" title="修改权限" {{ d.update == 1 ? 'checked' : '' }}/>
		<input type="checkbox" name="{{ d.rid }}" value="delete" title="删除权限" {{ d.delete == 1 ? 'checked' : '' }}/>
	</div>
	{{#  }											}}

</script>
</body>
</html>
