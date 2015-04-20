package br.unicesumar.escoladeti2015.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private PessoaService service;
    
    @RequestMapping
    public void salvarPessoa(Pessoa pessoa){
        this.service.salvarPessoa(pessoa);
    }
    
    @RequestMapping
    public void removerPessoa(Pessoa pessoa){
        this.service.removerPessoa(pessoa);
    }
    
}
