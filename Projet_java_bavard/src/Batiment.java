import java.util.ArrayList;
import java.util.List;

// Classe Batiment pour représenter le bâtiment dans l'application ePapotage
public class Batiment {
    private Concierge concierge; // Le concierge du bâtiment
    private List<Bavard> bavards; // La liste des bavards du bâtiment
    private List<Bavard> bavardsConnectes; // La liste des bavards connectés

    // Constructeur
    public Batiment() {
        concierge = new Concierge(); // Création du concierge
        bavards = new ArrayList<>(); // Initialisation de la liste des bavards
        bavardsConnectes = new ArrayList<>(); // Initialisation de la liste des bavards connectés
    }
    
    // Méthode pour créer un nouveau bavard avec un nom donné
    public Bavard creerBavard(String nom) {
        Bavard bavard = new Bavard(nom); // Création du bavard avec le nom donné
        bavards.add(bavard); // Ajout du bavard à la liste des bavards du bâtiment
        concierge.ajouterBavard(bavard); // Ajout du bavard en tant que souscrit du concierge
        return bavard; // Retourne le bavard créé
    }
    
    // Méthode pour permettre à un bavard de se connecter et de manifester son intérêt à recevoir les messages du concierge
    public void connecterBavard(Bavard bavard) {
        if (!bavardsConnectes.contains(bavard)) { // Si le bavard n'est pas déjà connecté
            bavardsConnectes.add(bavard); // Ajout du bavard à la liste des bavards connectés
            concierge.ajouterBavard(bavard); // Ajout du bavard en tant que souscrit du concierge
        }}}
    
    
    
    
    
        
