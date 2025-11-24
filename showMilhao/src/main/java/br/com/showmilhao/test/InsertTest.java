package br.com.showmilhao.test;

import br.com.showmilhao.dao.JogadorDao;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class InsertTest {
	private static JogadorDao dao = new JogadorDao();
	public static void main(String[] args) { 
		Jogador jogador = new Jogador();
		/*jogador.setNome("Maria");
		jogador.setPontuacao(500);
		LogUtil.getLogger(InsertTest.class).info(dao.adicionar(jogador));*/
		
		jogador.setNome("Carla");
		jogador.setPontuacao(900);
		jogador.setId(2L);
		dao.atualizar(jogador);
	}

}
