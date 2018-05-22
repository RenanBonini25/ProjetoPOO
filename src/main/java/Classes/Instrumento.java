package Classes;

public abstract class Instrumento {

    private int id;
    private String nome;
    private String cor;
    private String marca;
    private double preco;
    private int quantidade;

    public Instrumento() {
    }

    public Instrumento(String nome, String cor, String marca, double preco, int quantidade) {
        this.nome = nome;
        this.cor = cor;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public abstract String definirTipoInstr();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}