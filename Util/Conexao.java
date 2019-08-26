/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author e.andre.germano
 */
public class Conexao {

    public static Connection getConexao() {
    
        Connection conexao = null;

        try {

            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojavirtual?"
                    + "useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return conexao;
    }
    
}
