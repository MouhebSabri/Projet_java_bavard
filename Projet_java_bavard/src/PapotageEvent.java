public class PapotageEvent {
    private String sujet; // Sujet du message
    private String corps; // Corps du message
    
    // Constructeur
    public PapotageEvent(String sujet, String corps) {
        this.sujet = sujet;
        this.corps = corps;
    }
    
    // Getters
    public String getSujet() {
        return sujet;
    }
    
    public String getCorps() {
        return corps;
    }
}
