package br.com.david.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DEPARTAMENTO")
public class Departamento implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOME",nullable = false,unique = true)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "departamento")
    private List<Funcionario> funcionarios =  new ArrayList<Funcionario>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
