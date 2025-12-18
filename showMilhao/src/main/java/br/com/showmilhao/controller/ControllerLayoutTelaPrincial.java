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
	private Label labelNumeroRodada;
	@FXML
	private Label labelNumeroPergunta;
	@FXML
	private Label labelNivel;
	@FXML
	private Label labelErrar;
	@FXML
	private Label labelParar;
	@FXML
	private Label labelAcertar;
	
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setNome();
		initLabels();
	}
	
	private void setNome() {
		Jogador jogador = jogadorService.listar()
							.stream().reduce((jogador1,jogador2) -> jogador2).orElseThrow();
		labelNomeJogador.setText(jogador.getNome());
	}
	
	private void initLabels() {
		labelAcertar.setText("1.000,00");
		labelErrar.setText("0,00");
		labelParar.setText("0,00");
		labelNumeroRodada.setText("1");
		labelNivel.setText("Fácil");
		labelNumeroPergunta.setText("1");
		
	}

}
