package br.com.showmilhao.controller;

import java.io.IOException;

import br.com.showmilhao.application.ApplicationShowMilhao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ControllerLayoutTelaInicial {
	@FXML
	private void jogar(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/LayoutTelaNome.fxml"));
		
		ApplicationShowMilhao.chageScanner(new Scene(pane, 800, 600));
	}

}
