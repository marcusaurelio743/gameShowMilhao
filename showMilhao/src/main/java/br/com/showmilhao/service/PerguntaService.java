package br.com.showmilhao.service;

import java.util.List;

import br.com.showmilhao.dao.PerguntaDao;
import br.com.showmilhao.model.Pergunta;

public class PerguntaService {
	
	private PerguntaDao dao;
	
	public PerguntaService() {
		dao = new PerguntaDao();
	}
	
	public void inserir(Pergunta pergunta) {
		dao.inserir(pergunta);
	}
	
	public void atualizar(Pergunta pergunta) {
		dao.atualizar(pergunta);
	}
	public void deletar(Long id) {
		dao.deletar(id);
	}
	public List<Pergunta> listar(){
		return dao.listar();
	}
	public List<Pergunta> listar(String nivel){
		return dao.listar(nivel);
	}
	

}
