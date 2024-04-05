package br.pratiqs.abstracts;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@MappedSuperclass
public abstract class abstractClassET {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    public String getNome() {
        return nome;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
