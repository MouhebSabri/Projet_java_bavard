import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BatimentUI extends JFrame {
    private Batiment batiment; // Le modèle du bâtiment
    private JPanel panelBavards; // Le panneau pour afficher les bavards
    private JTextField champNomBavard; // Le champ de texte pour le nom du bavard à créer
    private JButton boutonCreerBavard; // Le bouton pour créer un nouveau bavard
    
    public BatimentUI(Batiment batiment) {
        super("ePapotage - Bâtiment");
        this.batiment = batiment;
        
        // Initialisation de l'interface graphique
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        
        // Création du panneau pour afficher les bavards
        panelBavards = new JPanel(new GridLayout(0, 1));
        add(new JScrollPane(panelBavards), BorderLayout.CENTER);
        
        // Création des composants pour créer un nouveau bavard
        JPanel panelCreerBavard = new JPanel(new FlowLayout());
        champNomBavard = new JTextField(20);
        panelCreerBavard.add(new JLabel("Nom du bavard : "));
        panelCreerBavard.add(champNomBavard);
        boutonCreerBavard = new JButton("Créer");
        boutonCreerBavard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = champNomBavard.getText().trim();
                if (!nom.isEmpty()) {
                    Bavard bavard = batiment.creerBavard(nom);
                    ajouterBavardUI(bavard);
                }
                champNomBavard.setText("");
            }
        });
        panelCreerBavard.add(boutonCreerBavard);
        add(panelCreerBavard, BorderLayout.NORTH);
        
        
        
        
    }
    
    // Méthode pour ajouter un bavard à l'interface graphique
    private void ajouterBavardUI(Bavard bavard) {
        JPanel panelBavard = new JPanel(new FlowLayout());
        panelBavard.add(new JLabel(bavard.getNom() + " :"));
        JButton boutonConnecter = new JButton("Se connecter");
        boutonConnecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                batiment.connecterBavard(bavard);
                boutonConnecter.setEnabled(false);
            }
        });
        panelBavard.add(boutonConnecter);
        panelBavards.add(panelBavard);
        pack();
    }}