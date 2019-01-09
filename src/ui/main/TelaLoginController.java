/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.main;


import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import model.conexao.ConnectionFactory;

/**
 * FXML Controller class
 *
 * @author Normanha
 */
public class TelaLoginController implements Initializable {

    @FXML
    private Button btnAcess;
    @FXML
    private Button btnQuit;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logar(ActionEvent event) throws SQLException {
    
       entrar();
        
    }

    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }
    private void entrar() throws SQLException {
        //Comando
         String sql = "SELECT * FROM usuario WHERE usuario=? AND senha=?";
         
          //Preparar o SQL
        PreparedStatement ps = ConnectionFactory.prepararSQL(sql);
        
        //Substituir os parametros
        ps.setString(1, txtUser.getText());
        ps.setString(2, txtPass.getText());
        
        //Executa consulta no bd
        ResultSet resultado = ps.executeQuery();

      
            if (resultado.next()) {
               //JOptionPane.showMessageDialog(null, "Usuario Localizado");
               //Abre a tela 
                Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/ui/principal/TelaPrincipal.fxml"));
                    }catch(IOException ex){
                        
                    }
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Adm");
                
                
                btnAcess.getScene().getWindow().hide();
                
               
              //ABre uma nova tela  
              /*
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                */
            } else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido(s)");
            }

        

    }
    @FXML
    private void abrirJanelaCadastro(ActionEvent event) throws IOException {
        
        //Código para criar uma nova janela
        
        //Leitura do FXML
        Parent root = FXMLLoader.load(getClass().getResource("/ui/main/TelaDois.fxml"));

        //Criação da cena
        Scene scene = new Scene(root);

        //Criação do Stage (window)
        //Configurar o tipo da janela que vai abrir
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Tela Principal");
        
        //Icone
        stage.getIcons().add(new Image("/imagens/vinho.png"));
        
        //Adicionando a scene no stage
        stage.setScene(scene);
        
        //Modality para bloquear outras janelas
        stage.initModality(Modality.APPLICATION_MODAL);    
        
        //Mostrando a nova janela
        stage.show();
        
    }
    
    
}
