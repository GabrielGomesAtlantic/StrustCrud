package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.form.CrudForm;
import com.crud.model.vo.PersonagemVO;

public class PersonagemDAO {
     private Statement stmt;
     private Conexao conn = new Conexao();
     private PreparedStatement pstmt;
     
	public void gravar(CrudForm frm) throws SQLException {
		
        try {
        	Connection conexao = conn.obterConexao();
        	stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SEQ_USUARIO_GABRIEL.NEXTVAL SEQ_GABRIEL FROM dual");
            rs.next();
        	int id = rs.getInt("SEQ_GABRIEL");
            pstmt = conexao.prepareStatement("INSERT INTO tb_usuario_gabriel VALUES(?,?,?,?,?,?,?)");
            pstmt.setInt(1, id);
            frm.setId(id);
            pstmt.setString(2, frm.getNickName() );
            pstmt.setString(3, frm.getSexo());
            pstmt.setString(4, frm.getLevel());
            pstmt.setString(5, frm.getDatCria());
            pstmt.setString(6, frm.getArmas());
            pstmt.setString(7, frm.getObservacoes());
            pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.fecharConexao(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

	
	public void excluir(CrudForm frm) throws SQLException{
		try {
			Connection conexao = conn.obterConexao();
			pstmt = conexao.prepareStatement("DELETE FROM tb_usuario_gabriel WHERE ID_USER = ?");
            pstmt.setInt(1, frm.getId());
            pstmt.execute();
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.fecharConexao(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }	
	}
	
	public void editar(CrudForm frm) throws SQLException{
		try {
			Connection conexao = conn.obterConexao();
			pstmt = conexao.prepareStatement("UPDATE tb_usuario_gabriel SET NICKNAME=?, SEXO=?, LEVEL_USER=?, DAT_CRIA=?, ARMAS=?, OBS=? WHERE ID_USER = ?");
            pstmt.setString(1, frm.getNickName() );
            pstmt.setString(2, frm.getSexo());
            pstmt.setString(3, frm.getLevel());
            pstmt.setString(4, frm.getDatCria());
            pstmt.setString(5, frm.getArmas());
            pstmt.setString(6, frm.getObservacoes());
			pstmt.setInt(7, frm.getId());
            pstmt.execute();
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //stmt.close();
                conn.fecharConexao(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}


	public List<PersonagemVO> listaPersonagens() throws SQLException{
		List<PersonagemVO> lista = new ArrayList<>();
		try {
			Connection conexao = conn.obterConexao();
        	stmt = conexao.createStatement();
        	ResultSet rs = stmt.executeQuery("select ID_USER, NICKNAME, SEXO, LEVEL_USER, DAT_CRIA, ARMAS, OBS from tb_usuario_gabriel");
        	while (rs.next()) {
        		PersonagemVO personagem = new PersonagemVO();
        		personagem.setId(rs.getInt("ID_USER"));
        		personagem.setNickName(rs.getString("NICKNAME"));
        		personagem.setSexo(rs.getString("SEXO"));
        		personagem.setLevel(rs.getString("LEVEL_USER"));
        		personagem.setDatCria(rs.getString("DAT_CRIA"));
        		personagem.setArmas(rs.getString("ARMAS"));
        		personagem.setObservacoes(rs.getString("OBS"));
        		
        		lista.add(personagem);
        	}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
