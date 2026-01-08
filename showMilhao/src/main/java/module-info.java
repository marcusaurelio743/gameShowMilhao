module showMilhao {
	opens br.com.showmilhao.controller;
	opens br.com.showmilhao.model;
	requires javafx.controls;
	requires log4j;
	requires jlayer;
	requires java.sql;
	requires java.desktop;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires com.jfoenix;
	
	opens br.com.showmilhao.application to javafx.graphics, javafx.fxml;
}
