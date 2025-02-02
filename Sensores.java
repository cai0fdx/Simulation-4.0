import java.util.Scanner;


public class Sensores {

    public static void sensores() {
        // Lógica para obter os valores dos sensores
        Scanner scan = new Scanner(System.in);
        
        int item2 = 0;
        int item3 = 0;
        int item4 = 0;
        int item5 = 0;

        boolean sensor1 = false;
        boolean sensor2 = false;
        boolean sensor3 = false;
        boolean sensor4 = false;
        boolean sensor5 = false;

        System.out.println("Por favor, siga a ordem dos itens abaixo:\n1-Item 1\n2-Item 2\n3-Item 3\n4-Item 4\n5-Item 5\n->");
        int item = scan.nextInt();

        if (item == 1) {
            sensor1 = true;
            System.out.println("\nSensor 1 true");
            System.out.println("2-Item 2\n3-Item 3\n4-Item 4\n5-Item 5\n->");
            item2 = scan.nextInt();
        }

        if (sensor1 && item2 == 2) {
            sensor2 = true;
            System.out.println("\nSensor 2 true");
            System.out.println("3-Item 3\n4-Item 4\n5-Item 5\n->");
            item3 = scan.nextInt();
        }

        if (sensor1 && sensor2 && item3 == 3) {
            sensor3 = true;
            System.out.println("\nSensor 3 true");
            System.out.println("4-Item 4\n5-Item 5\n->");
            item4 = scan.nextInt();
        }

        if (sensor1 && sensor2 && sensor3 && item4 == 4) {
            sensor4 = true;
            System.out.println("\nSensor 4 true");
            System.out.println("5- Item 5");
            item5 = scan.nextInt();
        }

        if (sensor1 && sensor2 && sensor3 && sensor4 && item5 == 5) {
            sensor5 = true;
            System.out.println("\nSensor 5 true");
            System.out.println("Pedido concluído");

            // Envia os dados para o banco de dados
            DB.inserirSensoresNoBanco(sensor1, sensor2, sensor3, sensor4, sensor5);
        } else {
            System.out.println("Erro");
        }
        
        scan.close();
    }
  
}
