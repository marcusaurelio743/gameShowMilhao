package br.com.showmilhao.controller;

import static br.com.showmilhao.util.ControllerUtil.startVoice;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.showmilhao.util.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControllerLayoutTelaNome implements Initializable {
	private static final String  PARTICIPANTE = "src/main/resources/song/vamos-conhecer-agora-o-nosso-participante-voice.mp3";
	private static final String  SOM_INICIO_GAME = "src/main/resources/song/vai-comecar-o-show-do-milhao-voice.mp3";
	private static final String  LAYOUT_TELA_INICIAL = "/view/LayoutTelaInicial.fxml";
	private static final String  LAYOUT_TELA_PRINCIPAL = "/view/LayoutTelaPrincipal.fxml";
	private static final String  CSS = "/css/ButtonStyle.css";
	
	@FXML
	private void voltar(ActionEvent event) throws IOException {
		ControllerUtil.changeLayout(getClass(), LAYOUT_TELA_INICIAL, CSS);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startVoice(PARTICIPANTE);
	}
	
	@FXML
	private void startGame(ActionEvent event) throws IOException {
		ControllerUtil.changeLayout(getClass(), LAYOUT_TELA_PRINCIPAL, CSS);
		startVoice(SOM_INICIO_GAME);
	}
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}

	
	

}
