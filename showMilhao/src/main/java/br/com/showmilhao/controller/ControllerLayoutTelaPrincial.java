package br.com.showmilhao.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.showmilhao.util.ControllerUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControllerLayoutTelaPrincial implements Initializable {
	
	@FXML
	private Label labelNomeJogador;
	
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelNomeJogador.setText("xxxxxxxxxx");
	}

}
