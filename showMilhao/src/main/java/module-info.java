module showMilhao {
	requires javafx.controls;
	requires log4j;
	
	opens br.com.showmilhao.application to javafx.graphics, javafx.fxml;
}
