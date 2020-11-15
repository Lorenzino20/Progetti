package test;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.*;

public class Gui extends JPanel{
    
    private static final long serialVersionUID = 1L;

    private Image sfondo;
    private Image piccione_maledetto;
    private Image game_over;

    public boolean in_game; 
    public boolean in_caduta;

    public int casuale;

    public Pennuto p;
    public Ostacolo o;

    public Timer timer;

    public Gui() {
        
        setinGame(false);
        setinCaduta(false);

        p = new Pennuto();
        o = new Ostacolo();

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

        g2.drawImage(piccione_maledetto, p.getX(), p.getY(), 30, 30, this);
        
        if(getinGame() == false)
        g2.drawImage(game_over, 0, 0, 183, 275, this); 

        /* for(int i = 0; i < 100; i++) {
            g2.drawRect(o.getX0(), o.getY0(), o.getDimenzione(), o.getCasuale());
            o.setY1(o.getCasuale()+90);
            g2.drawRect(o.getX1(), o.getY1(), o.getDimenzione(), 234-o.getY1());
        } */
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
                /* o.setX0(o.getX0()-5);
                o.setX1(o.getX1()-5); */
                /* System.out.println(p.getY()); */ 
                repaint();
            } 
        }, 50, 50);
    }   
    
    public void spinta() {
        p.setY(p.getY()-30);
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
