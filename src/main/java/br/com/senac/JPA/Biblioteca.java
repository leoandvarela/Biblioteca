
package br.com.senac.JPA;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Biblioteca")
@Table(name="biblioteca")

public class Biblioteca {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private long id;
    
    private String autor;
    
    private String nomelivro;
    
    private String datapublicacao;
    
    private String genero;
    
    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAutor () {
        return autor;
    }
    
    public void setAutor (String autor){
        this.autor = autor;
    }
    
    public String getnomeLivro () {
        return nomelivro;
    }
    
    public void setnomeLivro (String nomelivro){
        this.nomelivro = nomelivro;
    }
    
     public String getdataPublicacao() {
        return datapublicacao;
    }

    public void setdataPublicacao(String datapublicacao) {
        this.datapublicacao = datapublicacao;
    }
    
    public String getGenero () {
        return genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }  
}
