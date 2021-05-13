package com.ibm.erik.testunit.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
