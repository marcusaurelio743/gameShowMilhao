package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.showmilhao.connection.FactoryConnection;
import br.com.showmilhao.model.Pergunta;

public class PerguntaDao {
	private Connection conexao;
	private static final String ORDER_BY_RANDOM_LIMIT = "ORDER BY RANDOM() LIMIT 1";
	private static final String QUERY_INSERIR= "INSERT INTO pergunta(id,nivel,enumciado,alternativa1,alternativa2,alternativa3,resposta)"
			+ " VALUES ($next_id,?,?,?,?,?,?)";
	private static final String QUERY_UPDATE= "UPDATE pergunta SET nivel=?,enumciado=?,"
			+ "alternativa1=?,alternativa2=?,alternativa3=?,resposta=? WHERE id=?";
	private static final String QUERY_DELETE = "DELETE FROM pergunta WHERE id=?";
	private static final String QUERY_LISTAR_PERGUNTAS = "SELECT * FROM pergunta";
	private static final String QUERY_LISTAR_PERGUNTAS_NIVEL = "SELECT * FROM pergunta WHERE nivel=?";
	private static final String QUERY_SELECT_NIVEL_RANDOM_LIMIT = "SELECT * FROM pergunta WHERE nivel = ? " + ORDER_BY_RANDOM_LIMIT;	
	private static final String QUERY_SELECT_NIVEL_RANDOM_LIMIT_PERGUNTAS_FEITAS = "SELECT * FROM pergunta WHERE nivel = ? AND pergunta.id NOT IN ";

	
	public PerguntaDao() {
		this.conexao = FactoryConnection.getConexao();
	}
	
	public Pergunta inserir(Pergunta pergunta) {
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
				return pergunta;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
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
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public boolean deletar(Long id) {
		try {
			try(PreparedStatement statement = conexao.prepareStatement(QUERY_DELETE)){
				statement.setLong(1,id);
				statement.execute();
				conexao.commit();
				return Boolean.TRUE;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	
	private List<Pergunta> buscar(String sql,String nivel){
		List<Pergunta> perguntas = new ArrayList<>();
		try {
			try(PreparedStatement statement = conexao.prepareStatement(sql)){
				if(Objects.nonNull(nivel)) statement.setString(1, nivel);
				ResultSet resultado = statement.executeQuery();
				
				while(resultado.next()) {
					Pergunta pergunta = new Pergunta();
					pergunta.setEnumciado(resultado.getString("enumciado"));
					pergunta.setNivel(resultado.getString("nivel"));
					pergunta.setId(resultado.getLong("id"));
					pergunta.setAlter1(resultado.getString("alternativa1"));
					pergunta.setAlter2(resultado.getString("alternativa2"));
					pergunta.setAlter3(resultado.getString("alternativa3"));
					pergunta.setResp(resultado.getString("resposta"));
					perguntas.add(pergunta);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return perguntas;
	}
	
	public List<Pergunta> listar(){
		return buscar(QUERY_LISTAR_PERGUNTAS, null);
	}
	public List<Pergunta> listar(String nivel){
		return buscar(QUERY_LISTAR_PERGUNTAS_NIVEL, nivel);
	}
	public List<Pergunta> listar(String idsPerguntasFeitas, String nivel) {
		String sql = idsPerguntasFeitas.isEmpty() ? QUERY_SELECT_NIVEL_RANDOM_LIMIT : QUERY_SELECT_NIVEL_RANDOM_LIMIT_PERGUNTAS_FEITAS + idsPerguntasFeitas + ORDER_BY_RANDOM_LIMIT;		
		return buscar(sql, nivel);
	}

	
}
