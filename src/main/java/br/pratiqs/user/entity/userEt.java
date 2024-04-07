package br.pratiqs.user.entity;

import br.pratiqs.abstracts.abstractClassET;
import br.pratiqs.todolist.entity.toDoEt;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class userEt extends abstractClassET {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    //private String userName;

    private String password;

    private String email;

    @OneToOne(mappedBy = "createdBy")
    private toDoEt toDoEt;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
