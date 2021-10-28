import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String Title,int x,int y)
{
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane() ;
        /* Panel barre des menu*/
        JPanel northPanel = new JPanel(); //Création du panel
        northPanel.setLayout(new GridLayout()); //On delimite le layout du panel
        JMenuBar m= new JMenuBar(); // On créer la barre de menu
        JMenu menu1= new JMenu("File"); // onglet file
        JMenuItem open = new JMenuItem("Open") ;
        JMenuItem save = new JMenuItem("Save");
        JMenuItem nouveau  = new JMenuItem("New");
        menu1.add(nouveau);
        menu1.add(open);
        menu1.add(save);
        m.add(menu1);
        northPanel.add(m);
        contentPanel.add(northPanel,"North"); // On place le panel dans panel Global

        /* Panel de choix des couleurs */
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(0,6));
        JButton rouge = new JButton();
        JButton bleu = new JButton();
        JButton jaune = new JButton();
        JButton vert = new JButton();
        JButton noir = new JButton();
        JButton rose = new JButton();
        JButton magenta = new JButton();
        JButton blanc = new JButton();

        /* On modifie la couleur des bouttons*/
        rouge.setBackground(Color.RED);
        bleu.setBackground(Color.BLUE);
        jaune.setBackground(Color.YELLOW);
        vert.setBackground(Color.GREEN);
        noir.setBackground(Color.BLACK);
        rose.setBackground(Color.PINK);
        magenta.setBackground(Color.MAGENTA);
        blanc.setBackground(Color.WHITE);

        /* On ajoute les boutons des figures */
        JButton carre = new JButton("Carré");
        JButton rectangle = new JButton("Rectangle");
        JButton ellipse = new JButton("Ellipse");
        JButton cercle = new JButton("Cercle");

        southPanel.add(rouge);
        southPanel.add(bleu);
        southPanel.add(jaune);
        southPanel.add(vert);
        southPanel.add(rectangle);
        southPanel.add(ellipse);
        southPanel.add(noir);
        southPanel.add(rose);
        southPanel.add(magenta);
        southPanel.add(blanc);
        southPanel.add(cercle);
        southPanel.add(carre);

        contentPanel.add(southPanel,"South");

        JPanel centrePanel = new JPanel();
        centrePanel.setBackground(Color.WHITE);
        contentPanel.add(centrePanel,"Center");

        this.setVisible(true);
        }

        public static void main (String[] args){
        Window win = new Window("Paint",800,600);
        }

}
