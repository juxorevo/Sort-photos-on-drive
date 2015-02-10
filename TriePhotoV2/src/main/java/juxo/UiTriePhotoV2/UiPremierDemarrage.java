
package juxo.UiTriePhotoV2;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class UiPremierDemarrage extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UiPremierDemarrage() {
		
		
		
		this.setTitle("Parametre");
		this.setSize(790,770); 
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
        Image icone = Toolkit.getDefaultToolkit().getImage(UiPremierDemarrage.class.getResource("Resource\\icone-pioupiou.jpg"));
        this.setIconImage(icone);


        
        JPanel fenetre = new JPanel();
        fenetre.setLayout(new BoxLayout(fenetre, BoxLayout.Y_AXIS));
        fenetre.setBackground(Color.WHITE);
        this.add(fenetre);
        
        JScrollPane barreDefilement =new JScrollPane(fenetre,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        		this.add( barreDefilement);
  
        


//pannel 0: bienvenu
		JPanel panBienv = new JPanel();
		panBienv.setLayout(new FlowLayout());
		panBienv.setBackground(Color.WHITE);
		fenetre.add(panBienv);
		
		JLabel TxtBienvenue = new JLabel("<html><H1><u>Bienvenue dans TriePhotoV2</u></H1> Cette premiere fenetre vous permettra de vous familiariser avec l'application<br></html>");
		TxtBienvenue.setHorizontalAlignment(JLabel.CENTER);
		TxtBienvenue.setForeground(Color.gray);
		panBienv.add(TxtBienvenue);
		
		


	
//////////////////////onglet 1:///////////////////////////////////
		JPanel onglet1 = new JPanel();
		onglet1.setLayout(new BoxLayout(onglet1, BoxLayout.Y_AXIS));
	
//panel 1	: choix dossier				
				JPanel pan1 = new JPanel();
				TitledBorder bordureDossier = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(29,158,233),2),"<html><H3>Choix des dossiers</H3></html>"));
				pan1.setBorder(bordureDossier);
				bordureDossier.setTitleColor(new Color(29,158,233));
				pan1.setBackground(Color.WHITE);
				pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS)); //Layout texte descriptif

				//texte
				JPanel pan1TxtIcone = new JPanel();
				pan1TxtIcone.setLayout(new FlowLayout(FlowLayout.LEFT));
				pan1TxtIcone.setBackground(Color.WHITE);
				pan1.add(pan1TxtIcone);
				
				JLabel txtDossier = new JLabel("Selectionner le dossier source contenant vos photos et le dossier de destination pour le stockage de vos photos apres le tri");
				txtDossier.setFont(new java.awt.Font("Dialog", 0, 12)); //non gras!
				Icon iconeDossier = new ImageIcon((getClass().getResource("Resource\\dossier-icone.png")));
				txtDossier.setIcon(iconeDossier);
				

				pan1TxtIcone.add(txtDossier);
				
				
				
				
				JPanel pan1Color = new JPanel();
				pan1Color.setLayout(new GridLayout(2,1));
				pan1.add(pan1Color);
			
				//panel dossier source dossier-icone.png
				JPanel panSource = new JPanel();
				panSource.setLayout(new FlowLayout(FlowLayout.LEFT));
				panSource.setBackground(new Color(29,158,233));//bleu clair
				pan1Color.add(panSource);
				
				
				JLabel txtSource = new JLabel("Dossier source:");
				JTextField SourceField = new JTextField(20);
				JButton browseSource = new JButton("Parcourir");
				
				txtSource.setForeground(Color.WHITE);
				
				panSource.add(txtSource);
				panSource.add(SourceField);
				panSource.add(browseSource);

				
				//layout dossier cible
				JPanel panDest = new JPanel();
				panDest.setLayout(new FlowLayout(FlowLayout.LEFT));
				panDest.setBackground(new Color(29,158,233));
				pan1Color.add(panDest);
				
				JLabel txtDest = new JLabel("Dossier Destination:");
				JTextField DestField = new JTextField(20);
				JButton browseDest = new JButton("Parcourir");
				
				txtDest.setForeground(Color.WHITE);	
		
				panDest.add(txtDest);
				panDest.add(DestField);
				panDest.add(browseDest);
		
