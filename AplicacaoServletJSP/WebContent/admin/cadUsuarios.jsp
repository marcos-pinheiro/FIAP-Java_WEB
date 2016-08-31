<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="options.jsp" %>
		<form action="cadusuarios" method="post">
			<label for="usuario">Usuario</label> <br/>
			<input type="text" name="usuario" id="usuario">  <br/>
			<label for="senha">Senha</label> <br/>
			<input type="password" name="senha" id="senha">  <br/>
			<label for="nivel">Nível</label> <br/>
			<select name="nivel" id="nivel">
				<option value="1" selected="selected">Administrador</option>
				<option value="2">Cliente</option>
			</select>  <br/>
			<input type="submit" value="Submit"/>
			<div>
				${mensagem}
			</div>
		</form>		
	</body>
</html>