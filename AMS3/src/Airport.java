import javax.swing.*;

public class Airport {
    public static void main (String [] args) {

        JFrame frame= new JFrame("Sabiha Gökçen Airport");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);

        JTabbedPane airport = new JTabbedPane();
        frame.add(new View(airport));


        frame.add(airport);

        frame.setVisible(true);

        AirportPassenger ali = new AirportPassenger("ali","veli",5,1985);
        System.out.println(ali);


    }
}