//panel 2	: option de tri	
		JPanel pan2 = new JPanel();
		TitledBorder bordureTri = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,134,28),2),"<html><H3>Options de tri</H3></html>"));
		pan2.setBorder(bordureTri);
		bordureTri.setTitleColor(new Color(255,134,28));
		pan2.setBackground(Color.WHITE);
		pan2.setLayout(new GridLayout(2,1));
	
		

		//panel texte descriptif  modules-icone.png
		JPanel panIcone = new JPanel();
		
		panIcone.setLayout(new FlowLayout(FlowLayout.LEFT));  //layout texte descriptif n2
		panIcone.setBackground(Color.WHITE);
		
		JLabel TxtOptionTri = new JLabel("<html>Ci dessous les options disponibles pour le tri de vos photos.<br> De maniere automatique vos photos seront triees par annes et par mois, par exemple une photo prise au 1er janvier 2015<br> sera plac� dans le dossier: ' .../2015/1'. Si vous souhaitez simplement ce mode de tri, cliquer sur trier mes photos.<br>Passer votre souris sur les autre options de tri pour plus d'information </html>");
		JLabel TxtOptionTri2 = new JLabel("<html><i>Si vous selectionnez plusieurs options, l'application essaiera en priorit� de trier vos photos par evenement, puis par lieu, <br>si ces informations ne sont disponible, vos photos seront triees par date </i></html>");
		
		TxtOptionTri.setFont(new java.awt.Font("Dialog", 0, 12)); //eneleve l'effet gras
		TxtOptionTri2.setFont(new java.awt.Font("Dialog", 0, 12));
		
		TxtOptionTri2.setForeground(Color.WHITE);
		
		Icon iconeModule = new ImageIcon((getClass().getResource("Resource\\modules-icone.png")));
		TxtOptionTri.setIcon(iconeModule);
		
		pan2.add(panIcone);
		panIcone.add(TxtOptionTri);

		//panel choix multiple
		JPanel pan2Color = new JPanel();
		pan2Color.setBackground(new Color(255,134,28));
		pan2.add(pan2Color);
		
		JPanel panChoixTri = new JPanel();
		panChoixTri.setLayout(new FlowLayout()); //layout choix multiple
		panChoixTri.setBackground(new Color(255,134,28));
		pan2Color.add(panChoixTri);
		pan2Color.setLayout(new GridLayout(2,1));
		
		JRadioButton Jour = new JRadioButton("Jour");
		JRadioButton Evenement = new JRadioButton("Evenement");
		JRadioButton Lieu = new JRadioButton("Lieu");
		
		Jour.setBackground(new Color(255,134,28));
		Evenement.setBackground(new Color(255,134,28));
		Lieu.setBackground(new Color(255,134,28));
		
		Jour.setForeground(Color.WHITE);
		Evenement.setForeground(Color.WHITE);
		Lieu.setForeground(Color.WHITE);

		panChoixTri.add(Jour); 
		panChoixTri.add(Evenement);
		panChoixTri.add(Lieu);
		

		pan2Color.add(TxtOptionTri2);
	
		Jour.setToolTipText("Vos photos seront triees par jour, ainsi une photo prise au 1er janvier 2015 sera plac� dans le dossier: ' .../2015/1/1'");
		Evenement.setToolTipText("<html>Vos photos seront triees par evenement, ainsi une photo prise au 1er janvier 2015 et correspondant � un evenement de votre calendrier a cette date sera placee dans le dossier: ' .../2015/1/'nom de mon evenement' <br> Noter qu'une autorisation de connexion de l'application a Google sera necessaire. Pour plus d'information, voir la partie connexion a Google.</html> ");
		Lieu.setToolTipText("Vos photos seront triees par Lieu (si ce dernier est disponible), ainsi une photo prise au 1er janvier 2015 a Pessac sera plac� dans le dossier: ' .../2015/1/Pessac'");
		
//panel 3 : Renommage		
		JPanel pan3 = new JPanel();
		TitledBorder bordureRenommage = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(76,153,0),2),"<html><H3>Renommage</H3></html>"));
		pan3.setBorder(bordureRenommage);
		bordureRenommage.setTitleColor(new Color(76,153,0));
		pan3.setBackground(Color.WHITE);
		pan3.setLayout(new GridLayout(2,1));
	
		
		JPanel panTxtRenommageColor = new JPanel();
		panTxtRenommageColor.setLayout(new BoxLayout(panTxtRenommageColor, BoxLayout.Y_AXIS));
		panTxtRenommageColor.setBackground(new Color(76,153,0));
		
		
		JLabel TxtRenommage = new JLabel("<html>Vous avez la possibilit� de renommer selon differentes options les photos d'un dossier de votre choix. </html>");
		JLabel TxtRenommage2 = new JLabel("<html>Ce renommage ne sera pas automatique. <br> A chaque fois que vous souhaitez renommer les photos d'un dossier, vous pouvez passer par les parametres.</html>");
		
		TxtRenommage.setFont(new java.awt.Font("Dialog", 0, 12)); 
		TxtRenommage2.setFont(new java.awt.Font("Dialog", 0, 12));
		TxtRenommage2.setForeground(Color.WHITE);
		
		
		Icon iconeEncre = new ImageIcon((getClass().getResource("Resource\\encre-icone.png")));
		TxtRenommage.setIcon(iconeEncre);
		
		pan3.add(TxtRenommage);
		pan3.add(panTxtRenommageColor);
		panTxtRenommageColor.add(TxtRenommage2);

