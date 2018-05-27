package Classes;

public class Percussao extends Instrumento {

    private String tipoMadeira;
    private String qtdPratos;
    private String dimensaoCaixa;
    private String dimensaoToms;

    public Percussao() {
    }

    public Percussao(String tipoMadeira, String qtdPratos, String dimensaoCaixa, String dimensaoToms,
            String nome, String cor, String marca, double preco, int quantidade, String tipo) {
        super(nome, cor, marca, preco, quantidade, tipo);
        this.tipoMadeira = tipoMadeira;
        this.qtdPratos = qtdPratos;
        this.dimensaoCaixa = dimensaoCaixa;
        this.dimensaoToms = dimensaoToms;
    }

    @Override
    public double aplicarDesconto(int qtd, double total) {
        if (qtd > 2) {
            total = total * 0.85;
        }
        return total;
    }

    public String getTipoMadeira() {
        return tipoMadeira;
    }

    public void setTipoMadeira(String tipoMadeira) {
        this.tipoMadeira = tipoMadeira;
    }

    public String getQtdPratos() {
        return qtdPratos;
    }

    public void setQtdPratos(String qtdPratos) {
        this.qtdPratos = qtdPratos;
    }

    public String getDimensaoCaixa() {
        return dimensaoCaixa;
    }

    public void setDimensaoCaixa(String dimensaoCaixa) {
        this.dimensaoCaixa = dimensaoCaixa;
    }

    public String getDimensaoToms() {
        return dimensaoToms;
    }

    public void setDimensaoToms(String dimensaoToms) {
        this.dimensaoToms = dimensaoToms;
    }

}
