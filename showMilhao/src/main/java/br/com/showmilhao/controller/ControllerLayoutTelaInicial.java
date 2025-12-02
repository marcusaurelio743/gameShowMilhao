package br.com.showmilhao.controller;

import java.io.IOException;

import br.com.showmilhao.util.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerLayoutTelaInicial {
	private static final String LAYOUT_TELA = "/view/LayoutTelaNome.fxml";
	private static final String CSS = "/css/ButtonStyle.css";
	@FXML
	private void jogar(ActionEvent event) throws IOException {
		ControllerUtil.changeLayout(getClass(), LAYOUT_TELA, CSS);
		
	}
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}

}
