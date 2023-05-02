package advinhacarro.model;


import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Reinaldo
 */
public class ListaDeCarros {
    
    private List<Carro> carros = new LinkedList<>();

    public ListaDeCarros() {
    }
    
    public ListaDeCarros(List<Carro> carros) {
        this.carros.addAll(carros);
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

  
    
}
