<%--
  Created by IntelliJ IDEA.
  User: minisheep
  Date: 17/3/23
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="loginAction.do" method="post">
        <div class="header">
            <ul>
                <li>
                    <label>用户名</label>
                    <input name="username" type="text" class="text" />
                </li>

                <li>
                    <label>密码</label>
                    <input name="password" type="password" class="text" />
                </li>

                <li>
                    <input name="submit" type="submit" value="登录" />
                </li>
            </ul>
        </div>
    </form>
</body>
</html>
