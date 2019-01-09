/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.principal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Normanha
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem newUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void newUser(ActionEvent event) {
        
    }

    @FXML
    private void newUser(Event event) {
        Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/ui/cadastroUsuario/TelaUsuario.fxml"));
                    }catch(IOException ex){
                        
                    }
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Cadastro de Usuario");
                
              
               // newUser.getScene().getWindow().hide();
               //Commit
    }
    
}
