<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%@ include file="options.jsp" %>
		<form action="cadlivros" method="post" enctype="multipart/form-data">
			<label for="codigo">Código</label> <br/>
			<input type="text" name="codigo" id="codigo">  <br/>
			
			<label for="titulo">Título</label> <br/>
			<input type="text" name="titulo" id="titulo">  <br/>
			
			<label for="autor">Autor</label> <br/>
			<input type="text" name="autor" id="autor">  <br/>
			
			<label for="data">Data de publicacao</label> <br/>
			<input type="text" name="data" id="data">  <br/>
			
			<label for="preco">Preço</label> <br/>
			<input type="text" name="preco" id="preco">  <br/>
			
			<label for="foto">Foto do arquivo</label> <br/>
			<input type="file" name="foto" id="foto">  <br/>
			
			<input type="submit" value="Submit"/>
			<div>
				${mensagem}
			</div>
		</form>		
	</body>
</html>