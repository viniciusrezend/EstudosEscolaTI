package br.unicesumar.escoladeti2015.pessoa;

public class PessoaService {
    
    private PessoaRepository pessoaRepo;
    
    public void salvarPessoa(Pessoa p){
        this.pessoaRepo.save(p);
    }
    
    public void removerPessoa(Pessoa p){
        this.pessoaRepo.delete(p);
    }
    
}
