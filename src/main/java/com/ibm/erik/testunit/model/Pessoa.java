package com.ibm.erik.testunit.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pessoa {
    private String nome;
    private String cpf;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;
}
