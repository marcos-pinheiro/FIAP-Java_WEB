<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %> 
<!DOCTYPE html>
<html>
	<head>
		<sx:head/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Cadastro de livros</h1>
		<s:form action="cadastro" method="post" enctype="multipart/form-data">
			<s:textfield name="livro.codigo" label="Código" />
			<s:textfield name="livro.titulo" label="Título" />
			<s:textfield name="livro.autor" label="Autor" />
			<sx:datetimepicker name="livro.dataPublicacao" label="Data de publicação" displayFormat="dd/MM/yyyy" />
			<s:textfield name="livro.preco" label="Preço" />
			<s:file name="figura" label="Selecione a imagem:"/>
			<s:submit name="submit" value="Enviar" align="center"/>
		</s:form>		
	</body>
</html>