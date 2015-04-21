package br.unicesumar.escoladeti2015.pessoa.veiculo;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
