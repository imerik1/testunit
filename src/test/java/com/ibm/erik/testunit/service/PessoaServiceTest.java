package com.ibm.erik.testunit.service;

import com.ibm.erik.testunit.model.Pessoa;
import com.ibm.erik.testunit.model.Telefone;
import com.ibm.erik.testunit.repository.PessoaRepository;
import com.ibm.erik.testunit.service.expection.UnicidadeCpfException;
import com.ibm.erik.testunit.service.impl.PessoaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    private static final String NOME = "Erik Santana";
    private static final String CPF = "12345678912";
    private static final String DDD = "13";
    private static final String TELEFONE = "123443210";

    @MockBean
    private PessoaRepository pessoaRepository;

    private PessoaService sut;
    private Pessoa pessoa;

    @Before
    public void setUp() throws Exception {
        sut = new PessoaServiceImpl(pessoaRepository);
        pessoa = new Pessoa();
        pessoa.setNome(NOME);
        pessoa.setCpf(CPF);

        Telefone telefone = new Telefone();
        telefone.setDdd(DDD);
        telefone.setNumero(TELEFONE);

        pessoa.setTelefones(Collections.singletonList(telefone));

        when(pessoaRepository.findById(CPF)).thenReturn(Optional.empty());
    }

    @Test
    public void deveSalvarNoRepositorio() throws UnicidadeCpfException {
        sut.salvar(pessoa);
        verify(pessoaRepository).save(pessoa);
    }

    @Test(expected = UnicidadeCpfException.class)
    public void naoDeveSalvarDuasPessoasComMesmoCpf() throws UnicidadeCpfException {
        when(pessoaRepository.findById(CPF)).thenReturn(Optional.of(pessoa));
        sut.salvar(pessoa);
    }
}
