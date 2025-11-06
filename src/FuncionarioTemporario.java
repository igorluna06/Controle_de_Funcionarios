public class FuncionarioTemporario extends Funcionario implements Bonificacao {

    public FuncionarioTemporario(String name, int age, String position, double salarioBase){
        super(name, age, position, salarioBase);

    }

    @Override
    public void aplicarBonus(double porcentagemBonus) {

        bonus = porcentagemBonus/100;
        calcularSalarioFinal();
    }

    @Override
    void calcularSalarioFinal() {

        if(bonus < 0) {
            System.out.println("O bônus não pode ser negativo!");
        }else if(bonus == 0){
            salarioFinal = salarioBase;
        }else{
            salarioFinal = salarioBase + (salarioBase*bonus);
        }

    }
}
