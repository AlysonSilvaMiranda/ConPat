package ifsp.conpat.domain.entities;

/**
 * Created by Carlos Zucherato on 30/10/2016.
 */
public class depreciacao {

    private String ncm;
    private String descricao;
    //Em Anos
    private int vidaUtil;
    private double taxaAnual;

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public double getTaxaAnual() {
        return taxaAnual;
    }

    public void setTaxaAnual(float taxaAnual) {
        this.taxaAnual = taxaAnual;
    }
}
