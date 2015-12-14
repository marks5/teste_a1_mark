<%@page import="br.com.teste.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teste da lista</title>
<script type="text/javascript">
function confirmaExclusao(id){
	if(window.confirm('Tem certeza que quer excluir?')){
		location.href="uController.do?acao=exc&id="+id;
	}
}
function alteracao(id){
	if(window.confirm('Você deseja alterar o usuário?'))
		location.href="uController.do?acao=alt&id="+id;
}
function novo(){
	location.href="uController.do?acao=cad";
}
</script>
</head>
<body>
<%@include file="menu.jsp" %>
<%List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");%>

<table border=1>
<tr><th>id</th><th>nome</th><th>CPF</th><th>Login</th><th>Ação</th></tr>

	<%for(Usuario u:lista){ %>
		<tr>
			<td><%out.print(u.getIdAluno());%></td>
			<td><%=u.getNome()%></td>
			<td><%=u.getCpf()%></td>
			<td><%=u.getLogin()%></td>
			<td><a href="javascript:confirmaExclusao(<%=u.getIdAluno()%>)">excluir</a>&nbsp;
			<a href="javascript:alteracao(<%=u.getIdAluno()%>)">alterar</a>
			</td>
			</tr>
	<%} %>
	</table>
	
	<input type="button" onclick="javascript:novo()" value="Cadastrar">
</body>
</html>