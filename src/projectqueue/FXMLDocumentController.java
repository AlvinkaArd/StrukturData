package projectqueue;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
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
    private TextField tfDaftarAntrian, tfAntrianMasuk, tfAntrianKeluar;

    Queue<String> antrian = new LinkedList<>();

    @FXML
    private void masukAntrian(ActionEvent event) {
        antrian.add(tfAntrianMasuk.getText());
        tfAntrianMasuk.setText("");
        tfDaftarAntrian.setText(antrian.toString());
    }

    @FXML
    private void keluarAntrian(ActionEvent event) {
        tfAntrianKeluar.setText(antrian.remove());
        tfDaftarAntrian.setText(antrian.toString());
    }

    @FXML
    private void saveKeXML (ActionEvent event) {
        XStream xStream = new XStream(new StaxDriver());

        String xml = xStream.toXML(antrian);
        FileOutputStream outputDoc;

        try {
            byte[] data = xml.getBytes("UTF-8");
            outputDoc = new FileOutputStream("savedQueue.xml");
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
