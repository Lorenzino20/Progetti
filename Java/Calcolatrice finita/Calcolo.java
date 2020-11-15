import java.awt.event.*;
public class Calcolo extends GUI implements ActionListener {
    private static final long serialVersionUID = 1L;
    String tx = "";
    String app = "";
    String testo = "";
    int n = 0;
    int f = 0;
    float x = 0;
    float risultato = 0;
    int operazione = 0;
    boolean r = true;
    
    public void actionPerformed(ActionEvent e) {
        String bottone = e.getActionCommand();
        if(bottone.equals("1")) {
            tx = tx + "1";
            textDown.setText(tx);
        }
        if(bottone.equals("2")) {
            tx = tx + "2";
            textDown.setText(tx);
        }
        if(bottone.equals("3")) {
            tx = tx + "3";
            textDown.setText(tx);
        }
        if(bottone.equals("4")) {
            tx = tx + "4";
            textDown.setText(tx);
        }
        if(bottone.equals("5")) {
            tx = tx + "5";
            textDown.setText(tx);
        }
        if(bottone.equals("6")) {
            tx = tx + "6";
            textDown.setText(tx);
        }
        if(bottone.equals("7")) {
            tx = tx + "7";
            textDown.setText(tx);
        }
        if(bottone.equals("8")) {
            tx = tx + "8";
            textDown.setText(tx);
        }
        if(bottone.equals("9")) {
            tx = tx + "9";
            textDown.setText(tx);
        }
        if(bottone.equals("0")) {
            tx = tx + "0";
            textDown.setText(tx);
        }
        if(bottone.equals(".")) {
            tx = tx + ".";
            textDown.setText(tx);
        }
        if(bottone.equals("+")) {
            r = false;
            f = 1;
            try {
            x = Float.valueOf(tx);
            } catch (ArithmeticException ex) {
                textDown.setText("Errore di calcolo");
            }
            if(n == 0) 
            n = 1;
            operazione(n, x);
            stampa(f);
            n = 1;
        }
        if(bottone.equals("-")) { 
            if(r == true && tx == "") {
                tx = "-";
                r = false;
            } else {
                if(tx == "") {
                tx = "-" + tx;
                } else {
                r = false;
                f = 2;
                x = Float.valueOf(tx);
                if(n == 0) 
                n = 2;
                System.out.println(x);
                operazione(n, x);
                stampa(f);
                n = 2;
                }
            }
        }
        if(bottone.equals("*")) {
            r = false;
            f = 3;
            try {
            x = Float.valueOf(tx);
            } catch (ArithmeticException ex) {
                textDown.setText("Errore di calcolo");
            }
            if(n == 0) 
            n = 3;
            operazione(n, x);
            stampa(f);
            n = 3;
        }
        if(bottone.equals("/")) {
            r = false;
            f = 4;
            try {
            x = Float.valueOf(tx);
            } catch (ArithmeticException ex) {
                textDown.setText("Errore di calcolo");
            }
            if(n == 0) 
            n = 4;
            operazione(n, x);
            stampa(f);
            n = 4;
        }
        if(bottone.equals("Canc")) {
            reset();
        }
        if(bottone.equals("=")) {
            float x = Float.valueOf(tx);
            operazione(n, x);
            stampa();
            f = 5;
        }
    }
    public void operazione(int n, float x) {
        switch(n) {
            case 1:
                try {
                risultato = risultato + x;
                } catch (ArithmeticException ex) {
                    textDown.setText("Errore di calcolo");
                }
                n = 1;
                break;
            case 2:
                if(x < 0 && r == true) { 
                    risultato = - risultato;
                } else {
                    if(risultato == 0) {
                    risultato = x - risultato;
                    } else {
                        try {
                            risultato = risultato - x;
                        } catch (ArithmeticException ex) {
                            textDown.setText("Errore di calcolo");
                        }
                    }
                }
                n = 2;
                break;
            case 3: 
                if(risultato == 0) {
                    risultato = 1;
                    risultato = x / risultato;
                } else {
                try {
                risultato = risultato * x;
                } catch (ArithmeticException ex) {
                    textDown.setText("Errore di calcolo");
                }
                n = 3;
                }
                break;
            case 4:
                if(risultato == 0) {
                    risultato = 1;
                    risultato = x / risultato;
                }
                else {
                try {
                risultato = risultato / x;
                } catch (ArithmeticException ex) {
                    textDown.setText("Errore di calcolo");
                }
                n = 4;
                }
                break;

        }   
    }
    public void stampa(int n) {
        if(n == 1) {
            app = String.valueOf(risultato).toString();
            testo = testo + tx + "+";
            textUp.setText(testo);
            textDown.setText(app);
            tx = "";
        }
        if(n == 2) {
            app = String.valueOf(risultato).toString();
            testo = testo + tx + "-";
            textUp.setText(testo);
            textDown.setText(app);
            tx = "";
        }
        if(n == 3) {
            app = String.valueOf(risultato).toString();
            testo = testo + tx + "*";
            textUp.setText(testo);
            textDown.setText(app);
            tx = "";
        }
        if(n == 4) {
            app = String.valueOf(risultato).toString();
            testo = testo + tx + "/";
            textUp.setText(testo);
            textDown.setText(app);
            tx = "";
        }
    }
    public void stampa() {
        app = String.valueOf(risultato).toString();
        testo = testo + tx ;
        textUp.setText(testo);
        textDown.setText(app);
        tx = app;
        testo = "";
        risultato = 0;
    }
    public void reset() {
        app = "";
        tx = "";
        testo = "";
        textUp.setText(testo);
        textDown.setText(app);
        risultato = 0;
        r = true;
    }
    public void stampaSegno() {
        app = String.valueOf(risultato).toString();
        textDown.setText(app + "-");
        tx = "";
    }
}