<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="livro" class="br.com.fiap.bean.LivrosBean"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="options.jsp" %>
		<table border="1">
			<thead>
				<tr>
					<th>Código</th>
					<th>Título</th>
					<th>Links</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="meuLivro" items="${livro.listaLivros}">
					<tr>
						<td>${meuLivro.codigo}</td>
						<td>${meuLivro.titulo}</td>
						<td><a href="consultarlivro?codigo=${meuLivro.codigo}">Detalhes</a> | <a href="sinopse?codigo=${meuLivro.codigo}">Sinopse</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>