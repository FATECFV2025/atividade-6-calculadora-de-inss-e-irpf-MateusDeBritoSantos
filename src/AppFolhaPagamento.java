package folha;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AppFolhaPagamento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contribuinte> lista = new ArrayList<>();

        System.out.println("=== Sistema de Folha de Pagamento (simulação) ===");

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nNome: ");
            String nome = sc.nextLine().trim();

            System.out.print("CPF: ");
            String cpf = sc.nextLine().trim();

            double salarioBruto = 0.0;
            while (true) {
                System.out.print("Salário bruto (use ponto para decimais): ");
                String salStr = sc.nextLine().trim();
                try {
                    salarioBruto = Double.parseDouble(salStr);
                    if (salarioBruto < 0) {
                        System.out.println("Salário não pode ser negativo. Tente novamente.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Tente novamente.");
                }
            }

            System.out.println("Tipo do contribuinte (1=CLT, 2=Estagiário, 3=Prestador):");
            int tipo = 0;
            while (true) {
                System.out.print("Escolha: ");
                String t = sc.nextLine().trim();
                try {
                    tipo = Integer.parseInt(t);
                    if (tipo < 1 || tipo > 3) {
                        System.out.println("Escolha inválida. Digite 1, 2 ou 3.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite 1, 2 ou 3.");
                }
            }

            Contribuinte c;
            switch (tipo) {
                case 1:
                    c = new FuncionarioCLT(nome, cpf, salarioBruto);
                    break;
                case 2:
                    c = new Estagiario(nome, cpf, salarioBruto);
                    break;
                default:
                    c = new PrestadorServico(nome, cpf, salarioBruto);
            }

            lista.add(c);
            System.out.println("\nContribuinte adicionado. Resumo:");
            c.exibirResumo();

            System.out.print("\nDeseja inserir outro contribuinte? (s/n): ");
            String resp = sc.nextLine().trim().toLowerCase();
            if (!resp.equals("s") && !resp.equals("sim")) {
                continuar = false;
            }
        }

        System.out.println("\n=== Relatório Final ===");
        for (Contribuinte c : lista) {
            System.out.println("--------------------------------------------");
            c.exibirResumo();
        }
        System.out.println("--------------------------------------------");
        sc.close();
    }
}
