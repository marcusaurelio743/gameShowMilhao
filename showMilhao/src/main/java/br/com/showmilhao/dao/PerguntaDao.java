package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.showmilhao.connection.FactoryConnection;
import br.com.showmilhao.model.Pergunta;

public class PerguntaDao {
	private Connection conexao;
	private static final String QUERY_INSERIR= "INSERT INTO pergunta(id,nivel,enumciado,alternativa1,alternativa2,alternativa3,resposta)"
			+ " VALUES ($next_id,?,?,?,?,?,?)";
	private static final String QUERY_UPDATE= "UPDATE pergunta SET nivel=?,enumciado=?,"
			+ "alternativa1=?,alternativa2=?,alternativa3=?,resposta=? WHERE id=?";
			
	private static final String OK = "Processo Concluido";
	private static final int MESSAGE_TYPE = JOptionPane.INFORMATION_MESSAGE;
	
	public PerguntaDao() {
		this.conexao = FactoryConnection.getConexao();
	}
	
	public void inserir(Pergunta pergunta) {
		try {
			try(PreparedStatement statement = conexao.prepareStatement(QUERY_INSERIR)){
				statement.setString(2,pergunta.getNivel());
				statement.setString(3, pergunta.getEnumciado());
				statement.setString(4, pergunta.getAlter1());
				statement.setString(5, pergunta.getAlter2());
				statement.setString(6, pergunta.getAlter3());
				statement.setString(7, pergunta.getResp());
				
				statement.execute();
				conexao.commit();
				
				JOptionPane.showMessageDialog(null, "Pergunta Adicionada com sucesso !",OK, MESSAGE_TYPE);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void atualizar(Pergunta pergunta) {
		try {
			try(PreparedStatement statement = conexao.prepareStatement(QUERY_UPDATE)){
				statement.setString(1,pergunta.getNivel());
				statement.setString(2, pergunta.getEnumciado());
				statement.setString(3, pergunta.getAlter1());
				statement.setString(4, pergunta.getAlter2());
				statement.setString(5, pergunta.getAlter3());
				statement.setString(6, pergunta.getResp());
				statement.setLong(7, pergunta.getId());
				statement.execute();
				conexao.commit();
				
				JOptionPane.showMessageDialog(null, "Modificações realizada com sucesso!",OK, MESSAGE_TYPE);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	

}
