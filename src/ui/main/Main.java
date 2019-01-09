package ui.main;


import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe principal do projeto
 * @author Luciano
 */
public class Main extends Application {
    
    public void start(Stage stage) throws IOException{
        
        //Configurando o local da aplicação
        Locale.setDefault(new Locale("pt", "BR"));
        
        //Leitura do FXML
        Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        
        //Titulo da Janela
        stage.setTitle("Sistema Adega");
        
        //Icone da janela
        stage.getIcons().add(new Image("/imagens/vinho.png"));
        
        //Maximizar a janela
        stage.setMaximized(true);
        
        //Criação da cena
        Scene scene = new Scene(root);
                
        //Configuração da janela
        stage.setScene(scene);
        stage.show();
        
        
    }
    //Sempre fixo chamando a execucao do javafx
    public static void main(String[] args) {
        launch(args);
    } 
    
}
