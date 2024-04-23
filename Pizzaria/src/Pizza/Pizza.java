package Pizza;

public class Pizza {
    private String descricao;
    private double preco;

    public Pizza(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Sabor: " + descricao + "\nPreço: " + preco;
    }
}
