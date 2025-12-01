package folha;

public class PrestadorServico extends Contribuinte {

    public PrestadorServico(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public double calcularINSS() {
        return 0.0; // PJ simulada: sem INSS retido aqui
    }

    @Override
    public double calcularIRPF() {
        return salarioBruto * 0.06; // retenção simulada
    }
}
