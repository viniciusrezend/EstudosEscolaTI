package br.unicesumar.escoladeti2015.pessoa.veiculo;


import br.unicesumar.escoladeti2015.pessoa.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long>  {
    
}
