<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Wopop</title>
<link href="Wopop_files/style_log.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="../layui/css/layui.css">
</head>

<body class="login" mycollectionplug="bind">
	<div class="login_m">
		<div class="login_logo">
			<img src="Wopop_files/logo.png" width="196" height="46">
		</div>
		<div class="login_boder">

			<div class="login_padding" id="login_model">

				<h2>USERNAME</h2>
				<label> <input type="text" id="username"
					class="txt_input txt_input2"
					onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}"
					onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}"
					value="刘江鹏"></label>
				<h2>PASSWORD</h2>
				<label> <input type="password" name="textfield2"
					id="userpwd" class="txt_input"
					onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}"
					onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}"
					value="123456"></label>

				<p class="forgot">
					<a id="iforget" href="javascript:void(0);">Forgot your
						password?</a>
				</p>
				<div class="rem_sub">
					<div class="rem_sub_l">
						<input type="checkbox" name="checkbox" id="save_me"> <label
							for="checkbox">Remember me</label>
					</div>
					<label> <input type="submit" class="sub_button" onclick="login()"
						name="button" id="button" value="SIGN-IN" style="opacity: 0.7;"></label>
				</div>
			</div>

			<div class="copyrights">
				Collect from <a href="http://www.cssmoban.com/">cssmoban</a>
			</div>

			<div id="forget_model" class="login_padding" style="display:none">
				<br>

				<h1>Forgot password</h1>
				<br>
				<div class="forget_model_h2">(Please enter your registered
					email below and the system will automatically reset usersâ
					password and send it to userâs registered email address.)</div>
				<label> <input type="text" id="usrmail"
					class="txt_input txt_input2">
				</label>

				<div class="rem_sub">
					<div class="rem_sub_l"></div>
					<label> <input type="submit" class="sub_buttons"
						name="button" id="Retrievenow" value="Retrieve now"
						style="opacity: 0.7;"> <input type="submit"
						class="sub_button" name="button" id="denglou" value="Return"
						style="opacity: 0.7;"></label>
				</div>
			</div>

			<!--login_padding  Sign up end-->
		</div>
		<!--login_boder end-->
	</div>
	<!--login_m end-->
	<br>
	<br>
	<p align="center">
		More Templates <a href="http://www.cssmoban.com/" target="_blank"
			title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a> - Collect from <a
			href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿" target="_blank">ç½é¡µæ¨¡æ¿</a>
	</p>
</body>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../layui/layui.all.js"></script>
<script type="text/javascript">
	var layer;
	layui.use('layer',function(args){
		layer = layui.layer;
	});
	
	function login() {
		var uname = $("#username").val();
		var userpwd = $("#userpwd").val();
		if (uname == "") {
			layer.tips('用户名不可为空','#username');
			return false;
		}
		if (userpwd == "") {
			layui.layer.tips('用户名不可为空','#password');
			return false;
		}
		var wait = layer.load();//弹出加载层
		$.post("user/userlogin", {
			"uname" : uname,
			"userpwd" : userpwd
		}, function(data) {
			if(data.msg=="ok"){
				location = "main"
				return true;
			}else{
			layer.close(wait)};
			layer.msg("登陆失败！");
		})
	}
</script>
</html>