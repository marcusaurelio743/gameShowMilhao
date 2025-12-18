package br.com.showmilhao.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.service.JogadorService;
import br.com.showmilhao.util.ControllerUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControllerLayoutTelaPrincial implements Initializable {
	private JogadorService jogadorService;
	
	public ControllerLayoutTelaPrincial() {
		jogadorService = new JogadorService();
	}
	
	@FXML
	private Label labelNomeJogador;
	
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setNome();
	}
	
	private void setNome() {
		Jogador jogador = jogadorService.listar()
							.stream().reduce((jogador1,jogador2) -> jogador2).orElseThrow();
		labelNomeJogador.setText(jogador.getNome());
	}

}
