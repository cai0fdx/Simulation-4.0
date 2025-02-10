import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Pedidos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        
        frame.setLayout(new BorderLayout());

        // Texto informando sobre o pedido
        JLabel pedidoLabel = new JLabel("Loja XYZ fez um pedido. Deseja aceitar?", JLabel.CENTER);
        pedidoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // Painel para os botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        // Criando os botões
        JButton btnAceitar = new JButton("Aceitar Pedido");
        JButton btnNaoAceitar = new JButton("Não Aceitar");

        // Ação do botão "Aceitar"
        btnAceitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui o código que será executado ao clicar no botão "Aceitar"
                executarCodigo();
            }
        });
        
        // Ação do botão "Não Aceitar"
        btnNaoAceitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui, caso o administrador não aceite o pedido, não faz nada
                JOptionPane.showMessageDialog(null, "Pedido não aceito.", "Status", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();  // Fecha a janela (opcional)
            }
        });

        // Adicionando os botões ao painel
        panelBotoes.add(btnAceitar);
        panelBotoes.add(btnNaoAceitar);
        
        // Adicionando os componentes à janela
        frame.add(pedidoLabel, BorderLayout.CENTER); // A label do pedido fica no centro
        frame.add(panelBotoes, BorderLayout.SOUTH);   // O painel com os botões fica na parte inferior
        
        // Tornar a janela visível
        frame.setVisible(true);
    }

    // Método que contém o código que será executado ao clicar no botão "Aceitar"
    public static void executarCodigo() {
        try {
            // O código que será executado quando o pedido for aceito
            solicitation pedido = new solicitation();
            solicitation.order(true);

            System.out.println("Robot in movimentation\n");
            Thread.sleep(1000); // Simula um delay

            Sensores.sensores();
            DB.inserirSensoresNoBanco(false, false, false, false, false);
            Thread.sleep(2000); // Simula outro delay

            Verification.verificarion();
            
            // Exibir uma mensagem indicando que o pedido foi aceito
            JOptionPane.showMessageDialog(null, "Pedido aceito com sucesso!", "Status", JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
