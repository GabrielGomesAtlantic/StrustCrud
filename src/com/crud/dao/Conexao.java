package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	Connection conexao;
	
	public Connection obterConexao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection("jdbc:oracle:thin:@10.32.249.2:1521/PDBSPPREVHML.br1.ocm.s7071866.oraclecloudatcustomer.com", "ljunior", "lrosahmg");
        } 
        catch (ClassNotFoundException e) {
                 e.printStackTrace();
        }
        catch (SQLException e) {
                 e.printStackTrace();
        }
        return conexao;
	}
	
	public void fecharConexao() throws SQLException {
		try {
			conexao.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	
