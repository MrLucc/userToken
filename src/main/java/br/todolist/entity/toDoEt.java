package br.todolist.entity;

import br.core.abstracts.abstractClassET;
import br.user.entity.userEt;
import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class toDoEt extends abstractClassET {

    public toDoEt() {
    }


    private String discricao;

    private boolean realizado;

    private int prioridade;

    @OneToOne()
    private userEt createdBy;


    public String getDiscricao() {
        return discricao;
    }

    public void setDiscricao(String discricao) {
        this.discricao = discricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public userEt getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(userEt createdBy) {
        this.createdBy = createdBy;
    }
}
