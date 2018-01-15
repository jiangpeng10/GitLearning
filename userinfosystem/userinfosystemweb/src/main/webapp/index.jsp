<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/user/save" method="post">
    <table>
        <tr>
            <td>用户名：<input type="text" name="userName"></td>
            <td>手机号码：<input type="text" name="phone"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>