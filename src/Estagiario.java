public class Estagiario extends Funcionario implements Bonificacao{

    public Estagiario(String name, int age, String position, double salarioBase){
        super(name, age, position, salarioBase);

    }

    @Override
    public void aplicarBonus(double porcentagemBonus) {
        if(porcentagemBonus/100 <= 0.05){
            bonus = porcentagemBonus/100;
        }else{
            bonus = 0.05;

        }
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
