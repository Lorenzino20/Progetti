package Gioco;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.*;

public class Gui extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Image sfondo;
    private Image piccione_maledetto;
    private Image game_over;

    public boolean in_game; 
    public boolean in_caduta;

    public Pennuto p;

    public Timer timer;

    public Gui() {
        setinGame(false);
        setinCaduta(false);

        p = new Pennuto();

        sfondo = Toolkit.getDefaultToolkit().getImage("img/sfondo.jpg");
        piccione_maledetto = Toolkit.getDefaultToolkit().getImage("img/piccione_maledetto.png");
        game_over = Toolkit.getDefaultToolkit().getImage("img/game_over.png");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 2) {
                    System.out.println("Caduta");
                    setinGame(true);
                }
                else if(e.getButton() == 1) {
                    spinta();
                }
                else 
                reset();
            }
        }); 
    }

    public void paint(Graphics g) {
        super.paint(g);  //richiamo del metodo
        Graphics2D g2 = (Graphics2D) g; //casting 
        
        g2.drawImage(sfondo, 0, 0, 183, 275, this);

        g2.drawImage(piccione_maledetto, p.getX(), p.getY(), 40, 40, this);

        if(getinGame() == false)
        g2.drawImage(game_over, 0, 0, 183, 275, this);
    }

    public boolean getinGame() {
        return in_game;
    }

    public void setinGame(boolean game) {
        this.in_game = game;
        if(getinGame() == true)
        game();
    }

    public boolean getinCaduta() {
        return in_caduta;
    }

    public void setinCaduta(boolean caduta) {
        this.in_caduta = caduta;
        if(getinCaduta() == true)
        incaduta();
        else
        setinGame(false);
    }

    public void game() {
        setinCaduta(true);
    }

    public void incaduta() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(p.getY() >= 195)
                setinCaduta(false);
                /* System.out.println("Cadu");  */
                p.setY(p.getY()+5);
                /* System.out.println(p.getY()); */ 
                repaint();
            } 
        }, 50, 50);
    }   
    
    public void spinta() {
        p.setY(p.getY()-40);
        repaint();
    }

    public void reset() {
        setinGame(false);
        setinCaduta(false);
        p.setY(30);
        repaint();
        timer.cancel();
        timer.purge();
    }
}
