package ifsp.conpat.domain.entities;

import java.util.List;

/**
 * Created by Carlos Zucherato on 30/10/2016.
 */
public class departamento {

    private String departamentoId;
    private String nome;
    private List<produto> produtos;
    private String nomeGestor;

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<produto> produtos) {
        this.produtos = produtos;
    }

    public String getNomeGestor() {
        return nomeGestor;
    }

    public void setNomeGestor(String nomeGestor) {
        this.nomeGestor = nomeGestor;
    }
}
