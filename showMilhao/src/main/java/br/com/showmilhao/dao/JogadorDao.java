package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.showmilhao.connection.FactoryConnection;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class JogadorDao {
	private Connection conexao;
	private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM jogador" ;
	private static final String QUERY_BUSCAR_TODOS_RANKING ="SELECT * FROM jogador ORDER BY pontuacao DESC LIMIT 10";
	
	public JogadorDao() {
		conexao = FactoryConnection.getConexao();
	}
	public boolean adicionar(Jogador jogador) {
		String sql = "INSERT INTO jogador(id,nome,pontuacao) VALUES($next_id,?,?);";
		try(PreparedStatement statement = conexao.prepareStatement(sql)){
			statement.setString(2, jogador.getNome());
			statement.setInt(3, jogador.getPontuacao());
			statement.execute();
			conexao.commit();
			return true;
		}catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
		}
		return false;
	}
	
	public void atualizar(Jogador jogador) {
		String sql = "UPDATE jogador set nome = ?, pontuacao = ? WHERE id = ?;";
		
		try(PreparedStatement statement = conexao.prepareStatement(sql)){
			statement.setString(1, jogador.getNome());
			statement.setInt(2, jogador.getPontuacao());
			statement.setLong(3, jogador.getId());
			statement.executeUpdate();
			conexao.commit();
		}catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
		}
	}
	
	private List<Jogador> buscar(String sql){
		List<Jogador> jogadores = new ArrayList<>();
		
		try {
			try(PreparedStatement smt = conexao.prepareStatement(sql)){
				
				try(ResultSet rs = smt.executeQuery()){
					while(rs.next()) {
						Jogador jogador = new Jogador();
						jogador.setId(rs.getLong("id"));
						jogador.setNome(rs.getString("nome"));
						jogador.setPontuacao(rs.getInt("pontuacao"));
						jogador.setLinha(rs.getRow());
						
						jogadores.add(jogador);
					}
				}
			}
			
		} catch (Exception e) {
			LogUtil.getLogger(JogadorDao.class).error(e.getCause().toString());
		}
		 return jogadores;
	}
	
	public List<Jogador> listar(){
		return buscar(QUERY_BUSCAR_TODOS);
	}
	
	public List<Jogador> listarRanking(){
		return buscar(QUERY_BUSCAR_TODOS_RANKING);
	}

}
