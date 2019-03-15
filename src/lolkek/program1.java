package lolkek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class program1 {
	@FXML
    private TextField inputTextField;

    @FXML
    private Label label1;
    
    @FXML
    private Label label2;

    public void calc(ActionEvent event) {
        try {
            String number = inputTextField.getText();
            int n = Integer.parseInt(number);
            String x16 = Integer.toHexString(n);
            String x8= Integer.toOctalString(n);
            label1.setText(x16);
            label2.setText(x8);
        } catch (Exception e) {
      
        }
    }
}
