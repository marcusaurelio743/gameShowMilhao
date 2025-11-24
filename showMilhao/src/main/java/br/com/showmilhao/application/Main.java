package br.com.showmilhao.application;
	
import br.com.showmilhao.util.LogUtil;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private final static String FILE_MUSIC = "src/main/resources/song/som-abertura-2.mp3";
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Janela inicial do jogo");
			LogUtil.getLogger(Main.class).info(primaryStage.getTitle());
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			ContinuousReprodution reprodution = new ContinuousReprodution(FILE_MUSIC, Boolean.TRUE);
			reprodution.start();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
