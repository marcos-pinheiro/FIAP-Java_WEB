<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<div style="padding:15px 0;">
			<a href="logout">Logout</a>
		</div>
		
		<%-- inclui o c�digo do arquivo nesta arquivo --%>
		<%@ include file="welcome.jsp" %>
		
		<%-- executa a p�gina incluindo o resultado. Pode-se passar parametros nesta --%>
		<%-- <jsp:include page="welcome.jsp" /> --%> 
		
		<a href="cadusuarios">Cadastro de usuarios</a> <br/>
		<a href="cadlivros">Cadsatro de livros</a><br/>
		<a href="listaLivros.jsp">Lista de livros</a><br/>
	</body>
</html>