import java.util.ArrayList;
import java.util.List;

// Classe Concierge pour représenter le concierge dans l'application ePapotage
public class Concierge implements PapotageListener {
    private List<Bavard> bavards; // Liste des bavards souscrits
    
    // Constructeur
    public Concierge() {
        bavards = new ArrayList<>();
    }
    
    // Méthode pour ajouter un bavard à la liste des souscrits
    public void ajouterBavard(Bavard bavard) {
        bavards.add(bavard);
    }
    
    // Méthode pour recevoir un message de papotage d'un bavard
    public void recevoirPapotage(Bavard emetteur, PapotageEvent event) {
        // Transmettre l'événement de messagerie à tous les bavards souscrits
        for (Bavard bavard : bavards) {
            // Ne pas transmettre l'événement à l'émetteur d'origine
            if (!bavard.equals(emetteur)) {
                bavard.onPapotageReceived(event);
            }
        }
    }
    
    // Méthode de l'interface PapotageListener, appelée lorsqu'un événement de messagerie est reçu
    @Override
    public void onPapotageReceived(PapotageEvent event) {
        // Traiter l'événement de messagerie reçu (par exemple, l'afficher à l'utilisateur)
        System.out.println("Concierge a reçu un message : Sujet = " + event.getSujet() + ", Corps = " + event.getCorps());
    }
}
