package br.com.showmilhao.service;

import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import br.com.showmilhao.dao.PerguntaDao;
import br.com.showmilhao.model.Pergunta;

public class PerguntaService {
	private static final String OK = "Processo Concluido";
	private static final int MESSAGE_TYPE = JOptionPane.INFORMATION_MESSAGE;
	private PerguntaDao dao;
	
	public PerguntaService() {
		dao = new PerguntaDao();
	}
	
	public void inserir(Pergunta pergunta) {
		Pergunta perguntaRetornada = dao.inserir(pergunta);
		if(Objects.nonNull(perguntaRetornada)) {
			JOptionPane.showMessageDialog(null, "Pergunta Adicionada com sucesso !",OK, MESSAGE_TYPE);
		}
	}
	
	public void atualizar(Pergunta pergunta) {
		dao.atualizar(pergunta);
		JOptionPane.showMessageDialog(null, "Modificações realizada com sucesso!",OK, MESSAGE_TYPE);
	}
	public void deletar(Long id) {
		boolean removido = dao.deletar(id);
		if(removido)
			JOptionPane.showMessageDialog(null, "Pergunta Removida com sucesso!",OK, MESSAGE_TYPE);
		  
	}
	public List<Pergunta> listar(){
		return dao.listar();
	}
	public List<Pergunta> listar(String nivel){
		return dao.listar(nivel);
	}
	public List<Pergunta> listar(String idsPerguntasFeitas, String nivel) {
		return dao.listar(idsPerguntasFeitas, nivel);
	}
	

}
