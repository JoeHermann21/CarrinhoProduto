/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CarrinhoCompra;
import Model.Produto;
import Model.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author e.andre.germano
 */
public class ControleCarrinho extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
//recupera a sessão
            HttpSession sessao = request.getSession();
//verifica se já existe um carrinho de produtos
//é null se não existe um carrinho na sessão
            CarrinhoCompra carrinho = (CarrinhoCompra) sessao.getAttribute("carrinho");
            if (carrinho == null) {
//cria um carrinho 
                carrinho = new CarrinhoCompra();
                sessao.setAttribute("carrinho", carrinho);
            }
//recupera o id do produto que deve ser add no carrinho
            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
//encontra o produto no banco
            Produto produto = new ProdutoDAO().consultarPorId(idProduto);
//add um novo produto no carrinho
            carrinho.addProduto(produto);
//redireciona o usuario para a pagina do carrinho de compras
            request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
