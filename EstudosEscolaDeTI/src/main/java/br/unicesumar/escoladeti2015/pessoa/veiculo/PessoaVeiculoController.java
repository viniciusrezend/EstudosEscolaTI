package br.unicesumar.escoladeti2015.pessoa.veiculo;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
    public void criar(){
        Pessoa vinicius = new Pessoa("vinicius",23);
        Pessoa teste = new Pessoa("Teste",1);
        
        final Veiculo gol = service.salvarVeiculo(new Veiculo("Gol"));
        final Veiculo astra = service.salvarVeiculo(new Veiculo("Astra"));
        
       vinicius.adicionarVeiculo(gol);
       teste.adicionarVeiculo(astra);
       
       service.salvarPessoa(teste);
       service.salvarPessoa(vinicius);
        
    }
    
    
    
    @RequestMapping(value="/pessoa/{pessoa_id}/veiculos",method = RequestMethod.GET)
    public List<Map<String,Object>> getPessoasESeusVeiculos(@PathVariable Long pessoa_id){
        return this.service.getVeiculosDasPessoasViaSQL(pessoa_id);
    }
    
    @RequestMapping(value = "/veiculo/{veiculo_id}/pessoas",method = RequestMethod.GET)
    public Set<Pessoa> getVeiculosDasPessoas(@PathVariable Long veiculo_id){
        return service.getVeiculosDasPessoas(veiculo_id);
        
    }
    
    /*
    @RequestMapping(method = RequestMethod.POST)
    public void salvarPessoa(Pessoa pessoa){
        this.service.salvarPessoa(pessoa);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void salvarVeiculo(Veiculo veiculo){
        this.service.salvarVeiculo(veiculo);
    }
    */
    
    
}