//ajout des pannels 123 � onglet 1:
		onglet1.add(pan1);
		onglet1.add(pan2);
		onglet1.add(pan3);

		
		
/////////onglet 2 :  connexion googgle//////////////////////
	
		JPanel onglet2 = new JPanel();
		//onglet2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		onglet2.setLayout(new BoxLayout(onglet2, BoxLayout.Y_AXIS));
		onglet2.setBackground(Color.WHITE);
				
				//panel 4.1 : authentification:
				JPanel panAuthentification = new JPanel();
				panAuthentification.setLayout(new BoxLayout(panAuthentification, BoxLayout.Y_AXIS));
				panAuthentification.setBackground(Color.WHITE);

				
				
				TitledBorder bordureAuthentif = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,134,28),2),"<html><H3>Authentification Google</H3></html>"));
				panAuthentification.setBorder(bordureAuthentif);
				bordureAuthentif.setTitleColor(new Color(255,134,28));
				
				onglet2.add(panAuthentification);
				
				JPanel panAuthentificationColore = new JPanel();
				panAuthentificationColore.setLayout(new BoxLayout(panAuthentificationColore, BoxLayout.Y_AXIS));
				panAuthentificationColore.setBackground(new Color(255,134,28));
				
			
				//	onglet2.add(Box.createRigidArea(new Dimension(0,150))); //un espace
				
				//panel 4.2 : Reinitilisation :
				JPanel panReinitial = new JPanel();
				panReinitial.setLayout(new BoxLayout(panReinitial, BoxLayout.Y_AXIS));
				panReinitial.setBackground(Color.WHITE);
				
				TitledBorder bordureReinitial = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(153,51,255),2),"<html><H3>Reinitialisation</H3></html>"));
				panReinitial.setBorder(bordureReinitial);
				bordureReinitial.setTitleColor(new Color(153,51,255));
				

				onglet2.add(panReinitial);
				
				JPanel panReinitialColore = new JPanel();
				panReinitialColore.setLayout(new BoxLayout(panReinitialColore, BoxLayout.Y_AXIS));
				panReinitialColore.setBackground(new Color(153,51,255));
				
				
				
				
				JLabel TxtGoogle = new JLabel("<html><br>Vous avez la possibilit� de trier vos photos en fonction de vos calenderiers d'evenements. <br> Pour se faire, une connexion a Google est necessaire afin d'acceder � vos calendriers.<br> Pour plus de s�curit� un code d'authentification vous sera envoyer afin d'autoriser la connexion.</html>");
				JLabel TxtGoogle2 = new JLabel("<html><br><br>Veuillez cliquez pour obtenir ce code :</html>");
			//	JLabel TxtGoogle3 = new JLabel("<html><br>Veuillez entrer ce code ci dessous:<html>");
				JLabel TxtGoogle4 = new JLabel("<html><i>Ce code ne devrait vous etre demander q'une seule fois. <br>Si toutrefois vous devriez avoir � le fournir a nouveau, il vous sera possible de le faire a partir des parametres.</i><html>");
				JLabel TxtGoogle5 = new JLabel("<html><br>Vous pouvez reinitialiser votre connexion</html>");
				JLabel TxtGoogle6 = new JLabel("<html><br>Cliquer pour reinitialiser votre connexion</html>");
			//	JTextField authentification = new JTextField(60);
				JButton boutonAuthentif = new JButton("Obtenir mon code d'authentification");
				JButton boutonReinitial = new JButton("R�initialiser votre connexion Google");
				
				Icon iconeCle = new ImageIcon((getClass().getResource("Resource\\icone-cle.png")));
				TxtGoogle.setIcon(iconeCle);
				Icon iconeRefresh = new ImageIcon((getClass().getResource("Resource\\rafraichir-icone.png")));
				TxtGoogle5.setIcon(iconeRefresh);
				
				TxtGoogle4.setFont(new java.awt.Font("Dialog", 0, 12)); //eneleve l'effet gras
				TxtGoogle2.setForeground(Color.WHITE);
				TxtGoogle4.setForeground(Color.WHITE);
				TxtGoogle6.setForeground(Color.WHITE);
				
				panAuthentification.add(TxtGoogle);
				panAuthentification.add(panAuthentificationColore);
				panAuthentificationColore.add(TxtGoogle2);
				panAuthentificationColore.add(boutonAuthentif);
			//	panAuthentification.add(TxtGoogle3);
			//	panAuthentification.add(authentification);
				panAuthentificationColore.add(TxtGoogle4);
				panReinitial.add(TxtGoogle5);
				
				panReinitial.add(panReinitialColore);
				panReinitialColore.add(TxtGoogle6);
				panReinitialColore.add(boutonReinitial);
				
			//	onglet2.add(Box.createRigidArea(new Dimension(0,50))); //un espace

				

