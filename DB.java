import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
     public static void inserirSensoresNoBanco(boolean sensor1, boolean sensor2, boolean sensor3, boolean sensor4, boolean sensor5) {
        
        String url = "jdbc:mysql://localhost:3306/teste";
        String usuario = "root";  
        String senha = "nova_senha";  

        // Conectar no banco de dados
        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Database connected!");
       
            String sql = "INSERT INTO sensores (sensor1, sensor2, sensor3, sensor4, sensor5) VALUES (?, ?, ?, ?, ?)";

         
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Definir os valores para os sensores (0 = false, 1 = true)
                stmt.setInt(1, sensor1 ? 1 : 0);
                stmt.setInt(2, sensor2 ? 1 : 0);
                stmt.setInt(3, sensor3 ? 1 : 0);
                stmt.setInt(4, sensor4 ? 1 : 0);
                stmt.setInt(5, sensor5 ? 1 : 0);

                // Executar a inserção
                stmt.executeUpdate();
                System.out.println("Dados inseridos com sucesso no banco de dados.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ou inserir no banco de dados: " + e.getMessage());
        }
    }
}
