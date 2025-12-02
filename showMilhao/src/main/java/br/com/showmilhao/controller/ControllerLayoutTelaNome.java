package br.com.showmilhao.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.showmilhao.application.ApplicationShowMilhao;
import br.com.showmilhao.application.Jlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ControllerLayoutTelaNome implements Initializable {
	private static final String  PARTICIPANTE = "src/main/resources/song/vamos-conhecer-agora-o-nosso-participante-voice.mp3";
	private static final String  SOM_INICIO_GAME = "src/main/resources/song/vai-comecar-o-show-do-milhao-voice.mp3";
	@FXML
	private void voltar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LayoutTelaInicial.fxml"));
		pane.getStylesheets().add(getClass().getResource("/css/ButtonStyle.css").toExternalForm());
		
		ApplicationShowMilhao.chageScanner(new Scene(pane,780,600));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startVoice(PARTICIPANTE);
	}
	
	@FXML
	private void startGame(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LayoutTelaPrincipal.fxml"));
		
		ApplicationShowMilhao.chageScanner(new Scene(pane,780,600));
		
		startVoice(SOM_INICIO_GAME);
	}
	
	private void startVoice(String voice) {
		Jlayer jlayer = new Jlayer();
		File mp3 = new File(voice);
		jlayer.tocar(mp3);
		jlayer.start();
	}

}
