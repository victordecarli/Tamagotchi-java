void main() {

    Scanner sc = new Scanner(System.in);
    System.out.println("=======================");
    System.out.println(" BEM-VINDO AO TAMAGOTCHI!");
    System.out.println("=======================");
    System.out.println("Escolha o seu bixinho:");
    System.out.println("1 - Cachorro");
    System.out.println("2 - Gato");
    System.out.println("3 - Papagaio");
    int escolhaDoUser = sc.nextInt();
    Animal bicho = switch (escolhaDoUser) {
        case 1 -> new Cachorro();
        case 2 -> new Gato();
        case 3 -> new Papagaio();
        default -> {
            System.out.println("Opção inválida! Vamos de Cachorro mesmo.");
            yield new Cachorro();
        }
    };

    System.out.println("\nParabéns! Você adotou um " + bicho.tipo + "!");

    while (bicho.estaVivo()) {

        // Mostra o status atual
        bicho.mostrarStatus();

        // Mostra o Menu
        System.out.println("O que você quer fazer?");
        System.out.println("1. Brincar");
        System.out.println("2. Comer");
        System.out.println("3. Dormir");
        System.out.println("4. Limpar (Banho)");
        System.out.println("5. Cuidar da Saúde (Veterinário)");
        System.out.println("0. Desistir (Sair do Jogo)");

        int escolhaAcao = sc.nextInt();

        // Executa a ação escolhida
        switch (escolhaAcao) {
            case 1:
                bicho.brincar();
                break;
            case 2:
                bicho.comer();
                break;
            case 3:
                bicho.dormir();
                break;
            case 4:
                bicho.limpar();
                break;
            case 5:
                bicho.cuidarSaude();
                break;
            case 0:
                System.out.println("Você abandonou seu bixinho... :(");
                // Força a saída do loop
                bicho.vivo = false;
                break;
            default:
                System.out.println("Ação inválida! Tente novamente.");
        }
    }

    System.out.println("\n=======================");
    if (bicho.saude <= 0) {
        System.out.println("Ah, não... Seu " + bicho.tipo + " não resistiu.");
        System.out.println("Você não cuidou bem dele.");
    }
    System.out.println("--- GAME OVER ---");
    System.out.println("=======================");

    sc.close(); // Fecha o scanner

}
