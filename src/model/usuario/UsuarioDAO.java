package model.usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.conexao.ConnectionFactory;
import model.entidades.Usuario;
/**
 *
 * @author Normanha
 */
public class UsuarioDAO {
    
public void salvar(Usuario u) throws SQLException{
        
        String sql = "INSERT INTO usuario (nome,usuario,senha) VALUES (?, ?, ?)";
        
    //Substituir os valores
    try ( //Preparar o SQL
            PreparedStatement ps = ConnectionFactory.prepararSQL(sql)) {
        //Substituir os valores
        ps.setString(1, u.getNome());
        ps.setString(2, u.getUsuario());
        ps.setString(3, u.getSenha());
        //Executar o comando no banco de dados
        ps.executeUpdate();
        //fechar a conexao
    }
        
    }
   
    

}
