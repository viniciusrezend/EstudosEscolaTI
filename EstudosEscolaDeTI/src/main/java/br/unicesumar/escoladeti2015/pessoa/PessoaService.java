package br.unicesumar.escoladeti2015.pessoa;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepo;
    
    public void salvarPessoa(Pessoa p){
        this.pessoaRepo.save(p);
    }
    
    public void removerPessoa(Pessoa p){
        this.pessoaRepo.delete(p);
    }
    
}
