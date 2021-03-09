<html>
<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
</head>
<body>

<div>
    <div class="container-lg">
        <!-- Content here -->
        <form action="/user/registerUser" method="post">
            <table align="center">
                <tr align="right">
                    <td>用户名:</td>
                    <td><input type="text" name=name autofocus="autofocus"></td>
                </tr>
                <tr align="right">
                    <td>密码:</td>
                    <td><input type="password" name=password></td>
                </tr>
                <tr align="right">
                    <td>邮箱:</td>
                    <td><input type="text" name=email></td>
                </tr>
                <tr align="right">
                    <td>电话号码:</td>
                    <td><input type="text" name=phoneNumber></td>
                </tr>
            </table>
            <br>
            <div style="text-align:center;">
                <button type="submit" >注册</button>
                <button type="reset" >重置</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>