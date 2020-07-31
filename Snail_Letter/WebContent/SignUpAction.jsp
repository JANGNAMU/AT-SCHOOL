<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DB.userDTO" %>
<%@ page import="DB.userDAO" %>
<%@ page import="util.SHA256" %>
<%@ page import="java.io.PrintWriter" %>

<%
	request.setCharacterEncoding("UTF-8");
	String userID = null;
	String userPW = null;
	String userEmail = null;
	String userGender = null;
	String userBirth = null;
	String userLoc = null;
	String userName = null;
	
	
	if(request.getParameter("userID") != null) {
		userID = request.getParameter("userID");
	}
	if(request.getParameter("userPW") != null) {
		userPW = request.getParameter("userPW");
	}
	if(request.getParameter("userEmail") != null) {
		userPW = request.getParameter("userEmail");
	}
	if(request.getParameter("userGender") != null) {
		userPW = request.getParameter("userGender");
	}
	if(request.getParameter("userBirth") != null) {
		userPW = request.getParameter("userBirth");
	}
	if(request.getParameter("userLoc") != null) {
		userPW = request.getParameter("userLoc");
	}
	if(request.getParameter("userName") != null) {
		userPW = request.getParameter("userName");
	}
	
	
	
	if(userID == null || userPW == null || userEmail == null || userGender == null
			 || userBirth == null || userLoc == null || userName == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력되지 않은 사항이 있습니다');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	
	userDAO userDAO = new userDAO();
	int result = userDAO.SignUp(new userDTO(userID, userPW, userEmail, userGender, userBirth, userLoc, userName, SHA256.getSHA256(userEmail), false));
	if(result == -1) {
 		PrintWriter script = response.getWriter();
 		script.println("<script>");
 		script.println("alert('이미 존재하는 회원정보입니다');");
 		script.println("history.back();");
 		script.println("</script>");
 		script.close();
 		return;
 	} else {
 		session.setAttribute("userID", userID);
 		PrintWriter script = response.getWriter();
 		script.println("<script>");
 		script.println("location.href = 'emailSendAction.jsp'");
 		script.println("</script>");
 		script.close();
 		return;
 	}
%>