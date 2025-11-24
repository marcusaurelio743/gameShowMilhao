module showMilhao {
	requires javafx.controls;
	requires log4j;
	requires jlayer;
	
	opens br.com.showmilhao.application to javafx.graphics, javafx.fxml;
}
