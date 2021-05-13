package com.ibm.erik.testunit.service;

import com.ibm.erik.testunit.model.Pessoa;
import com.ibm.erik.testunit.service.expection.UnicidadeCpfException;

public interface PessoaService {

    Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException;
}
