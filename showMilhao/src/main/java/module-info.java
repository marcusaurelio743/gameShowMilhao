module showMilhao {
	requires javafx.controls;
	requires log4j;
	requires jlayer;
	requires java.sql;
	
	opens br.com.showmilhao.application to javafx.graphics, javafx.fxml;
}
