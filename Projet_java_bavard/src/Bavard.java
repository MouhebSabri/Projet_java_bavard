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

    // M�thode pour envoyer un message de papotage au concierge
    public void envoyerPapotage(String sujet, String corps) {
        PapotageEvent event = new PapotageEvent(sujet, corps);
        for (BavardListener listener : bavardListeners) {
            listener.onBavardConnected(event);
        }
    }

    // M�thode pour ajouter un auditeur de ce bavard
    public void ajouterBavardListener(BavardListener listener) {
        bavardListeners.add(listener);
    }

    // M�thode pour acc�der au nom du bavard
    public String getNom() {
        return nom;
    }

    // M�thode de l'interface PapotageListener, appel�e lorsqu'un �v�nement de messagerie est re�u
    @Override
    public void onPapotageReceived(PapotageEvent event) {
        // Traiter l'�v�nement de messagerie re�u (par exemple, l'afficher � l'utilisateur)
        System.out.println("Bavard " + nom + " a re�u un message : Sujet = " + event.getSujet() + ", Corps = " + event.getCorps());
    }
}
