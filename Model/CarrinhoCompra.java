/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class CarrinhoCompra {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
//calcular total 

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPrecoUnitario();
        }
        return total;
    }
}
