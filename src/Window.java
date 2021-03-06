import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener{
    protected Drawing dessin = new Drawing();

    public Window(String Title,int x,int y){
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /* Set image icon*/
        ImageIcon img = new ImageIcon("icon.png");
        this.setIconImage(img.getImage());

        Container contentPanel = this.getContentPane() ;
        /* Panel barre des menu*/
        JPanel northPanel = new JPanel(); //Création du panel
        northPanel.setLayout(new GridLayout()); //On delimite le layout du panel

        JMenuBar m= new JMenuBar(); // On créer la barre de menu
        JMenu menu1= new JMenu("File"); // onglet file
        JMenu menu2 = new JMenu("About"); // onglet about
        JMenuItem open = new JMenuItem("Open") ;
        JMenuItem save = new JMenuItem("Save");
        JMenuItem nouveau  = new JMenuItem("New");
        JMenuItem auteur = new JMenuItem("Authors");
        menu1.add(nouveau);
        menu1.add(open);
        menu1.add(save);
        menu2.add(auteur);
        m.add(menu1);
        m.add(menu2);
        northPanel.add(m);
        contentPanel.add(northPanel,"North"); // On place le panel dans panel Global

        /* Panel sud de choix des figures et des couleurs */
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(0,2));

        /* Panel sud-est : les figures */
        JPanel southEast = new JPanel();
        southEast.setLayout(new GridLayout(0,2));

        /* On créer les boutons des figures */
        JButton carre = new JButton("Carre");
        JButton rectangle = new JButton("Rectangle");
        JButton ellipse = new JButton("Ellipse");
        JButton cercle = new JButton("Cercle");

        /* on ajoute les boutons dans le panel */
        southEast.add(rectangle);
        southEast.add(ellipse);
        southEast.add(cercle);
        southEast.add(carre);

        /*  Panel sud-ouest : les couleurs */
        JPanel southWest = new JPanel();
        southWest.setLayout(new GridLayout(0,4));

        /* création des boutons */
        JButton rouge = new JButton("Rouge");
        JButton bleu = new JButton("Bleu");
        JButton jaune = new JButton("Jaune");
        JButton vert = new JButton("Vert");
        JButton noir = new JButton("Noir");
        JButton rose = new JButton("Rose");
        JButton magenta = new JButton("Magenta");
        JButton blanc = new JButton("Blanc");

        /* On modifie la couleur des bouttons*/
        rouge.setBackground(Color.RED);
        bleu.setBackground(Color.BLUE);
        jaune.setBackground(Color.YELLOW);
        vert.setBackground(Color.GREEN);
        noir.setBackground(Color.BLACK);
        rose.setBackground(Color.PINK);
        magenta.setBackground(Color.MAGENTA);
        blanc.setBackground(Color.WHITE);

        /* Interractino des boutons */

        rouge.addActionListener( this);
        bleu.addActionListener( this);
        jaune.addActionListener( this);
        noir.addActionListener( this);
        blanc.addActionListener( this);
        magenta.addActionListener( this);
        vert.addActionListener( this);
        rose.addActionListener( this);

        carre.addActionListener( this);
        rectangle.addActionListener( this);
        cercle.addActionListener( this);
        ellipse.addActionListener( this);

        auteur.addActionListener( this);
        save.addActionListener(this);
        open.addActionListener(this);
        nouveau.addActionListener(this);


        /* ajout des boutons*/
        southWest.add(rouge);
        southWest.add(bleu);
        southWest.add(jaune);
        southWest.add(vert);
        southWest.add(noir);
        southWest.add(rose);
        southWest.add(magenta);
        southWest.add(blanc);

        southPanel.add(southWest);
        southPanel.add(southEast);
        contentPanel.add(southPanel,"South");
        this.setVisible(true);
        JPanel centrePanel = dessin;
        contentPanel.add(centrePanel,"Center");

        this.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd =e.getActionCommand();
            switch(cmd)
            {
                case "Rouge":
                    dessin.setC(Color.RED);
                    break;
                case "Bleu":
                    dessin.setC(Color.BLUE);
                    break;
                case "Rose":
                    dessin.setC(Color.PINK);
                    break;
                case "Vert":
                    dessin.setC(Color.GREEN);
                    break;
                case "Magenta":
                    dessin.setC(Color.MAGENTA);
                    break;
                case "Noir":
                    dessin.setC(Color.BLACK);
                    break;
                case "Blanc":
                    dessin.setC(Color.WHITE);
                    break;
                case "Jaune":
                    dessin.setC(Color.YELLOW);
                    break;
                case "Rectangle":
                    dessin.setFig("Rectangle");
                    break;
                case "Carre":
                    dessin.setFig("Carre");
                    break;
                case "Cercle":
                    dessin.setFig("Cercle");
                    break;
                case "Ellipse":
                    dessin.setFig("Ellipse");
                    break;
                case "Authors":
                    JOptionPane info = new JOptionPane();
                    info.showInternalMessageDialog(info,"Authors : Maël","information",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Save":
                    //JOptionPane nomFichier = new JOptionPane();
                    //String s=nomFichier.showInternalInputDialog(nomFichier,"Type the file name");
                    dessin.save();
                    this.setTitle(dessin.getDrawingName()+" - Paint");
                    break;
                case "Open":
                    dessin.open();
                    this.setTitle(dessin.getDrawingName()+" - Paint");
                    break;
                case "New":
                    dessin.nouveau();
                    this.setTitle("No name - Paint");
                    break;
            }
        }

    public static void main (String[] args){
        Window win = new Window("No name - Paint",800,600);
    }
}
