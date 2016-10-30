package ifsp.conpat.domain;

/**
 * Created by Carlos Zucherato on 30/10/2016.
 */
public class inventario {

    private estoque estoque;
    private depreciacao deprecicao;

    public estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(estoque estoque) {
        this.estoque = estoque;
    }

    public depreciacao getDeprecicao() {
        return deprecicao;
    }

    public void setDeprecicao(depreciacao deprecicao) {
        this.deprecicao = deprecicao;
    }
}
