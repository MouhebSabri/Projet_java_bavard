import java.util.ArrayList;
import java.util.List;

// Classe Batiment pour repr�senter le b�timent dans l'application ePapotage
public class Batiment {
    private Concierge concierge; // Le concierge du b�timent
    private List<Bavard> bavards; // La liste des bavards du b�timent
    private List<Bavard> bavardsConnectes; // La liste des bavards connect�s

    // Constructeur
    public Batiment() {
        concierge = new Concierge(); // Cr�ation du concierge
        bavards = new ArrayList<>(); // Initialisation de la liste des bavards
        bavardsConnectes = new ArrayList<>(); // Initialisation de la liste des bavards connect�s
    }
    
    // M�thode pour cr�er un nouveau bavard avec un nom donn�
    public Bavard creerBavard(String nom) {
        Bavard bavard = new Bavard(nom); // Cr�ation du bavard avec le nom donn�
        bavards.add(bavard); // Ajout du bavard � la liste des bavards du b�timent
        concierge.ajouterBavard(bavard); // Ajout du bavard en tant que souscrit du concierge
        return bavard; // Retourne le bavard cr��
    }
    
    // M�thode pour permettre � un bavard de se connecter et de manifester son int�r�t � recevoir les messages du concierge
    public void connecterBavard(Bavard bavard) {
        if (!bavardsConnectes.contains(bavard)) { // Si le bavard n'est pas d�j� connect�
            bavardsConnectes.add(bavard); // Ajout du bavard � la liste des bavards connect�s
            concierge.ajouterBavard(bavard); // Ajout du bavard en tant que souscrit du concierge
        }}}
    
    
    
    
    
        
