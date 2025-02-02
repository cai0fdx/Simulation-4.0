
public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "root";
    private static final String PASSWORD = "senha";

    public static void main(String[] args) throws InterruptedException { 

        while(true){
        solicitation pedido = new solicitation();
       solicitation.order(true);

       System.out.println("Robot in movimentation\n");
       Thread.sleep(1000);

        Sensores.sensores();
        DB.inserirSensoresNoBanco(false, false, false, false, false);
        Thread.sleep(2000);
        }

       
    }
}