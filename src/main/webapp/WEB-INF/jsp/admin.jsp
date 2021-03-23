<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <div id="admin">
        <header-component></header-component>
        <div style="margin-top: 30px;">
            <router-view></router-view>
        </div>
<%--        <show-users-component></show-users-component>--%>
    </div>
</body>
<script>
    let usersJSON = ${users};
    let pagesJSON = ${pages};
    let settingsJSON = ${settings};
    let navbarsJSON = ${navbars};
</script>
<footer>
    <script src="${basePath}/js/admin.js"></script>
</footer>
</html>
