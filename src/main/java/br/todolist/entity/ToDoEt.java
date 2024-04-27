package br.todolist.entity;

import br.core.domain.AbstractClassET;
import br.core.domain.UserEt;
import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class ToDoEt extends AbstractClassET {

    public ToDoEt() {
    }
    private String discricao;

    private boolean realizado;

    private int prioridade;

    @OneToOne()
    private UserEt createdBy;


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

    public UserEt getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEt createdBy) {
        this.createdBy = createdBy;
    }
}
