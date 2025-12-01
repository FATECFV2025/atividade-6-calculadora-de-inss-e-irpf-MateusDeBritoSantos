package folha;

public class FuncionarioCLT extends Contribuinte {

    public FuncionarioCLT(String nome, String cpf, double salarioBruto) {
        super(nome, cpf, salarioBruto);
    }

    @Override
    public double calcularINSS() {
        return salarioBruto * 0.11; // exemplo didático
    }

    @Override
    public double calcularIRPF() {
        double base = salarioBruto - calcularINSS();
        if (base <= 1903.98) {
            return 0.0;
        } else if (base <= 2826.65) {
            return base * 0.075;
        } else if (base <= 3751.05) {
            return base * 0.15;
        } else if (base <= 4664.68) {
            return base * 0.225;
        } else {
            return base * 0.275;
        }
    }
}
