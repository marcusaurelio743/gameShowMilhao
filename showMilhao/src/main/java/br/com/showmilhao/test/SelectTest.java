package br.com.showmilhao.test;

import java.util.List;

import br.com.showmilhao.dao.JogadorDao;
import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.util.LogUtil;

public class SelectTest {
	private static JogadorDao dao = new JogadorDao();
	public static void main(String[] args) {
		System.out.println("listar todos jogadores!!!!");
		
		List<Jogador> jogadores = dao.listar();
		
		for (Jogador jogador : jogadores) {
			LogUtil.getLogger(SelectTest.class).info(jogador);
		}
		
		System.out.println("listar por rankings----");
		System.out.println();
		
		jogadores = dao.listarRanking();
		
		for (Jogador jogador : jogadores) {
			LogUtil.getLogger(SelectTest.class).info(jogador);
		}
	}

}
