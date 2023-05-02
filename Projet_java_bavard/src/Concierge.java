import java.util.ArrayList;
import java.util.List;

// Classe Concierge pour repr�senter le concierge dans l'application ePapotage
public class Concierge implements PapotageListener {
    private List<Bavard> bavards; // Liste des bavards souscrits
    
    // Constructeur
    public Concierge() {
        bavards = new ArrayList<>();
    }
    
    // M�thode pour ajouter un bavard � la liste des souscrits
    public void ajouterBavard(Bavard bavard) {
        bavards.add(bavard);
    }
    
    // M�thode pour recevoir un message de papotage d'un bavard
    public void recevoirPapotage(Bavard emetteur, PapotageEvent event) {
        // Transmettre l'�v�nement de messagerie � tous les bavards souscrits
        for (Bavard bavard : bavards) {
            // Ne pas transmettre l'�v�nement � l'�metteur d'origine
            if (!bavard.equals(emetteur)) {
                bavard.onPapotageReceived(event);
            }
        }
    }
    
    // M�thode de l'interface PapotageListener, appel�e lorsqu'un �v�nement de messagerie est re�u
    @Override
    public void onPapotageReceived(PapotageEvent event) {
        // Traiter l'�v�nement de messagerie re�u (par exemple, l'afficher � l'utilisateur)
        System.out.println("Concierge a re�u un message : Sujet = " + event.getSujet() + ", Corps = " + event.getCorps());
    }
}
