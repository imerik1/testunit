package com.ibm.erik.testunit.service.impl;

import com.ibm.erik.testunit.model.Pessoa;
import com.ibm.erik.testunit.repository.PessoaRepository;
import com.ibm.erik.testunit.service.PessoaService;
import com.ibm.erik.testunit.service.expection.UnicidadeCpfException;

import java.util.Optional;

public class PessoaServiceImpl implements PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) throws UnicidadeCpfException {
        Optional<Pessoa> opt = pessoaRepository.findById(pessoa.getCpf());
        if (opt.isPresent()) {
            throw new UnicidadeCpfException();
        }
        return pessoaRepository.save(pessoa);
    }
}
