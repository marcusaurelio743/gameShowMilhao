package br.com.showmilhao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.showmilhao.util.LogUtil;

public class FactoryConnection {
	private static final String URL_CONNECTION="jdbc:sqlite:src/main/resources/data/show_milhao.db";
	
	private static Connection conexao;
	
	private FactoryConnection() {
		
	}
	static{
		conectar();
	}
	private static void conectar() {
		try {
			if(conexao == null) {
				conexao = DriverManager.getConnection(URL_CONNECTION);
				conexao.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			LogUtil.getLogger(FactoryConnection.class).error(e.getCause().toString());
		}
		
	}
	public static Connection getConexao() {
		return conexao;
	}
	

}
