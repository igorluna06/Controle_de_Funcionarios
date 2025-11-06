public abstract class Funcionario {

    protected String name;

    protected int age;

    protected String position;

    protected double salarioBase;

    protected double salarioFinal;

    protected double bonus = 0;

    public Funcionario(String name, int age, String position, double salarioBase) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salarioBase = salarioBase;
        this.salarioFinal = salarioBase;

    }

    abstract void calcularSalarioFinal();

    void exibirDados() {

        System.out.printf(
                "%-15s %-8d %-12s %-15.2f %-9.1f%% %-15.2f%n",
                name,
                age,
                position,
                salarioBase,
                bonus * 100,
                salarioFinal
        );
    }


}
