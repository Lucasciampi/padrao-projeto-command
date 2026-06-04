package org.example;

public class Tarefa {


    private String descricao;
    private String status;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.status = "Aberta";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void concluir() {
        this.status = "Concluída";
    }

    public void cancelar() {
        this.status = "Cancelada";
    }

}
