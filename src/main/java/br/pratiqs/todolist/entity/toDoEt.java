package br.pratiqs.todolist.entity;

import br.pratiqs.abstracts.abstractClassET;
import br.pratiqs.user.entity.userEt;
import jakarta.persistence.*;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Table(name = "todos")
public class toDoEt extends abstractClassET {

    public toDoEt() {
    }

//    public toDoEt(String nome, String discricao, boolean realizado, int prioridade) {
//        this.nome = nome;
//        this.discricao = discricao;
//        this.realizado = realizado;
//        this.prioridade = prioridade;
//    }

//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;
//
//    private String nome;

    private String discricao;

    private boolean realizado;

    private int prioridade;

    @OneToOne()
    private userEt createdBy;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }

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
