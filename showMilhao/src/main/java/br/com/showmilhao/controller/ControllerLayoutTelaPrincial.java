package br.com.showmilhao.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.service.JogadorService;
import br.com.showmilhao.service.PerguntaService;
import br.com.showmilhao.util.ControllerUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerLayoutTelaPrincial implements Initializable {
	private JogadorService jogadorService;
	private List<Long> idsPerguntasFeitas = new ArrayList<>();
	private PerguntaService perguntaService;
	
	public ControllerLayoutTelaPrincial() {
		jogadorService = new JogadorService();
		perguntaService = new PerguntaService();
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
	private Button btnEnumciado;
	@FXML
	private Button btnAlternativa1;
	@FXML
	private Button btnAlternativa2;
	@FXML
	private Button btnAlternativa3;
	@FXML
	private Button btnAlternativa4;
	
	@FXML
	private void fechar() {
		ControllerUtil.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ControllerUtil.startVoice("src/main/resources/song/1-mil-reais-voice.mp3");
		initLabels();
	}
	
	private Jogador getNome() {
		return  jogadorService.listar()
							.stream().reduce((jogador1,jogador2) -> jogador2).orElseThrow();
		
	}
	
	private void initLabels() {
		labelNomeJogador.setText(getNome().getNome());
		labelAcertar.setText("1.000,00");
		labelErrar.setText("0,00");
		labelParar.setText("0,00");
		labelNumeroRodada.setText("1");
		labelNivel.setText("Fácil");
		labelNumeroPergunta.setText("1");
		
	}
	
	private String getIdPerguntasFeitas() {
		String ids = "";
		
		if(!idsPerguntasFeitas.isEmpty()) {
			ids+="(";
			for(Long id : idsPerguntasFeitas) {
				ids+= id.toString() + ",";
			}
			ids = ids.substring(0, ids.length() - 1);
			ids += ")";
		}
		
		return ids;
	}
	
	private void processarPerguntas(String nivel) {
		List<Pergunta> perguntas = perguntaService.listar(getIdPerguntasFeitas(), nivel);
		perguntas.forEach(p->{
			idsPerguntasFeitas.add(p.getId());
			btnEnumciado.setText(p.getEnumciado());
			
			List<Button> botoesRandomizados = Arrays.asList(btnAlternativa1,btnAlternativa2,btnAlternativa3,btnAlternativa4);
			
			botoesRandomizados.get(0).setText(p.getAlter1());
			botoesRandomizados.get(1).setText(p.getAlter2());
			botoesRandomizados.get(2).setText(p.getAlter3());
			botoesRandomizados.get(3).setText(p.getResp());
			
			Collections.shuffle(botoesRandomizados);
		});
		
	}

}
