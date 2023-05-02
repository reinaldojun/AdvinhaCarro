package advinhacarro.service;

import advinhacarro.model.Carro;
import advinhacarro.model.ListaDeCarros;
import advinhacarro.model.TipoCarro;
import java.util.List;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Reinaldo
 */
public class CarroService {

    private final ListaDeCarros carrosSedan = new ListaDeCarros();
    private final ListaDeCarros carrosHatch = new ListaDeCarros();
    private Integer saida;

    public CarroService() {
        this.carrosSedan.getCarros().add(new Carro("Corolla GLi", null));
        this.carrosHatch.getCarros().add(new Carro("Fiat Uno", null));
    }

    public void analizarCarro(TipoCarro tipoCarro) {
        switch (tipoCarro) {
            case SEDAN:
                sedanOuHatch(carrosSedan);
                break;
            case HATCH:
                sedanOuHatch(carrosHatch);
                break;
        }
    }

    public void sedanOuHatch(ListaDeCarros carrosList) {
        List<Carro> carros = carrosList.getCarros();
        int indice = carros.size() - 1;
        while (indice > 0) {
            saida = showConfirmDialog(null, "O carro que pensou é o " + carros.get(indice).getReferencia() + " ?", "Carro", JOptionPane.YES_NO_OPTION);
            if (saida == JOptionPane.YES_OPTION) {
                saida = showConfirmDialog(null, "O carro que pensou é o " + carros.get(indice).getNome() + " ?", "Carro", JOptionPane.YES_NO_OPTION);
                if (saida == JOptionPane.YES_OPTION) {
                    showMessageDialog(null, "Acertei novamente!", "Carro", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            saida = showConfirmDialog(null, "O carro que pensou é o " + carros.get(indice).getNome() + " ?", "Carro", JOptionPane.YES_NO_OPTION);
            if (saida == JOptionPane.YES_OPTION) {
                showMessageDialog(null, "Acertei novamente!", "Carro", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (indice == 0 && saida == JOptionPane.NO_OPTION) {
                gravarNovoCarro(carros, indice);
                break;
            }
            indice--;
        }
        if (indice == 0) {
           carrosEmMemoria(carros,indice);
        }
    }
    
    public void carrosEmMemoria(List<Carro> carros, int indice) {
        saida = showConfirmDialog(null, "O carro que pensou é o " + carros.get(indice).getNome() + " ?", "Carro", JOptionPane.YES_NO_OPTION);
        if (saida == JOptionPane.YES_OPTION) {
            showMessageDialog(null, "Acertei novamente!", "Carro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        gravarNovoCarro(carros, indice);
    }

    public void gravarNovoCarro(List<Carro> carros, int indice) {
        String nome = showInputDialog(null, "Qual carro você pensou ?", "Desisti", JOptionPane.QUESTION_MESSAGE);
        String referencia = showInputDialog(null, nome + " é_______ mas " + carros.get(indice).getNome() + " não.", "Complete", JOptionPane.QUESTION_MESSAGE);
        carros.add(new Carro(nome, referencia));
    }

}
