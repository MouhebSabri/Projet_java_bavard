import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BatimentUI extends JFrame {
    private Batiment batiment; // Le mod�le du b�timent
    private JPanel panelBavards; // Le panneau pour afficher les bavards
    private JTextField champNomBavard; // Le champ de texte pour le nom du bavard � cr�er
    private JButton boutonCreerBavard; // Le bouton pour cr�er un nouveau bavard
    
    public BatimentUI(Batiment batiment) {
        super("ePapotage - B�timent");
        this.batiment = batiment;
        
        // Initialisation de l'interface graphique
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        
        // Cr�ation du panneau pour afficher les bavards
        panelBavards = new JPanel(new GridLayout(0, 1));
        add(new JScrollPane(panelBavards), BorderLayout.CENTER);
        
        // Cr�ation des composants pour cr�er un nouveau bavard
        JPanel panelCreerBavard = new JPanel(new FlowLayout());
        champNomBavard = new JTextField(20);
        panelCreerBavard.add(new JLabel("Nom du bavard : "));
        panelCreerBavard.add(champNomBavard);
        boutonCreerBavard = new JButton("Cr�er");
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
    
    // M�thode pour ajouter un bavard � l'interface graphique
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