package br.unicesumar.escoladeti2015.pessoa;

import br.unicesumar.escoladeti2015.veiculo.Veiculo;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private Long registro;
    private String nome;
    private int idade;
    private Veiculo veiculo;

    public Pessoa() {
    }

    public Pessoa(Long registro, String nome, int idade, Veiculo veiculo) {
        this.registro = registro;
        this.nome = nome;
        this.idade = idade;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public Long getRegistro() {
        return registro;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setRegistro(Long registro) {
        this.registro = registro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.registro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.registro, other.registro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", registro=" + registro + ", nome=" + nome + ", idade=" + idade + ", veiculo=" + veiculo + '}';
    }
    
    
    
    

}