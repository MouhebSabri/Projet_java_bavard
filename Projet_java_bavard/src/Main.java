import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Batiment batiment = new Batiment();
        
        System.out.println("Bienvenue dans ePapotage !");
        while (true) {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Créer un nouveau Bavard");
            System.out.println("2. Envoyer un message à tous les Bavards");
            System.out.println("3. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine();
            
            if (choix == 1) {
                System.out.println("Entrez le nom du nouveau Bavard :");
                String nom = scanner.nextLine();
                Concierge consierge = new Concierge();
              
                System.out.println("Bavard " + nom + " créé !");
            } else if (choix == 2) {
                System.out.println("Entrez votre message :");
                String message = scanner.nextLine();
            } else if (choix == 3) {
                System.out.println("Au revoir !");
                break;
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}
