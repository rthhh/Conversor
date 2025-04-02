import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ConversorMoedas {
    public static void main(String[] args) {
        // Taxas de câmbio
        double[][] taxasDeCambio = {
            {1.0, 0.19, 0.16, 0.14, 20.61, 177.42},     // Real em relação a outras moedas
            {5.35, 1.0, 0.85, 0.72, 104.79, 901.58},    // Dólar em relação a outras moedas
            {6.14, 1.18, 1.0, 0.85, 124.12, 1068.41},   // Euro em relação a outras moedas
            {7.43, 1.43, 1.18, 1.0, 150.22, 1291.66},   // Libra Esterlina em relação a outras moedas
            {0.048, 0.0096, 0.0081, 0.0067, 1.0, 8.61}, // Peso Argentino em relação a outras moedas
            {0.0056, 0.0011, 0.00093, 0.00077, 0.116, 1.0} // Peso Chileno em relação a outras moedas
        };

        String[] moedas = {"Real", "Dólar", "Euro", "Libra Esterlina", "Peso Argentino", "Peso Chileno"};

        boolean continuar = true;
        
        while (continuar) {
            // Obter valor a ser convertido em uma caixa de diálogo JOptionPane
            String input = JOptionPane.showInputDialog(null, "Insira o valor a ser convertido:");
            
            // Validar a entrada para garantir que contenha apenas números
            if (input.matches("[0-9.]+")) {
                double valor = Double.parseDouble(input);

                // Obter a moeda de origem para conversão em uma caixa de diálogo JOptionPane
                int opcaoMoedaOrigem = JOptionPane.showOptionDialog(null, "Selecione a moeda de origem:", "Conversor de Moedas",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, moedas, moedas[0]);

                // Obter a moeda de destino para conversão em uma caixa de diálogo JOptionPane
                int opcaoMoedaDestino = JOptionPane.showOptionDialog(null, "Selecione a moeda de destino:", "Conversor de Moedas",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, moedas, moedas[0]);

                // Realizar a conversão com base nas moedas selecionadas
                double valorConvertido = valor * (taxasDeCambio[opcaoMoedaOrigem][opcaoMoedaDestino]);
                String moedaOrigem = moedas[opcaoMoedaOrigem];
                String moedaDestino = moedas[opcaoMoedaDestino];

                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                // Exibir o resultado da conversão em uma caixa de diálogo JOptionPane
                JOptionPane.showMessageDialog(null, "Valor em " + moedaOrigem + ": " + valor +
                        "\nValor em " + moedaDestino + ": " + decimalFormat.format(valorConvertido));
            } else {
                JOptionPane.showMessageDialog(null, "Caractere não permitido! Insira apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Perguntar se deseja continuar
            int opcaoContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Continuar",
                    JOptionPane.YES_NO_OPTION);
            
            if (opcaoContinuar == JOptionPane.NO_OPTION) {
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Obrigado por usar o calculadora de cambio!");
    }
}
