package br.com.showmilhao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.showmilhao.connection.FactoryConnection;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class JogadorDao {
	private Connection conexao;
	
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

}
