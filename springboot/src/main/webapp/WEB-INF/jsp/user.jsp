<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'user.jsp' starting page</title>
<link rel="stylesheet" href="layui/css/layui.css?Math.random()">
</head>

<body>
	<div class="demoTable">
		搜索名称：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="demoReload"
				autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload" >搜索</button>
	</div>
	<table id="userdata" lay-data="{id: 'idTest'}"></table>
</body>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../layui/layui.all.js"></script>
<script type="text/javascript">
	$(function() {
		loadData();
	})


	function loadData() {
		layui.table.render({
			url : "user/userlistdatabypage",
			elem : '#userdata',
			page : true,
			id : 'testReload',
			cols : [ [ //标题栏
				{
					checkbox : true
				}
				, {
					field : 'uid',
					title : '编号',
					width : 80
				}
				, {
					field : 'uname',
					title : '账户',
					width : 120
				}
				, {
					field : 'createTime',
					title : '创建时间',
					width : 120
				}, {
					field : 'updateTime',
					title : '修改时间',
					width : 120
				}, {
					field : 'ustatus',
					title : '状态',
					width : 120,
					templet : "#status_templet"
				}, {
					field : 'rolelist',
					title : '角色列表',
					width : '100%',
					templet : "#role_templet"
				}

			] ]
		})
	}
</script>
<script type="text/html" id="status_templet">
	 <input type="checkbox"  name="status" value="{{ d.uid }}" lay-skin="switch" lay-text="启动|禁用" lay-filter="status" {{ d.ustatus == 1 ? 'checked' : '' }}>
</script>
<script type="text/html" id="role_templet">
		{{#   for(var i=0;i<d.rolelist.length;i++){             }}
	<input type="checkbox" name="{{ d.uid }}" value="{{d.rolelist[i].rid}}" title="{{d.rolelist[i].rname}}" lay-filter="lockDemo"  {{ d.rolelist[i].flag == 1 ? 'checked' : '' }} >	  
        {{#   }                                             }}
</script>
<script>
	layui.use('form', function() {
		var form = layui.form;
		//各种基于事件的操作，下面会有进一步介绍
		form.on('switch(status)', function(data) {
			var uid = data.value;
			var ustatus = data.elem.checked;
			console.log(ustatus); //开关是否开启，true或者false
			console.log(uid); //开关value值，也可以通过data.elem.value得到
			changestatus(uid, ustatus);

		});

		form.on('checkbox(lockDemo)', function(data) {
			var uid = this.name;
			var rid = data.value;
			var rolecheck = data.elem.checked;

			console.log(uid);
			console.log(data.elem.checked); //是否被选中，true或者false
			console.log(data.value); //复选框value值，也可以通过data.elem.value得到
			changerole(uid, rid, rolecheck);
		});
	});


	function changestatus(uid, ustatus) {
		$.post(
			"user/changestatus"
			, {
				"uid" : uid,
				"ustatus" : ustatus
			}
			, function(obj) {
				layer.msg(obj.msg);
			}
		)
	}

	function changerole(uid, rid, rolecheck) {
		$.post(
			"user/changerole"
			, {
				"uid" : uid,
				"rid" : rid,
				"rolecheck" : rolecheck
			}
			, function(obj) {
				layer.msg(obj.msg);
			}
		)
	}

	/* function search() {
		var uname = $("#demoReload").val();
		$.post("user/searchuser", {
			"uname" : uname
		},
			function(obj) {
				layui.table.reload('idTest', {
					where : { //设定异步数据接口的额外参数，任意设
						uname : 'uname',
					},
					page : {
						curr : 1 //重新从第 1 页开始
					}
				});
			}
		) 
	}*/
</script>

</html>
