<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DB.userDTO" %>
<%@ page import="DB.userDAO" %>
<%@ page import="util.SHA256" %>
<%@ page import="java.io.PrintWriter" %>

<%
	session.invalidate();
%>
<script>
	location.href = 'Home.jsp';
</script>