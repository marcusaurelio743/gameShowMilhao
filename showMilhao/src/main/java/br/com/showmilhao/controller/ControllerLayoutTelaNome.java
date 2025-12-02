package br.com.showmilhao.controller;

import java.io.IOException;

import br.com.showmilhao.application.ApplicationShowMilhao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ControllerLayoutTelaNome {
	@FXML
	private void voltar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LayoutTelaInicial.fxml"));
		pane.getStylesheets().add(getClass().getResource("/css/ButtonStyle.css").toExternalForm());
		
		ApplicationShowMilhao.chageScanner(new Scene(pane,780,600));
	}

}
