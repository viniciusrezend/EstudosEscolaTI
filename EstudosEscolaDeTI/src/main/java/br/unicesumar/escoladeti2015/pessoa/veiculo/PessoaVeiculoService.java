package br.unicesumar.escoladeti2015.pessoa.veiculo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class PessoaVeiculoService {
    @Autowired
    private PessoaRepository pessoaRepo;
    
    @Autowired
    private VeiculoRepository veiculoRepo;
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    public Pessoa salvarPessoa(Pessoa p){
        return this.pessoaRepo.save(p);
    }
    
    public Veiculo salvarVeiculo(Veiculo v){
        return this.veiculoRepo.save(v);
    }
    
    public void removerPessoa(Pessoa p){
        this.pessoaRepo.delete(p);
    }
    
    public void removerVeiculo(Veiculo v){
        this.veiculoRepo.delete(v);
    }
    
    public List<Map<String, Object>> getVeiculosDasPessoas(Long pessoaId){
        List<Map<String, Object>> veiculos;
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", pessoaId);
        veiculos = jdbcTemplate.query(
                "select v.id, v.nome"
                +"from veiculo v"
                +"inner join pessoa_veiculo pv on pv.veiculo_id = p.id"
                +"where pv.pessoa_id =:id", params,new MapRowMapper());
                
        return veiculos;        
    }
    
    
    
    
    
    public Set<Veiculo> getPessoasESeusVeiculos(Long pessoaId){
        return this.pessoaRepo.getOne(pessoaId).getVeiculos();
    }
    
    public Set<Pessoa> getPessoasEVeiculos(Long veiculoId){
        return this.veiculoRepo.getOne(veiculoId).getPessoas();
    }
    
    
}
