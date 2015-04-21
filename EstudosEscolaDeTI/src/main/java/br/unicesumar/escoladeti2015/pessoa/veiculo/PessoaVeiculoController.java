package br.unicesumar.escoladeti2015.pessoa.veiculo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa-veiculo")
public class PessoaVeiculoController {
    @Autowired
    private PessoaVeiculoService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public void salvarPessoa(Pessoa pessoa){
        this.service.salvarPessoa(pessoa);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void salvarVeiculo(Veiculo veiculo){
        this.service.salvarVeiculo(veiculo);
    }
    
    @RequestMapping(value = "/pessoa/{veiculoId}/veiculos", method = RequestMethod.GET)
    public List<Map<String, Object>> getPessoasESeusVeiculos(@PathVariable Long pessoaId){
        return service.getVeiculosDasPessoas(pessoaId);
        
    }
    
}
