package Classes;

public class Percussao extends Instrumento {

    private String tipoMadeira;
    private int qtdPratos;
    private String dimensaoCaixa;
    private String dimensaoToms;

    public Percussao() {
    }

    public Percussao(String tipoMadeira, int qtdPratos, String dimensaoCaixa, String dimensaoToms,
            String nome, String cor, String marca, double preco, int quantidade) {
        super(nome, cor, marca, preco, quantidade);
        this.tipoMadeira = tipoMadeira;
        this.qtdPratos = qtdPratos;
        this.dimensaoCaixa = dimensaoCaixa;
        this.dimensaoToms = dimensaoToms;
    }

    @Override
    public String definirTipoInstr() {
        return "percussao";
    }

    public String getTipoMadeira() {
        return tipoMadeira;
    }

    public void setTipoMadeira(String tipoMadeira) {
        this.tipoMadeira = tipoMadeira;
    }

    public int getQtdPratos() {
        return qtdPratos;
    }

    public void setQtdPratos(int qtdPratos) {
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
