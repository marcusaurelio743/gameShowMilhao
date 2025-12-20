package br.com.showmilhao.application;
	
import br.com.showmilhao.model.Pergunta;
import br.com.showmilhao.service.PerguntaService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
  

public class ApplicationShowMilhao extends Application {
	private final static String FILE_MUSIC = "src/main/resources/song/som-abertura-2.mp3";
	private final static String TELA_INICIAL = "/view/LayoutTelaInicial.fxml";
	private final static String ESTILO_BOTOES = "/css/ButtonStyle.css"; 
	private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			
			primaryStage.setTitle("Show do Milhão");
			
			Pane telaInicial = FXMLLoader.load(getClass().getResource(TELA_INICIAL));
			
			Scene scene = new Scene(telaInicial,780,600);
			telaInicial.getStylesheets().add(getClass().getResource(ESTILO_BOTOES).toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			ContinuousReprodution reprodution = new ContinuousReprodution(FILE_MUSIC, Boolean.TRUE);
			reprodution.start();
			/*Jlayer layer = new Jlayer();
			File mp3 = new File("src/main/resources/song/tire-a-carta-do-baralho-voice.mp3");
			layer.tocar(mp3);
			layer.start();*/
			addPergunta();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void chageScanner(Scene scene) {
		stage.setScene(scene);
	}
	public static void addPergunta() {
		PerguntaService perguntaService = new PerguntaService();
		Pergunta pergunta1 = new Pergunta(
				null, "Facil",
				"Qual foi a linguagem de programação criada pela sun em 1995?",
				"PHP",
				"Javascript",
				"JAVA",
				"JAVA");
		Pergunta pergunta2 = new Pergunta(
				null, "Facil",
				"Quanto é 1 + 1",
				"0",
				"3",
				"2",
				"2");
		Pergunta pergunta3 = new Pergunta(
				null, "Facil",
				"Qual é o Pilar da POO que encapsula as informações de um objeto?",
				"Herança",
				"polimorfismo",
				"encapsulamento",
				"encapsulamento");
		Pergunta pergunta4 = new Pergunta(
				null, "Facil",
				"Qual empresa no dias de hoje é a mantenedora do Java?",
				"Microsoft",
				"Apple",
				"Oracle",
				"Oracle");
		perguntaService.inserir(pergunta1);
		perguntaService.inserir(pergunta2);
		perguntaService.inserir(pergunta3);
		perguntaService.inserir(pergunta4);
	}
	
}
