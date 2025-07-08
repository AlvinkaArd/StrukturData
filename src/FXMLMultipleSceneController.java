import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLMultipleSceneController implements Initializable {
    OpenScene openScene = new OpenScene();

    @FXML
    private BorderPane mainPane;

    @FXML
    public void handleButtonArrayList(ActionEvent event) {
        Pane page = openScene.getPane("projectarraylist", "FXMLDocument");
        mainPane.setCenter(page);
        System.out.println("Button array list is clicked!");
    }

    @FXML
    public void handleButtonLinkedList(ActionEvent event) {
        Pane page = openScene.getPane("projectlinkedlist", "FXMLDocument");
        mainPane.setCenter(page);
        System.out.println("Button linked list is clicked!");
    }

    @FXML
    public void handleButtonQueue(ActionEvent event) {
        Pane page = openScene.getPane("projectqueue", "FXMLDocument");
        mainPane.setCenter(page);
        System.out.println("Button queue is clicked!");
    }

    @FXML
    public void handleButtonStack(ActionEvent event) {
        Pane page = openScene.getPane("projectstack", "FXMLDocument");
        mainPane.setCenter(page);
        System.out.println("Button stack is clicked!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
