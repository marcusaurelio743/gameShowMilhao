package br.com.showmilhao.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.com.showmilhao.model.JogadorTable;
import br.com.showmilhao.service.JogadorService;
import br.com.showmilhao.util.ControllerUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ControllerLayoutTelaRanking implements Initializable {
	
	private static final String  LAYOUT_TELA_INICIAL = "/view/LayoutTelaInicial.fxml";
	private static final String  CSS = "/css/ButtonStyle.css";
	private static final String MENSAGEM_CONFIRMACAO = "Deseja Zerar o Ranking?";
	
	private JogadorService jogadorService;
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private Button btnLimpar;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private JFXButton btnFechar;
	
	@FXML
	private TableView<JogadorTable> tblRanking;
	
	@FXML
	private TableColumn<JogadorTable, Integer> tblClmPosicao;
	
	@FXML
	private TableColumn<JogadorTable, String> tblClmNome;
	
	@FXML
	private TableColumn<JogadorTable, Integer> tblClmPontuacao;
	
	public ControllerLayoutTelaRanking() {
		jogadorService = new JogadorService();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setResisable(Boolean.FALSE);
		processarJogadoresTable();
	}
	
	@FXML
	private void limparRanking(ActionEvent e) {
		
		setResisable(Boolean.FALSE);
		int result = JOptionPane.showConfirmDialog(null, MENSAGEM_CONFIRMACAO);
		
		if(result == JOptionPane.YES_OPTION) {
			jogadorService.zerarRanking();
			processarJogadoresTable();
			btnLimpar.setVisible(false);
		}
	}
	
	private List<JogadorTable> mostrarRankingView(){
		List<JogadorTable> jogadores = new ArrayList<>();
		jogadorService.listarRanking().forEach(jogador -> jogadores.add(new JogadorTable(jogador)));
		
		/*for (JogadorTable jogadorTable : jogadores) {
			System.out.println(jogadorTable.getNomeTabela()+" || "+jogadorTable.getPontuacaoTable());
		}*/
		
		return jogadores ;
	}
	
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}
	
	@FXML
	private void voltar(ActionEvent event) throws IOException {
		ControllerUtil.changeLayout(getClass(), LAYOUT_TELA_INICIAL, CSS);
		
	}
	
	private void processarJogadoresTable() {
		tblClmPontuacao.setCellValueFactory(new PropertyValueFactory<>("pontuacaoTable"));
		tblClmNome.setCellValueFactory(new PropertyValueFactory<>("nomeTabela"));
		tblClmPosicao.setCellValueFactory(new PropertyValueFactory<>("linhaTabela"));
		
		ObservableList<JogadorTable> jogadorTable = FXCollections.observableArrayList(mostrarRankingView());
		
		tblRanking.setItems(jogadorTable);
	}
	
	private void setResisable(boolean visible) {
		tblClmNome.setResizable(visible);
		tblClmPontuacao.setResizable(visible);
		tblClmPosicao.setResizable(visible);
		
	}

}
