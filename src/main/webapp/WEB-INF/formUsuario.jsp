<%@page import="br.com.teste.entidade.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
		<body>
		<%@include file="menu.jsp" %>
			<%Usuario u = (Usuario)request.getAttribute("usu");%>
			<form action="uController.do" method="post">
			ID:<input type="text" name="id" value="<%=u.getIdAluno()%>"><br>
			Nome:<input type="text" name="nome" value="<%=u.getNome()%>"><br>
			Login:<input type="text" name="login" value="<%=u.getLogin()%>"><br>
			Senha:<input type="password" name="senha" value="<%
			if(u.getSenha()!=""){
				out.print("");
			}else{
				u.getSenha();	
			}
			%>"><br>
			Cpf:<input type="text" name="cpf" value="<%=u.getCpf()%>"><br>
			<input type="submit" value="Salvar"><br>
			</form>
		</body>
</html>