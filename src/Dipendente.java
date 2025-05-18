public class Dipendente {
    private String nome;
    private int eta;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente() {
        this.nome = "Ignoto";
        this.eta = 18;
        this.stipendio = 1000;
        this.dipartimento = Dipartimento.HR;
    }

    public Dipendente(String nome) {
        this.nome = nome;
        this.eta = 18;
        this.stipendio = 1000;
        this.dipartimento = Dipartimento.HR;
    }

    public Dipendente(String nome, int eta, double stipendio, Dipartimento dipartimento) {
        this.nome = nome;
        this.eta = eta;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }
}
