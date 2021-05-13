package com.ibm.erik.testunit.repository;

import com.ibm.erik.testunit.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
