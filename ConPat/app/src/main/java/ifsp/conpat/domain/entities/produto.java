package ifsp.conpat.domain.entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.nfc.Tag;
import android.util.Log;
import android.widget.ImageView;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Carlos Zucherato on 30/10/2016.
 */
public class produto implements Serializable {

    private int produtoId;
    private String nome;
    private String descricao;
    private String ean;
    private String marca;
    private String modelo;
    private String status;
    private Date dataCadastro;
    private Date dataAquisicao;
    private ImageView foto;
    private String ncm;
    private double valor;
    private String serie;
    private Double taxaDepreciacao;
    private String latitude;
    private String longitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {

        DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            this.dataAquisicao = iso8601Format.parse(dataAquisicao);
        }
        catch(ParseException e)
        {
            Log.e("ERROR:", "Parsing ISO8601 datetime failed", e);
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {

        DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try
        {
            this.dataCadastro = iso8601Format.parse(dataCadastro);
        }
        catch(ParseException e)
        {
            Log.e("ERROR:", "Parsing ISO8601 datetime failed", e);
        }

    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto, Context context) {

        Bitmap bmp = BitmapFactory.decodeByteArray(foto, 0, foto.length);
        ImageView image = new ImageView(context);
        image.setImageBitmap(bmp);

        this.foto = image;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public Double getTaxaDepreciacao() {
        return taxaDepreciacao;
    }

    public void setTaxaDepreciacao(Double taxaDepreciacao) {
        this.taxaDepreciacao = taxaDepreciacao;
    }
}
