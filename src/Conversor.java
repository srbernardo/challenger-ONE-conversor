class Conversor {
    public double converter(Moeda origem, String codigoDestino) {
        double valorOrigem = origem.getValor();
        double cotacaoDestino = Cotacao.getCotacao(codigoDestino);

        return Math.round(valorOrigem * cotacaoDestino * 100.0) / 100.0;
    }
}
