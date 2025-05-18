import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Dipendente> filtraDipendenti(List<Dipendente> dipendenti, FiltroDipendente filtro) {
        return dipendenti.stream()
                .filter(filtro::compara)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Dipendente dipendente1 = new Dipendente("Sara", 20, 25000, Dipartimento.HR);
        Dipendente dipendente2 = new Dipendente("Marco", 35, 40000, Dipartimento.FINANCE);
        Dipendente dipendente3 = new Dipendente("Sonia", 48, 55000, Dipartimento.SALES);
        Dipendente dipendente4 = new Dipendente("Giovanni", 27, 35000, Dipartimento.IT);
        Dipendente dipendente5 = new Dipendente("Alessio");
        Dipendente dipendente6 = new Dipendente("Monica");
        Dipendente dipendente7 = new Dipendente("Giulia");
        List<Dipendente> dipendenti = new ArrayList<>();
        dipendenti.add(dipendente1);
        dipendenti.add(dipendente2);
        dipendenti.add(dipendente3);
        dipendenti.add(dipendente4);
        dipendenti.add(dipendente5);
        dipendenti.add(dipendente6);
        dipendenti.add(dipendente7);

        List<Dipendente> etaSopra30 = filtraDipendenti(dipendenti, d -> d.getEta() > 30);
        System.out.println("Dipendenti con età maggiore di 30: " + etaSopra30.size());

        List<Dipendente> stipendioOltre50k = filtraDipendenti(dipendenti, d -> d.getStipendio() > 50000);
        System.out.println("Dipendenti con stipendio superiore a 50.000: " + stipendioOltre50k.size());

        dipendenti.sort(Comparator.comparing(Dipendente::getNome));
        for(Dipendente dipendente : dipendenti){
            System.out.print(dipendente.getNome()+" ");
        }
    }
}
