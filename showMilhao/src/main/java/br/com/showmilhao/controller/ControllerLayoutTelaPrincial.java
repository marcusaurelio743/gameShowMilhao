package br.com.showmilhao.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.showmilhao.model.Jogador;
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.service.JogadorService;
import br.com.showmilhao.service.PerguntaService;
import br.com.showmilhao.util.ControllerUtil;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ControllerLayoutTelaPrincial implements Initializable {
	private JogadorService jogadorService;
	private List<Long> idsPerguntasFeitas = new ArrayList<>();
	private PerguntaService perguntaService;
	private int contadorPerguntasRespondida = 2;
	private static final String NivelFacil = "Facil";
	private int pontuacaoErro = 2500;
	
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
		processarPerguntasFacil();
	}
	
	private Jogador getJogador() {
		return  jogadorService.listar()
							.stream().reduce((jogador1,jogador2) -> jogador2).orElseThrow();
		
	}
	
	private void initLabels() {
		labelNomeJogador.setText(getJogador().getNome());
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
			
			if(btnAlternativa1.getText().equals(p.getResp())) {
				setFlagRespostaCerta("respostaBtn1");
				
				btnAlternativa1.setOnMouseClicked(evento->{
					tratarAlternativaCorretaBotao(btnAlternativa1);
					contadorPerguntasRespondida++;
				});
				aplicarEventoAlternativaErrada(Arrays.asList(btnAlternativa2,btnAlternativa3,btnAlternativa4),btnAlternativa1);
				
			}else if(btnAlternativa2.getText().equals(p.getResp())) {
				setFlagRespostaCerta("respostaBtn2");

				btnAlternativa2.setOnMouseClicked(evento->{
					tratarAlternativaCorretaBotao(btnAlternativa2);
					contadorPerguntasRespondida++;
				});
				aplicarEventoAlternativaErrada(Arrays.asList(btnAlternativa1,btnAlternativa3,btnAlternativa4),btnAlternativa2);
				
			}else if(btnAlternativa3.getText().equals(p.getResp())) {
				setFlagRespostaCerta("respostaBtn3");

				btnAlternativa3.setOnMouseClicked(evento->{
					tratarAlternativaCorretaBotao(btnAlternativa3);
					contadorPerguntasRespondida++;
				});
				aplicarEventoAlternativaErrada(Arrays.asList(btnAlternativa1,btnAlternativa2,btnAlternativa4),btnAlternativa3);
				
			}else if(btnAlternativa4.getText().equals(p.getResp())) {
				setFlagRespostaCerta("respostaBtn4");

				btnAlternativa4.setOnMouseClicked(evento->{
					tratarAlternativaCorretaBotao(btnAlternativa4);
					contadorPerguntasRespondida++;
				});
				aplicarEventoAlternativaErrada(Arrays.asList(btnAlternativa1,btnAlternativa2,btnAlternativa3),btnAlternativa4);
				
			}
		});
		
		
	}
	private void setFlagRespostaCerta(String resposta) {
		
	}
	private void aplicarEventoAlternativaErrada(List<Button> butoes,Button botaoAlternativaCorreta) {
		butoes.forEach(b->b.setOnMouseClicked(evento-> tratarAlternativaErrada(botaoAlternativaCorreta)));
		
	}
	private void tratarAlternativaCorretaBotao(Button button) {
		//tratar as perguntas nivel facil
		if(isNivelFacil()) {
			if(contadorPerguntasRespondida == 2) {
				ControllerUtil.startVoice("src/main/resources/song/2-mil-reais-voice.mp3");
				
			}
			if (contadorPerguntasRespondida == 3) {
				ControllerUtil.startVoice("src/main/resources/song/3-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 4) {
				ControllerUtil.startVoice("src/main/resources/song/4-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 5) {
				ControllerUtil.startVoice("src/main/resources/song/5-mil-reais-voice.mp3");

			}
		}
		
		//tratar as perguntas nivel normal
		if(isNivelNormal()) {
			if (contadorPerguntasRespondida == 6) {
				ControllerUtil.startVoice("src/main/resources/song/10-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 7) {
				ControllerUtil.startVoice("src/main/resources/song/20-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 8) {
				ControllerUtil.startVoice("src/main/resources/song/30-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 9) {
				
				ControllerUtil.startVoice("src/main/resources/song/40-mil-reais-voice.mp3");
			}
			if (contadorPerguntasRespondida == 10) {
				ControllerUtil.startVoice("src/main/resources/song/50-mil-reais-voice.mp3");
			}
			
		}
		//tratar as perguntas nivel dificil
		if(isNivelDificil()) {
			if (contadorPerguntasRespondida == 11) {
				ControllerUtil.startVoice("src/main/resources/song/100-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 12) {
				ControllerUtil.startVoice("src/main/resources/song/200-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 13) {
				ControllerUtil.startVoice("src/main/resources/song/300-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 14) {
				ControllerUtil.startVoice("src/main/resources/song/400-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 15) {
				ControllerUtil.startVoice("src/main/resources/song/500-mil-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 16) {
				ControllerUtil.startVoice("src/main/resources/song/1-milhao-reais-voice.mp3");

			}
			if (contadorPerguntasRespondida == 17) {
				

			}
			
		}
	}
	private void processarPerguntasFacil() {
		processarPerguntas(NivelFacil);
	}
	private void tratarAlternativaErrada(Button botaoAlternativaCorreta) {
		contadorPerguntasRespondida = -1;
		ControllerUtil.startVoice("src/main/resources/song/esta-certo-disso-voice.mp3");
		int confirma = JOptionPane.showConfirmDialog(null, "você está certo disso?","Atenção",JOptionPane.YES_NO_OPTION);
		
		if(confirma == JOptionPane.YES_OPTION) {
			atualizarPontuacaoError();
			ControllerUtil.startVoice("src/main/resources/song/qual-e-a-resposta-certa-voice.mp3");
			sleep(2000);
			
			makeAlternativaErrada(botaoAlternativaCorreta);
		}
	}
	
	private void atualizarPontuacaoError() {
		atualizarPontuacaoJogador(pontuacaoErro);
	}
	private void atualizarPontuacaoJogador(int pontuacao) {
		Jogador jogador = getJogador();
		jogador.setPontuacao(pontuacao);
		jogadorService.atualizar(jogador);
		
	}
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	private FadeTransition getTransitionDefault() {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(250));
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.setCycleCount(8);
		
		return fadeTransition;
	}
	
	private void makeAlternativaErrada(Button button) {
		FadeTransition fadeTransition = getTransitionDefault();
		fadeTransition.setNode(button);
		fadeTransition.setOnFinished(f ->{
			ControllerUtil.startVoice("src/main/resources/song/que-pena-voce-errou-voice.mp3");
			sleep(2000);
			ControllerUtil.changeLayout(getClass(), "/view/LayoutTelaInicial.fxml","/css/ButtonStyle.css");
			
			
		});
		
		fadeTransition.play();
	}
	private boolean isNivelFacil() {
		return (contadorPerguntasRespondida >= 1 && contadorPerguntasRespondida <= 5);
	}
	private boolean isNivelNormal() {
		return (contadorPerguntasRespondida >= 6 && contadorPerguntasRespondida <= 10);
	}
	private boolean isNivelDificil() {
		return (contadorPerguntasRespondida >= 11 && contadorPerguntasRespondida <= 17);
	}

}
