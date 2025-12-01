module showMilhao {
	opens br.com.showmilhao.controller;
	requires javafx.controls;
	requires log4j;
	requires jlayer;
	requires java.sql;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens br.com.showmilhao.application to javafx.graphics, javafx.fxml;
}
