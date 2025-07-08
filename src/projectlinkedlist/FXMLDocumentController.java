package projectlinkedlist;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField tfLinkedList, tfAdd;

    LinkedList<String> dataLL = new LinkedList<>();

    @FXML
    private void addFirst (ActionEvent event) {
        dataLL.addFirst(tfAdd.getText());
        tfLinkedList.setText(dataLL.toString());
        tfAdd.setText("");
    }

    @FXML
    private void addLast (ActionEvent event) {
        dataLL.addLast(tfAdd.getText());
        tfLinkedList.setText(dataLL.toString());
        tfAdd.setText("");
    }

    @FXML
    private void removeFirst (ActionEvent event) {
        dataLL.removeFirst();
        tfLinkedList.setText(dataLL.toString());
    }

    @FXML
    private void removeLast (ActionEvent event) {
        dataLL.removeLast();
        tfLinkedList.setText(dataLL.toString());
    }

    @FXML
    private void saveKeXML (ActionEvent event) {
        XStream xStream = new XStream(new StaxDriver());

        String xml = xStream.toXML(dataLL);
        FileOutputStream outputDoc;

        try {
            byte[] data = xml.getBytes("UTF-8");
            outputDoc = new FileOutputStream("savedLinkedList.xml");
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
