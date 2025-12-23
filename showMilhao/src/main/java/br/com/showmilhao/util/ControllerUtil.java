package br.com.showmilhao.util;

import java.io.File;

import br.com.showmilhao.application.ApplicationShowMilhao;
import br.com.showmilhao.application.Jlayer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ControllerUtil {
	private ControllerUtil() {
	}
	
	public static void exit() {
		System.exit(0);
	}
	
	public static void startVoice(String voice) {
		Jlayer jlayer = new Jlayer();
		File mp3 = new File(voice);
		jlayer.tocar(mp3);
		jlayer.start();
	}
	public static void changeLayout(Class<?> classe, String layout, String css) {
		try {
			AnchorPane pane = FXMLLoader.load(classe.getResource(layout));
			pane.getStylesheets().add(classe.getResource(css).toExternalForm());
			ApplicationShowMilhao.chageScanner(new Scene(pane,780,600));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
