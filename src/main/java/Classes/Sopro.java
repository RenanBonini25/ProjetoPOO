package Classes;

public class Sopro extends Instrumento {

    private String material;
    private String acabamento;
    private String afinacao;

    public Sopro() {
    }

    public Sopro(String material, String acabamento, String afinacao, String nome,
            String cor, String marca, double preco, int quantidade) {
        super(nome, cor, marca, preco, quantidade);
        this.material = material;
        this.acabamento = acabamento;
        this.afinacao = afinacao;
    }

    @Override
    public double aplicarDesconto(int qtd, double total) {
        if (qtd > 2) {
            total = ((total/100) * 12) - 10;
        }
        return total;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getAfinacao() {
        return afinacao;
    }

    public void setAfinacao(String afinacao) {
        this.afinacao = afinacao;
    }

}
