import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class ControlPanel extends JPanel
{   
    private Concert concert;
    private JButton bandWindow = new JButton("Set Band");
    private JButton priceWindow = new JButton("Set Price");
    private JButton saleWindow = new JButton("sell");
    private JButton exit = new JButton("Exit");
    //declare the GUI components
    public ControlPanel(Concert concert)
    {   
        this.concert = concert;
        setup();
        build();
    }
    
    private void setup()
    {
        bandWindow.addActionListener(new BandListener( concert.band()));
        priceWindow.addActionListener(new PriceListener( concert.stadium()));
        saleWindow.addActionListener(new SaleListener( concert.stadium()));
        exit.addActionListener(new ExitListener());
    }
    
    private void build()
    {
        add(bandWindow);
        add(priceWindow);
        add(saleWindow);
        add(exit);
    }


    //////inner class
   private class BandListener implements ActionListener
   {   
        private Band band;
    
        public BandListener(Band band)
        {   
           this.band = band;   
        }
        public void actionPerformed(ActionEvent e)
        {   
            new BandWindow(band);   
        }
    }
    //////inner class
   private class PriceListener implements ActionListener
   {   
        private Stadium stadium;
    
        public PriceListener(Stadium stadium)
        {   
           this.stadium = stadium;   
        }
        public void actionPerformed(ActionEvent e)
        {   
            new PriceWindow(stadium);   
        }
    }
    //////inner class
   private class SaleListener implements ActionListener
   {   
        private Stadium stadium;
    
        public SaleListener(Stadium stadium)
        {   
           this.stadium = stadium;   
        }
        public void actionPerformed(ActionEvent e)
        {   
            new SaleWindow(stadium);   
        }
    }
   ////inner class
   private class ExitListener implements ActionListener
   {
        public void actionPerformed(ActionEvent e)
        {   
            System.exit(0);
        }
    }
}

