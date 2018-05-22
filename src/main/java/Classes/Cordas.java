package Classes;

public class Cordas extends Instrumento {

    private String qtdCordas;
    private String tipoBraco;
    private String tipoCorpo;
    private String origem;

    public Cordas() {
    }

    public Cordas(String qtdCordas, String tipoBraco, String tipoCorpo, String origem,
            String nome, String cor, String marca, double preco, int quantidade) {
        super(nome, cor, marca, preco, quantidade);
        this.qtdCordas = qtdCordas;
        this.tipoBraco = tipoBraco;
        this.tipoCorpo = tipoCorpo;
        this.origem = origem;
    }

    @Override
    public String definirTipoInstr() {
        return "cordas";
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
