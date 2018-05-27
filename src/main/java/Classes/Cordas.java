package Classes;

import Servicos.ServicoInstrumento;

public class Cordas extends Instrumento {

    private String qtdCordas;
    private String tipoBraco;
    private String tipoCorpo;
    private String origem;

    public Cordas() {
    }

    public Cordas(String qtdCordas, String tipoBraco, String tipoCorpo, String origem,
            String nome, String cor, String marca, double preco, int quantidade, String tipo) {
        super(nome, cor, marca, preco, quantidade, tipo);
        this.qtdCordas = qtdCordas;
        this.tipoBraco = tipoBraco;
        this.tipoCorpo = tipoCorpo;
        this.origem = origem;
    }

    @Override
    public double aplicarDesconto(int qtd, double total) {
        if (qtd > 3) {
            total = total * 0.8;
        }
        return total;
    }

    public String getQtdCordas() {
        return qtdCordas;
    }

    public void setQtdCordas(String qtdCordas) {
        this.qtdCordas = qtdCordas;
    }

    public String getTipoBraco() {
        return tipoBraco;
    }

    public void setTipoBraco(String tipoBraco) {
        this.tipoBraco = tipoBraco;
    }

    public String getTipoCorpo() {
        return tipoCorpo;
    }

    public void setTipoCorpo(String tipoCorpo) {
        this.tipoCorpo = tipoCorpo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

}
