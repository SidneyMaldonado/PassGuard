package com.devapp.mal.passguard;

import java.io.Serializable;

public class DadosAcesso implements Serializable {

    private Integer id;
    private String local;
    private String descricao;
    public String toString(){
        return getLocal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