////////onglet 3 : frequence de tri  ////////////////
		
		JPanel onglet3 = new JPanel();
		onglet3.setLayout(new BoxLayout(onglet3, BoxLayout.Y_AXIS));	
		onglet3.setBackground(Color.WHITE);
		
		JPanel panFrequence = new JPanel();
		panFrequence.setLayout(new GridLayout( 0,1 ));	
		//panFrequence.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"<html><H3>Frequence</H3></html>"));
		TitledBorder bordureFrequence = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(29,158,233),2),"<html><H3>Frequence</H3></html>"));
		panFrequence.setBorder(bordureFrequence);
		bordureFrequence.setTitleColor(new Color(29,158,233));
		panFrequence.setBackground(Color.WHITE);
		onglet3.add(panFrequence);
		
		JPanel panFrequenceColor = new JPanel();
		panFrequenceColor.setLayout( new GridLayout( 0,1 ));
		panFrequenceColor.setBackground(new Color(29,158,233));
		
		
		JLabel txtFrequence = new JLabel("<html><br>Choisissez ici la frequence � laquelle l'application verifie si votre dossier source contient des photos: </html>");
		JLabel txtFrequence2 = new JLabel("<html><br>Verifier mon dossier: </html>");
		String labels[] = {"Toutes les 30 minutes ", "Toutes les heures", "1 fois par semaine", "1 fois par mois", "1 fois par an"};
		JComboBox chxFrequence = new JComboBox(labels);
		
		chxFrequence.setPreferredSize(new Dimension(300,30));
		txtFrequence2.setAlignmentX( Component.LEFT_ALIGNMENT );
		txtFrequence2.setForeground(Color.WHITE);
	//	chxFrequence.setBackground(Color.gray);
	//	chxFrequence.setForeground(Color.WHITE);
		
		Icon iconeFrequence2 = new ImageIcon((getClass().getResource("Resource\\bleu-horloge-icone.png")));
		txtFrequence.setIcon(iconeFrequence2);
		
		panFrequence.add(txtFrequence);
		panFrequence.add(panFrequenceColor);
		panFrequenceColor.add(txtFrequence2);
		panFrequenceColor.add(chxFrequence);
		
		onglet3.add(Box.createRigidArea(new Dimension(0,500))); //un espace
	



////////menu a onglet : ///////////////////
        JTabbedPane Onglets = new JTabbedPane(1); //2 pas mal ?
        Onglets.setBackground(Color.gray);
        UIManager.put("TabbedPane.selected",Color.white); // si on veut changer la couleur des onglets selectionn�s
        SwingUtilities.updateComponentTreeUI(Onglets); 
        UIManager.put("TabbedPane.contentAreaColor",Color.white); 
        
      

       Icon iconeParametre = new ImageIcon((getClass().getResource("Resource\\parametres-icone.png")));
       Icon iconeGoogle = new ImageIcon((getClass().getResource("Resource\\google-icone.png")));
       Icon iconeFrequence = new ImageIcon((getClass().getResource("Resource\\horloge-icone.png")));
        

        

        Onglets.addTab("<html><H4>Parametre de tri</H4></html>",iconeParametre,onglet1, "Parametres generaux du tri de vos photos"); //
        Onglets.addTab("<html><H4>Connexion Google</H4></html>",iconeGoogle,onglet2,"Connexion � vos calendriers");
        Onglets.addTab("<html><H4>Frequence de v�rification</H4></html>",iconeFrequence,onglet3,"Choisissez � quelle frequence l'application trie les photos de votre dossier source ");
       
        fenetre.add(Onglets);
        Onglets.setPreferredSize(new Dimension(0,580));


        
        this.setVisible(true); 
  
        UiPremierDemarrageActionListener UiPremierDemarrageListener = new UiPremierDemarrageActionListener(SourceField, DestField, Jour, Evenement, Lieu,boutonAuthentif);
    
		//______ les commandes________
        browseSource.setActionCommand("choixSource");
        browseSource.addActionListener(UiPremierDemarrageListener);
        browseDest.setActionCommand("choixCible");
        browseDest.addActionListener(UiPremierDemarrageListener);
		

		Jour.setActionCommand("triDate");
		Jour.addActionListener(UiPremierDemarrageListener);
		Evenement.setActionCommand("triEvenement");
		Evenement.addActionListener(UiPremierDemarrageListener);
		Lieu.setActionCommand("triLieu");
		Lieu.addActionListener(UiPremierDemarrageListener);
		
		boutonAuthentif.setActionCommand("authentification");
		boutonAuthentif.addActionListener(UiPremierDemarrageListener);
		
		setLocationRelativeTo(this.getParent()); 
		
}


	
	
	}