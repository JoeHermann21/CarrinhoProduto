<%@page import="Model.Produto"%>
<%@page import="Model.CarrinhoCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compras</title>
    </head>
    <body>
        <h1>Carrinho de Compras!</h1>
        <table border="1" cellpadding="2" align="center">
            <tr>
                <td bgcolor="#000088"><font color="white">Excluir</font></td>
                <td bgcolor="#000088"><font color="white">Produto</font></td>
                <td bgcolor="#000088"><font color="white">Valor</font></td>    
            </tr>
            <%
            //recupera os produtos do carrinho da sessao
                CarrinhoCompra carrinho = (CarrinhoCompra) session.getAttribute("carrinho");
                for (Produto produto : carrinho.getProdutos()) {
            %>
            <tr>
                <td>X</td>
                <td><%=produto.getNome()%></td>
                <td><%=produto.getPrecoUnitario()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <strong>Valor Total: <%=carrinho.calcularTotal()%></strong><br/>
        <a href="index.jsp"> Continue comprando</a>
    </body>
</html>
