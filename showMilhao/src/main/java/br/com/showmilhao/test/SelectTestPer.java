package br.com.showmilhao.test;

import java.util.List;

import br.com.showmilhao.dao.PerguntaDao;
import br.com.showmilhao.model.Pergunta;

public class SelectTestPer {
	private static PerguntaDao dao = new PerguntaDao();
	public static void main(String[] args) {
		List<Pergunta> perguntas = dao.listar();
		
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta);
		}
		
		System.out.println("listar pergunta por nivel");
		System.out.println("=======================================================");
		perguntas = dao.listar("MEDIO");
		
		for (Pergunta pergunta : perguntas) {
			System.out.println(pergunta);
		}
		
	}

}
