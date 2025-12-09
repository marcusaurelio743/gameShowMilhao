package br.com.showmilhao.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.showmilhao.util.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControllerLayoutTelaRegra implements Initializable {
		private static final String  LAYOUT_TELA_INICIAL = "/view/LayoutTelaInicial.fxml";
	private static final String  CSS = "/css/ButtonStyle.css";
	
	@FXML
	private void voltar(ActionEvent event) throws IOException {
		ControllerUtil.changeLayout(getClass(), LAYOUT_TELA_INICIAL, CSS);
		
	}

	
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
	

}
