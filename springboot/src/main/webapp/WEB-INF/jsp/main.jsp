<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>权限管理主页</title>

<link rel="stylesheet" href="layui/css/layui.css">

</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">权限管理</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="javascript:openUrl('page_user')">用户管理</a></li>
				<li class="layui-nav-item"><a href="javascript:openUrl('page_role');">角色管理</a></li>
				<li class="layui-nav-item"><a href="javascript:;">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 你好
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="javascript:;">基本资料</a>
						</dd>
						<dd>
							<a href="javascript:;">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="user/out">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<c:forEach items="${requestScope.relist}" var="res">
						<c:if test="${res.parentId==0}">
							<li class="layui-nav-item layui-nav-itemed"><a class=""
								href="javascript:;">${res.rname}</a>
								<dl class="layui-nav-child">
									<c:forEach items="${requestScope.relist}" var="sub_res">
										<c:if test="${sub_res.parentId==res.rid}">
											<dd>
												<a href="javascript:openUrl('${sub_res.resurl}')">${sub_res.rname}</a>
											</dd>
										</c:if>
									</c:forEach>
								</dl></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="layui-body" style="width=100%;height=100%">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<div style="padding:0px;">
				</div>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>
	<script src="../js/jquery-3.2.1.js"></script>
	<script src="../layui/layui.all.js"></script>
	<script>
		
		var index;
	
		function openUrl(url) {
			var width = '90%';
			var height = '100%';
			layui.layer.close(index);
			index = layui.layer.open({
				title : false,
				type : 2,
				shade : 0,
				offset : [ '60px', '200px' ],
				closeBtn : 0,
				shift : 0,
				area : [ width, height ],
				content : [ url, 'no' ] //这里content是一个普通的String
			});
		}
	</script>
</body>
</html>
