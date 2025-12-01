package folha;

public class Estagiario extends Contribuinte {

    public Estagiario(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public double calcularINSS() {
        return salarioBruto * 0.08; // simulação
    }

    @Override
    public double calcularIRPF() {
        return 0.0; // simulação de isenção
    }
}
