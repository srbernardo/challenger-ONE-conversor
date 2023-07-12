import javax.swing.JOptionPane;

public class SistemaAmericano {
    public static double metricaEscolhida(String escolha) {
        if (escolha.equals("De Centímetros a Polegadas")) {
            return 0.39;
        } else if (escolha.equals("De Metros a Pés")) {
            return 3.28;
        } else if (escolha.equals("De Quilômetros a Milhas")) {
            return 0.62;
        } else if (escolha.equals("De Litros a Galões")) {
            return 0.26;
        } else if (escolha.equals("De Quilos a Libras")) {
            return 2.20;
        } else if (escolha.equals("De Polegadas a Centímetros")) {
            return 2.54;
        } else if (escolha.equals("De Pés a Metros")) {
            return 0.30;
        } else if (escolha.equals("De Milhas a Quilômetros")) {
            return 1.61;
        } else if (escolha.equals("De Galões a Litros")) {
            return 3.78;
        } else if (escolha.equals("De Libras a Quilos")) {
            return 0.45;
        }
        return 1;
    }

    public static boolean converterSistemaAmericano() {
        String valorInput = JOptionPane.showInputDialog("Insira um valor");
        return escolhaDaConversao(valorInput);
    }

    private static boolean escolhaDaConversao(String valorInput) {
        int desejaContinuar;
        if (valorInput != null) {
            try {
                double valor = Double.parseDouble(valorInput);
                desejaContinuar = escolhaDaMedida(valor);
                return App.continuar(desejaContinuar);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido", "Message", JOptionPane.INFORMATION_MESSAGE);
                desejaContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Escolha uma Opção", 1);
                return App.continuar(desejaContinuar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static int escolhaDaMedida(double origem) {
        Object[] medidas = {"De Centímetros a Polegadas", "De Metros a Pés", "De Quilômetros a Milhas",
                "De Litros a Galões", "De Quilos a Libras", "De Polegadas a Centímetros",
                "De Pés a Metros", "De Milhas a Quilômetros", "De Galões a Litros",
                "De Libras a Quilos"};

        Object escolhaMedidas = JOptionPane.showInputDialog(
                null,
                "Escolha uma moeda para a qual você deseja girar seu dinheiro",
                "Moedas",
                JOptionPane.DEFAULT_OPTION,
                null, medidas,
                null
        );

        if (escolhaMedidas == null) {
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Message", JOptionPane.INFORMATION_MESSAGE);
            return -1;
        } else {
            String escolhaMoedaString = escolhaMedidas.toString();
            double metrica = metricaEscolhida(escolhaMoedaString);

            Conversor conversor = new Conversor();

            String conversaoFinal = "O valor da conversão " + escolhaMoedaString + " é de " + conversor.converterMedida(origem, metrica);
            JOptionPane.showMessageDialog(null, conversaoFinal, "Message", JOptionPane.INFORMATION_MESSAGE);

            int desejaContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Escolha uma Opção", 1);
            return desejaContinuar;
        }
    }
}
