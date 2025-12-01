package br.com.showmilhao.application;
	
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
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void chageScanner(Scene scene) {
		stage.setScene(scene);
	}
	
}
