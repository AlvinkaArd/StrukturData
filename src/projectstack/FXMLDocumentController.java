package projectstack;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField tfPush, tfPop, tfStack;

    Stack<String> tumpukan = new Stack<>();

    @FXML
    private void handlePush(ActionEvent event) {
        tumpukan.push(tfPush.getText());
        tfPush.setText("");
        tfStack.setText(tumpukan.toString());
    }

    @FXML
    private void handlePop(ActionEvent event) {
        tfPop.setText(tumpukan.pop());
        tfStack.setText(tumpukan.toString());
    }

    @FXML
    private void clearAll(ActionEvent event) {
        tumpukan.clear();
        tfStack.setText(tumpukan.toString());
    }

    @FXML
    private void saveKeXML (ActionEvent event) {
        XStream xStream = new XStream(new StaxDriver());

        String xml = xStream.toXML(tumpukan);
        FileOutputStream outputDoc;

        try {
            byte[] data = xml.getBytes("UTF-8");
            outputDoc = new FileOutputStream("savedStack.xml");
            outputDoc.write(data);
            outputDoc.close();
        } catch (Exception io) {
            System.err.println("An error occour: " + io.getMessage());
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
