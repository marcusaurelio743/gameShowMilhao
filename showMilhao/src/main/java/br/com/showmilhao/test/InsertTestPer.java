package br.com.showmilhao.test;

import br.com.showmilhao.dao.PerguntaDao;
import br.com.showmilhao.model.Pergunta;

public class InsertTestPer {
	private static PerguntaDao dao = new PerguntaDao();
	public static void main(String[] args) {
		Pergunta pergunta = new Pergunta();
		//pergunta.setId(1L);
		pergunta.setNivel("DIFICIL");
		pergunta.setEnumciado("Quem descobriu o Brasil?");
		pergunta.setAlter1("JOSE");
		pergunta.setAlter2("PELE");
		pergunta.setAlter3("pedro alvares cabral");
		pergunta.setResp("R pedro alvares cabral");
		
		dao.inserir(pergunta);
		//dao.atualizar(pergunta);
		//dao.deletar(2L);
	}

}
