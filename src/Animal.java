// Cria uma Class chamado 'Animal'
public class Animal {
    String tipo;
    Integer energia = 100;
    Integer saude = 100;
    Integer felicidade = 100;
    Integer higiene = 100;

    public void brincar() {
        System.out.println("Oba, brincando!");
        felicidade+=10;
        energia-=15;
        higiene-=20;
        limitarAtributos();
    }

    public void comer() {
        System.out.println("Nhac nhac!");
        felicidade+=20;
        higiene-=5;
        limitarAtributos();
    }

    public void dormir() {
        System.out.println("ZzzZzZz...");
        felicidade+=30;
        energia+=50;
        limitarAtributos();
    }

    public void limpar() {
        System.out.println("Hora do banho!");
        higiene+=50;
        saude+=10;
        felicidade+=20;
        energia-=10;
        limitarAtributos();
    }

    public void cuidarSaude() {
        System.out.println("Indo ao veterinário...");
        saude+=50;
        energia-=20;
        felicidade+=30;
        limitarAtributos();
    }

    // metodo para garantir que o valor fique entre 0 e 100

    private void limitarAtributos() {
        // Garante o que o valor maximo seja (100)
        if (energia > 100) energia = 100;
        if (saude > 100) saude = 100;
        if (felicidade > 100) felicidade = 100;
        if (higiene > 100) higiene = 100;

        // Garante que o valor minimo seja (0)
        if (energia < 0) energia = 0;
        if (saude < 0) saude = 0;
        if (felicidade < 0) felicidade = 0;
        if (higiene < 0) higiene = 0;
    }

    // Metodo para mostra os status atuais

    public void mostrarStatus () {
        System.out.println("--- Status do " + tipo + " ---");
        System.out.println("Energia: " + energia);
        System.out.println("Saúde: " + saude);
        System.out.println("Felicidade: " + felicidade);
        System.out.println("Higiene: " + higiene);
        System.out.println("-------------------------");
    }
}

