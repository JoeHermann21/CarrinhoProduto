/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author e.andre.germano
 */
public class Produto {
    
    private Integer id;
    private String nome;
    private String descricao;
    private Double precoUnitario;
    private String imagem;

    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, Double valorUnitario, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = valorUnitario;
        this.imagem = imagem;
    }
    
    public Produto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }  
        
    
    
}
