import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    public static void inserirSensoresNoBanco(boolean sensor1, boolean sensor2, boolean sensor3, boolean sensor4, boolean sensor5) {
        
        String url = "jdbc:mysql://localhost:3306/teste";
        String usuario = "root";  
        String senha = "nova_senha";  

        // Conectar no banco de dados
        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Database connected!");

            // Inserir os dados dos sensores na tabela "sensores"
            String sqlInsertSensores = "INSERT INTO sensores (sensor1, sensor2, sensor3, sensor4, sensor5) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlInsertSensores)) {
                // Definir os valores para os sensores (0 = false, 1 = true)
                stmt.setInt(1, sensor1 ? 1 : 0);
                stmt.setInt(2, sensor2 ? 1 : 0);
                stmt.setInt(3, sensor3 ? 1 : 0);
                stmt.setInt(4, sensor4 ? 1 : 0);
                stmt.setInt(5, sensor5 ? 1 : 0);

                // Executar a inserção
                stmt.executeUpdate();
                System.out.println("Dados inseridos com sucesso na tabela Sensores");

                // Verificar se todos os sensores estão em 1 (TRUE)
                if (sensor1 && sensor2 && sensor3 && sensor4 && sensor5) {
                    // Se todos os sensores estiverem em 1, incrementa o contador de martelos
                    incrementarContadorMartelos(conn);
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ou inserir no banco de dados: " + e.getMessage());
        }
    }

    // Método para incrementar o contador de martelos
    private static void incrementarContadorMartelos(Connection conn) {
        String sqlSelect = "SELECT quantidade FROM contador_martelos WHERE id = 1";
        try (PreparedStatement stmt = conn.prepareStatement(sqlSelect);
             ResultSet rs = stmt.executeQuery()) {
            
            if (rs.next()) {
                int quantidade = rs.getInt("quantidade");

                // Incrementa o contador de martelos
                String sqlUpdate = "UPDATE contador_martelos SET quantidade = ? WHERE id = 1";
                try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                    stmtUpdate.setInt(1, quantidade + 2);
                    stmtUpdate.executeUpdate();
                    System.out.println("Contador de martelos atualizado. Total: " + (quantidade + 2));
                }
            } else {
                // Se não houver registro, cria um novo contador
                String sqlInsert = "INSERT INTO contador_martelos (quantidade) VALUES (1)";
                try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                    stmtInsert.executeUpdate();
                    System.out.println("Primeiro martelo montado. Contador iniciado com 1.");
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao atualizar contador de martelos: " + e.getMessage());
        }
    }
}
