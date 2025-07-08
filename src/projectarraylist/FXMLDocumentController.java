package projectarraylist;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    ArrayList<String> daftarData = new ArrayList<>();

    @FXML
    private TextField tfHasil;

    @FXML
    private TextField tfIndex;

    @FXML
    private TextField tfValue;

    @FXML
    private void tambahData(ActionEvent event) {
        if (tfIndex.getText().equals("")) daftarData.add(tfValue.getText());
        else daftarData.add(Integer.valueOf(tfIndex.getText()), tfValue.getText());
        tfValue.setText("");
        tfHasil.setText(daftarData.toString());
    }

    @FXML
    private void editData(ActionEvent event) {
        daftarData.set(Integer.valueOf(tfIndex.getText()), tfValue.getText());
        tfValue.setText("");
        tfHasil.setText(daftarData.toString());
    } 

    @FXML
    private void hapusData(ActionEvent event) {
        if(!tfIndex.getText().equals("")) daftarData.remove(Integer.valueOf(tfIndex.getText()));
        else daftarData.remove(Integer.parseInt(tfValue.getText()));
        tfIndex.setText("");
        tfValue.setText("");
        tfHasil.setText(daftarData.toString());
    }

    @FXML
    private void clearAllData (ActionEvent event) {
        daftarData.clear();
        tfHasil.setText(daftarData.toString());
    }

    @FXML
    private void saveKeXML (ActionEvent event) {
        XStream xStream = new XStream(new StaxDriver());

        String xml = xStream.toXML(daftarData);
        FileOutputStream outputDoc;

        try {
            byte[] data = xml.getBytes("UTF-8");
            outputDoc = new FileOutputStream("savedArrayList.xml");
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
