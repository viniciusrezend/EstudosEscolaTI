package br.unicesumar.escoladeti2015.pessoa.veiculo;

import br.unicesumar.escoladeti2015.pessoa.veiculo.Pessoa;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String modelo;

    @ManyToMany(mappedBy = "veiculos", cascade = CascadeType.ALL)
    private Set<Pessoa> pessoas = new HashSet<>();
    
    public Veiculo() {
    }

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", modelo=" + modelo + ", pessoas=" + pessoas + '}';
    }
    
    
    

    
}
