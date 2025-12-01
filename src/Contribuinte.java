package folha;

import java.util.Locale;
import java.text.NumberFormat;

public abstract class Contribuinte implements CalculadoraTributo {
    protected String nome;
    protected String cpf;
    protected double salarioBruto;

    public Contribuinte(String nome, String cpf, double salarioBruto) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBruto = salarioBruto;
    }

    // getters e setters (omita aqui se já copiou do código inteiro)

    @Override
    public double calcularSalarioLiquido() {
        double inss = calcularINSS();
        double irpf = calcularIRPF();
        return salarioBruto - inss - irpf;
    }

    public void exibirResumo() {
        Locale ptBr = new Locale("pt", "BR");
        NumberFormat moeda = NumberFormat.getCurrencyInstance(ptBr);

        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário bruto: " + moeda.format(salarioBruto));
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Valor INSS: " + moeda.format(calcularINSS()));
        System.out.println("Valor IRPF: " + moeda.format(calcularIRPF()));
        System.out.println("Salário líquido: " + moeda.format(calcularSalarioLiquido()));
    }
}
