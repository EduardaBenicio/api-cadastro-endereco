package com.api.teste.model;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name= "cliente")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @NonNull
    @Column
    private String nome;
    @NonNull
    @Column
    private String documento;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();


}
