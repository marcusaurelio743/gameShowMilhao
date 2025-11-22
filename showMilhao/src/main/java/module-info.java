module showMilhao {
	requires javafx.controls;
	
	opens br.com.showmilhao.application to javafx.graphics, javafx.fxml;
}
