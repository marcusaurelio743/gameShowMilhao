package br.com.showmilhao.application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import br.com.showmilhao.util.LogUtil;
import javazoom.jl.player.Player;

public class Jlayer extends Thread {
	private File mp3;
	
	public void tocar(File mp3) {
		this.mp3 = mp3;
	}
	
	@Override
	public void run() {
		try {
			try (FileInputStream fileInputStream = new FileInputStream(mp3)) {
				BufferedInputStream bufferStream = new BufferedInputStream(fileInputStream);
				
				Player player = new Player(bufferStream);
				player.play();
				if(player.isComplete()) {
					player.close();
				}
			}

			
		}catch (Exception e) {
			LogUtil.getLogger(Jlayer.class).error(e.getCause().toString());
		}
		
	}
	
	

}
