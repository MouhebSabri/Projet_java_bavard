import java.util.ArrayList;
import java.util.List;

public class Bavard implements PapotageListener {
    private String nom; // Nom du bavard
    private List<BavardListener> bavardListeners; // Liste des auditeurs de ce bavard

    // Constructeur
    public Bavard(String nom) {
        this.nom = nom;
        this.bavardListeners = new ArrayList<>();
    }

    // Méthode pour envoyer un message de papotage au concierge
    public void envoyerPapotage(String sujet, String corps) {
        PapotageEvent event = new PapotageEvent(sujet, corps);
        for (BavardListener listener : bavardListeners) {
            listener.onBavardConnected(event);
        }
    }

    // Méthode pour ajouter un auditeur de ce bavard
    public void ajouterBavardListener(BavardListener listener) {
        bavardListeners.add(listener);
    }

    // Méthode pour accéder au nom du bavard
    public String getNom() {
        return nom;
    }

    // Méthode de l'interface PapotageListener, appelée lorsqu'un événement de messagerie est reçu
    @Override
    public void onPapotageReceived(PapotageEvent event) {
        // Traiter l'événement de messagerie reçu (par exemple, l'afficher à l'utilisateur)
        System.out.println("Bavard " + nom + " a reçu un message : Sujet = " + event.getSujet() + ", Corps = " + event.getCorps());
    }
}
