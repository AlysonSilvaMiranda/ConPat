package ifsp.conpat.domain;

import java.util.Date;

/**
 * Created by Carlos Zucherato on 30/10/2016.
 */
public class aquisicao {

    private produto produto;
    private double valor;
    private Date dataAquisicao;

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }
}
