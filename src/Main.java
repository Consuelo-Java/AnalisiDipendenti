import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        List<Dipendente> dipendentiPerEta = dipendenti.stream()
                .sorted((d1, d2) -> Integer.compare(d1.getEta(), d2.getEta()))
                .collect(Collectors.toList());

        System.out.println("Dipendenti ordinati per età:");
        for(Dipendente dipendente : dipendentiPerEta){
            System.out.println(dipendente.getNome()+" "+dipendente.getEta());
        }
        System.out.println("***************************");
        double stipendioMedio = dipendenti.stream()
                .mapToDouble(Dipendente::getStipendio)
                .average().getAsDouble();

        System.out.println("Stipendio medio: " + stipendioMedio);
        System.out.println("***************************");
        Map<Dipartimento, List<Dipendente>> dipendentiPerDipartimento = dipendenti.stream()
                .collect(Collectors.groupingBy(Dipendente::getDipartimento));

        System.out.println("Dipendenti raggruppati per dipartimento:");
        for(Dipartimento dipartimento : dipendentiPerDipartimento.keySet()){
            System.out.print("Dipartimento: "+dipartimento+"; Dipendenti: ");
            List<Dipendente> dipendentiDelDipartimento = dipendentiPerDipartimento.get(dipartimento);
            for(Dipendente dipendente : dipendentiDelDipartimento){
                System.out.print(dipendente.getNome()+" ");
            }
            System.out.println(" ");
        }
        System.out.println("***************************");

        // 5. Stampare i risultati con forEach
        System.out.println("Lista completa dipendenti:");
        dipendenti.forEach(System.out::println);
    }
}
