import java.util.concurrent.ThreadLocalRandom;

// Cria uma Class chamado 'Animal'
public class Animal {
    String tipo;
    Integer energia = 100;
    Integer saude = 100;
    Integer felicidade = 100;
    Integer higiene = 100;
    boolean vivo = true;

    public void brincar() {
        if (!this.vivo) {
            System.out.println("Ele nao pode brincar pois esta morto!");
            return;
        }
        System.out.println("Oba, brincando!");
        felicidade+=10;
        energia-=15;
        higiene-=20;
        passarTempo();
        atualizarStatus();
    }

    public void comer() {
        if (!this.vivo) {
            System.out.println("Ele nao pode brincar pois esta morto!");
            return;
        }
        System.out.println("Nhac nhac!");
        felicidade+=20;
        higiene-=5;
        passarTempo();
        atualizarStatus();
    }

    public void dormir() {
        if (!this.vivo) {
            System.out.println("Ele nao pode dormir pois esta morto!");
            return;
        }
        System.out.println("ZzzZzZz...");
        felicidade+=30;
        energia+=50;
        passarTempo();
        atualizarStatus();
    }

    public void limpar() {
        if (!this.vivo) {
            System.out.println("Ele nao pode tomar banho pois esta morto!");
            return;
        }
        System.out.println("Hora do banho!");
        higiene+=50;
        saude+=10;
        felicidade+=20;
        energia-=10;
        passarTempo();
        atualizarStatus();
    }

    public void cuidarSaude() {
        if (!this.vivo) {
            System.out.println("Ele nao pode cuidar da saude pois esta morto!");
            return;
        }
        System.out.println("Indo ao veterinário...");
        saude+=50;
        energia-=20;
        felicidade+=30;
        passarTempo();
        atualizarStatus();
    }

    // Gera um desgaste aleatório pequeno
    private void passarTempo() {
        energia -= ThreadLocalRandom.current().nextInt(1, 5);
        felicidade -= ThreadLocalRandom.current().nextInt(1, 5);
        higiene -= ThreadLocalRandom.current().nextInt(1, 5);
    }

    // checar penalidades
    private void checarPenalidades() {
        // Se a felicidade chegar a 0, perde saúde (como você pediu)
        if (felicidade == 0) {
            System.out.println("!! " + tipo + " está muito infeliz e ficou doente! Perdeu 20 de saúde.");
            saude -= 20;
        }

        // Se a higiene chegar a 0, fica doente
        if (higiene == 0) {
            System.out.println("!! " + tipo + " está muito sujo e contraiu uma infecção! Perdeu 20 de saúde.");
            saude -= 20;
        }

        // Se a energia chegar a 0, ele desmaia e fica triste
        if (energia == 0) {
            System.out.println("!! " + tipo + " desmaiou de cansaço! Perdeu 15 de felicidade.");
            felicidade -= 15;
        }

        // NOVO: Verificação da MORTE
        if (saude <= 0) {
            saude = 0; // Trava em 0
            this.vivo = false; // MORREU
        }
    }

    // metodo que garante que o valor fique entre 0 e 100 e atualiza os valores e checa as penalidades

    private void atualizarStatus() {
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

        checarPenalidades();
    }

    public boolean estaVivo() {
        return this.vivo;
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

