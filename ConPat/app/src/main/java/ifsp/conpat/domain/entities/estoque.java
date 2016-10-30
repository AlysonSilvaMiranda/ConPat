package ifsp.conpat.domain.entities;

/**
 * Created by Carlos Zucherato on 30/10/2016.
 */
public class estoque {

    private produto produto;
    private double quantidade;
    private double valorUnitario;
    private double valorTotal;

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal(double quantidade, double valorUnitario)
    {
        return valorTotal = quantidade * valorTotal;
    }
}
