import javax.swing.JOptionPane;

public class conversorVelocidade {
    public static void main(String[] args) {
        // Obter a velocidade em km/h do usuário
        String input = JOptionPane.showInputDialog(null, "Insira a velocidade em km/h:");
        double velocidadeKmH = Double.parseDouble(input);

        // Converter a velocidade de km/h para mph
        double velocidadeMph = velocidadeKmH / 1.60934;

        // Exibir o resultado da conversão em uma caixa de diálogo
        JOptionPane.showMessageDialog(null, "Velocidade em km/h: " + velocidadeKmH +
                "\nVelocidade em mph: " + velocidadeMph);

        JOptionPane.showMessageDialog(null, "Obrigado por utilizar o Conversor de Velocidade!");
    }
}
