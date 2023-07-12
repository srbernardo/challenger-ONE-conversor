import javax.swing.JOptionPane;

public class App {
    public static String[] moedaEscolhida(String escolha) {
        if (escolha.equals("De Reais a Dólares")) {
            return new String[]{"brl-usd", "$"};
        } else if (escolha.equals("De Reais a Euros")) {
            return new String[]{"brl-eur", "€"};
        } else if (escolha.equals("De Reais a Libras")) {
            return new String[]{"brl-gbp", "£"};
        } else if (escolha.equals("De Reais a Peso Argentino")) {
            return new String[]{"brl-ars", "$"};
        } else if (escolha.equals("De Reais a Peso Chileno")) {
            return new String[]{"brl-clp", "$"};
        } else if (escolha.equals("De Dólares a Reais")) {
            return new String[]{"usd", "R$"};
        } else if (escolha.equals("De Euros a Reais")) {
            return new String[]{"eur", "R$"};
        } else if (escolha.equals("De Libras a Reais")) {
            return new String[]{"gbp", "R$"};
        } else if (escolha.equals("De Peso Argentino a Reais")) {
            return new String[]{"ars", "R$"};
        } else if (escolha.equals("De Dólares a Peso Chileno")) {
            return new String[]{"clp", "R$"};
        }
        return new String[]{};
    }

    public static boolean converterMoeda() {
        Moeda moedaOrigem = new Moeda();
        Moeda moedaDestino = new Moeda();

        String valorInput = JOptionPane.showInputDialog("Insira um valor");

        return escolhaDaConversao(moedaOrigem, moedaDestino, valorInput);
    }

    private static boolean escolhaDaConversao(Moeda moedaOrigem, Moeda moedaDestino, String valorInput) {
        int desejaContinuar;
        if (valorInput != null) {
            try {
                double valor = Double.parseDouble(valorInput);
                moedaOrigem.setValor(valor);
                desejaContinuar = escolhaDaMoeda(moedaOrigem, moedaDestino);
                return continuar(desejaContinuar);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido", "Message", JOptionPane.INFORMATION_MESSAGE);
                desejaContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Escolha uma Opção", 1);
                return continuar(desejaContinuar);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public static int escolhaDaMoeda(Moeda moedaOrigem, Moeda moedaDestino) {
        Object[] moedas = {"De Reais a Dólares", "De Reais a Euros", "De Reais a Libras",
                "De Reais a Peso Argentino", "De Reais a Peso Chileno", "De Dólares a Reais",
                "De Euros a Reais", "De Libras a Reais", "De Peso Argentino a Reais",
                "De Peso Chileno a Reais"};

        Object escolhaMoeda = JOptionPane.showInputDialog(
                null,
                "Escolha uma moeda para a qual você deseja girar seu dinheiro",
                "Moedas",
                JOptionPane.DEFAULT_OPTION,
                null, moedas,
                null
        );

        if (escolhaMoeda == null) {
            JOptionPane.showMessageDialog(null, "Programa finalizado", "Message", JOptionPane.INFORMATION_MESSAGE);
            return -1;
        } else {
            String escolhaMoedaString = escolhaMoeda.toString();
            moedaDestino.setCodigo(moedaEscolhida(escolhaMoedaString)[0]);
            moedaDestino.setSimbolo(moedaEscolhida(escolhaMoedaString)[1]);

            Conversor conversor = new Conversor();

            moedaDestino.setValor(conversor.converterMoeda(moedaOrigem, moedaDestino.getCodigo()));
            String conversaoFinal = "O valor da conversão é de " + moedaDestino.getSimbolo() + " " + moedaDestino.getValor();
            JOptionPane.showMessageDialog(null, conversaoFinal, "Message", JOptionPane.INFORMATION_MESSAGE);

            int desejaContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Escolha uma Opção", 1);
            return desejaContinuar;
        }
    }

    public static void converterTemperatura() {
        JOptionPane.showMessageDialog(null, "Programa em construção", "Message", JOptionPane.INFORMATION_MESSAGE);

//        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura"));
        // Adicione o código para conversão de temperatura aqui
    }

    public static boolean continuar(int escolha) {
        if (escolha == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            Object[] optMenu = {"Conversor de Moeda", "Conversor de Temperatura"};
            Object escolhaMenu = JOptionPane.showInputDialog(
                    null,
                    "Escolha uma opção",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    null,
                    optMenu,
                    null);

            if (escolhaMenu == null) {
                JOptionPane.showMessageDialog(null, "Programa finalizado", "Message", JOptionPane.INFORMATION_MESSAGE);
                continuar = false;
            } else if (escolhaMenu.equals("Conversor de Moeda")) {
                continuar = converterMoeda();
            } else if (escolhaMenu.equals("Conversor Sistema Americano")) {
                converterTemperatura();
            }
        }
    }
}
