import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class DisplayPanel extends JPanel implements MyObserver
{   
    private Concert concert;
    private JLabel incomeL = new JLabel("Income$");
    private JTextField incomeT = new JTextField(10);
    private JLabel costL = new JLabel("Cost$");
    private JTextField costT = new JTextField(10);
    private JLabel profitL = new JLabel("Profit$");
    private JTextField profitT = new JTextField(10);
    //add GUI components
    public DisplayPanel(Concert concert)
    {
        this.concert = concert;
        setup();
        build();
        update();
        //call setup and build
        //to add components to the panel
    }
    public void update()
    {
        incomeT.setText(concert.income());
        costT.setText(concert.cost());
        profitT.setText(concert.profit());
    }
    public void setup()
    {
        concert.attach(this); //attach Observer to Concert
        concert.band().attach(this); //attach Observer to Band
        concert.stadium().attach(this); //attach Observer to Stadium
        
        Iterator<Seat> it = concert.stadium().seats().iterator();
        while (it.hasNext())
            it.next().attach(this); //attach Observer to each Seat
    }
    public void build()
    {
        add(incomeL);
        add(incomeT);
        add(costL);
        add(costT);
        add(profitL);
        add(profitT);
    }
    
    

}

