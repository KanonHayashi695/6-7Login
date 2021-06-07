<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<form action= "../jp.co.aforce.Action/Login.action" method="post">
<p>ID<input type="text" name= "id"></p>
<p>パスワード<input type="password" name= "password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<%@include file= "../footer.html" %>