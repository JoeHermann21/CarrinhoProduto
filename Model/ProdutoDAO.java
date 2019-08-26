/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author e.andre.germano
 */
public class ProdutoDAO {
    
    public ArrayList<Produto> listar(){
        Connection conexao = null;
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        try {
            
            conexao = Conexao.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement("select * from produto");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setImagem(rs.getString("imagem"));
                
                listaProduto.add(produto);
            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);

        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return listaProduto;
            
    }
    
    public Produto consultarPorId(Integer id){
        Connection conexao = null;
        Produto produto = new Produto();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement("select * from produto where id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setImagem(rs.getString("imagem"));
            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);

        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }
        }
        return produto;
    }
    
}
    
