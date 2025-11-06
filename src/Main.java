import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        while(true){

            System.out.println("=== Menu ===\n\n1.Adicionar funcionário \n2.Remover funcionário " +
                    "\n3.Tabela de funcionários \n4.Bonificar funcionário \n5.Sair");
            System.out.print("Opção desejada: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            if(op == 5){
                break;
            }

            switch (op){

                case 1:

                    System.out.println("=== Adicionando Funcionário ===");

                    System.out.print("Cargo: ");
                    String positionF = scanner.nextLine();

                    System.out.print("Nome Completo: ");
                    String nameF = scanner.nextLine();

                    System.out.print("Idade: ");
                    int ageF = scanner.nextInt();

                    System.out.print("Salario base: ");
                    double salarioBaseF = scanner.nextDouble();

                    if(positionF.equalsIgnoreCase("Efetivo")){
                        Funcionario fNew = new FuncionarioEfetivo(nameF, ageF, "Efetivo", salarioBaseF);
                        fNew.calcularSalarioFinal();
                        funcionarios.add(fNew);

                    }else if(positionF.equalsIgnoreCase("Temporario")){
                        Funcionario fNew = new FuncionarioTemporario(nameF, ageF, "Temporario", salarioBaseF);
                        fNew.calcularSalarioFinal();
                        funcionarios.add(fNew);
                    }else if(positionF.equalsIgnoreCase("Estagiario")){
                        Funcionario fNew = new Estagiario(nameF, ageF, "Estagiario", salarioBaseF);
                        fNew.calcularSalarioFinal();
                        funcionarios.add(fNew);
                    }

                    System.out.println("Funcionário " + nameF + " Adicionado com sucesso.");
                    break;

                case 2:

                    if(funcionarios.isEmpty()){
                        System.out.println("Não existem nenhum funcionário registrado");
                        break;
                    }

                    System.out.println("=== Funcionários Cadastrados ===\n");
                    for(int i = 0; i < funcionarios.size(); i++){

                        System.out.println(i + " - " + funcionarios.get(i).name + "(" +
                                funcionarios.get(i).position + ")");
                    }

                    System.out.print("Funcionário que deseja remover: ");
                    int idRemoveF = scanner.nextInt();

                    if (idRemoveF >= 0 && idRemoveF < funcionarios.size()) {
                        System.out.println("Funcionário " + funcionarios.get(idRemoveF).name +
                                " removido com sucesso ");

                        funcionarios.remove(idRemoveF);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;


                case 3:

                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.\n");
                        break;
                    }

                    System.out.println("=== Funcionários ===\n");

                    System.out.printf("%-15s %-8s %-12s %-14s %-10s %-14s%n",
                            "Nome", "Idade", "Cargo", "Salário Base", "Bônus", "Salário Final");

                    for(Funcionario f : funcionarios){

                        f.exibirDados();
                    }
                    break;

                case 4:

                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado para bonificar.");
                        break;
                    }

                    System.out.println("\n=== Funcionários ===");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario f = funcionarios.get(i);
                        System.out.println(i + " - " + f.name + " (" + f.position + ")");
                    }

                    System.out.print("Digite o número do funcionário que receberá o bônus: ");
                    int idBonus = Integer.parseInt(scanner.nextLine());

                    if (idBonus < 0 || idBonus >= funcionarios.size()) {
                        System.out.println("Índice inválido!");
                        break;
                    }

                    System.out.print("Digite a porcentagem de bônus (%): ");
                    double porcentagem = Double.parseDouble(scanner.nextLine());

                    Funcionario f = funcionarios.get(idBonus);

                    if (f instanceof Bonificacao) {
                        ((Bonificacao) f).aplicarBonus(porcentagem);
                        System.out.println("Bônus aplicado com sucesso!");
                    } else {
                        System.out.println("Este tipo de funcionário não recebe bônus.");
                    }

                    break;

                default:
                    System.out.println("Digite o número equivalente de uma das opções!");




            }
        }
    }

}