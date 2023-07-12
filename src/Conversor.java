class Conversor {
    public double converterMoeda(Moeda origem, String codigoDestino) {
        double valorOrigem = origem.getValor();
        double cotacaoDestino = Cotacao.getCotacao(codigoDestino);

        return Math.round(valorOrigem * cotacaoDestino * 100.0) / 100.0;
    }

    public double converterMedida(double origem, double metrica) {
        return Math.round(origem * metrica * 100.0) / 100.0;
    }
}
