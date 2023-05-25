import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class View  extends JPanel {
    JPanel flight;
    JPanel passenger;
    JPanel plane;
    JTabbedPane airport;
    
    private JList currentFlightsList;
    private JList manageTicketsList;
    private DefaultListModel listModel;
    private DefaultListModel listModel2;


    public View(JTabbedPane airport) {

        //JTabbedPane airport = new JTabbedPane();
        JPanel flight = new JPanel();
        JPanel passenger = new JPanel();
        JPanel plane = new JPanel();

        this.passenger = passenger;
        this.plane = plane;
        this.flight = flight;

        this.airport = airport;




        airport.addTab("Passenger Management System", passenger);
        airport.addTab("Plane Management System", plane);
        airport.addTab("Flight Management System",flight);

        TitledBorder title;
        title = BorderFactory.createTitledBorder("Passenger Management");


        passenger.setBorder(title);
        passenger.setLayout(new GridLayout(3,1));
        JPanel allPassengers = new JPanel();
        JPanel newUserCreatingArea = new JPanel();
        JPanel userFunctionalityButtons = new JPanel();

        passenger.add(allPassengers);
        passenger.add(newUserCreatingArea);
        passenger.add(userFunctionalityButtons);

        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("All Passengers");
        allPassengers.setBorder(title2);

        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Create a new user");
        newUserCreatingArea.setBorder(title3);

        JButton addUser = new JButton("Add User");
        JButton removeUser = new JButton("Remove User");
        JButton updateUser = new JButton("Update User");

        newUserCreatingArea.setLayout(new GridLayout(2,5));
        userFunctionalityButtons.setLayout(new GridLayout(3,1));

        userFunctionalityButtons.add(addUser);
        userFunctionalityButtons.add(removeUser);
        userFunctionalityButtons.add(updateUser);

        Choice passengerType = new Choice();
        passengerType.add("Family");
        passengerType.add("Business");
        passengerType.add("Economy");

        newUserCreatingArea.add(new JLabel("Name"));
        newUserCreatingArea.add(new JLabel("Surname"));
        newUserCreatingArea.add(new JLabel("Passenger Type"));
        newUserCreatingArea.add(new JLabel("Luggage Count"));
        newUserCreatingArea.add(new JLabel("Year of Birth"));

        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        JTextField luggageCount = new JTextField();
        JTextField birthYear = new JTextField();

        newUserCreatingArea.add(name);
        newUserCreatingArea.add(surname);
        newUserCreatingArea.add(passengerType);
        newUserCreatingArea.add(luggageCount);
        newUserCreatingArea.add(birthYear);

        JComponent newContentPane = new PassengerManagementSystem(name, surname, birthYear, luggageCount, removeUser, addUser);
        newContentPane.setOpaque(true); //content panes must be opaque
        allPassengers.add(newContentPane);


        plane.setLayout(new GridLayout(3,1));
        JPanel planes = new JPanel();
        JPanel newPlaneCreatingArea = new JPanel();
        JPanel airportElements = new JPanel();

        plane.add(planes);
        plane.add(newPlaneCreatingArea);
        plane.add(airportElements);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        newPlaneCreatingArea.setLayout(new GridLayout(2,1));
        newPlaneCreatingArea.add(panel1);
        newPlaneCreatingArea.add(panel2);

        panel1.setLayout(new FlowLayout());
        JTextField enterPlane = new JTextField("Enter Plane");
        JButton addPlane = new JButton("Add Plane");
        JLabel capacityLabel = new JLabel("Capacity:");
        SpinnerModel model = new SpinnerNumberModel(0,0,290, 1);
        JSpinner spinner = new JSpinner(model);

        panel1.add(enterPlane);
        panel1.add(addPlane);
        panel1.add(capacityLabel);
        panel1.add(spinner);

        panel2.setLayout(new FlowLayout());
        JButton removePlane = new JButton("Remove Plane");
        panel2.add(removePlane);

        TitledBorder titleF1 = BorderFactory.createTitledBorder("Airport");
        airportElements.setBorder(titleF1);  // 4 3

        airportElements.setLayout(new GridLayout(4,3));
        JTextField HangarID = new JTextField("0");
        JButton addHunger = new JButton("Add Hangar");
        JButton removeHunger = new JButton("Remove Hangar");
        JTextField runwayID = new JTextField("0");
        JButton addRunway = new JButton("Add Runway");
        JButton removeRunway = new JButton("Remove Runway");
        JLabel reservedHangar = new JLabel();
        JButton reserveHangar = new JButton("Reserve Hangar");
        JButton resetHangar = new JButton("Reset Hangar");
        JLabel reservedRunway = new JLabel();
        JButton reserveRunway = new JButton("Reserve Runway");
        JButton resetRunway = new JButton("Reset Runway");

        airportElements.add(HangarID);
        airportElements.add(addHunger);
        airportElements.add(removeHunger);
        airportElements.add(runwayID);
        airportElements.add(addRunway);
        airportElements.add(removeRunway);
        airportElements.add(reservedHangar);
        airportElements.add(reserveHangar);
        airportElements.add(resetHangar);
        airportElements.add(reservedRunway);
        airportElements.add(reserveRunway);
        airportElements.add(resetRunway);


       flight.setLayout(new FlowLayout());
       JPanel generateFlight = new JPanel();
       JPanel currentFlights = new JPanel();
       JPanel manageTickets = new JPanel();

       flight.add(generateFlight);
       flight.add(currentFlights);
       flight.add(manageTickets);

       generateFlight.setLayout(new GridLayout(2,1));
       TitledBorder titleF2 = BorderFactory.createTitledBorder("Generate Flight");
       generateFlight.setBorder(titleF2);

       JPanel generateFlight1 = new JPanel();
       generateFlight1.setLayout(new GridLayout(2,4));
       JLabel departure = new JLabel("Departure");
       JLabel landing = new JLabel("Landing");
       JLabel departureDate = new JLabel("Departure Date");
       JLabel returnDate = new JLabel("Return Date");
       JTextField t1 = new JTextField();
       JTextField t2 = new JTextField();
       JTextField t3 = new JTextField();
       JTextField t4 = new JTextField();

       generateFlight1.add(departure);
       generateFlight1.add(landing);
       generateFlight1.add(departureDate);
       generateFlight1.add(returnDate);
       generateFlight1.add(t1);
       generateFlight1.add(t2);
       generateFlight1.add(t3);
       generateFlight1.add(t4);

       JPanel generateFlight2 = new JPanel();
       generateFlight2.setLayout(new GridLayout(1,2));
       JButton addFlight = new JButton("Add Flight");
       JButton removeFlight = new JButton("Remove Flight");
       generateFlight2.add(addFlight);
       generateFlight2.add(removeFlight);

       generateFlight.add(generateFlight1);
       generateFlight.add(generateFlight2);

       TitledBorder titleF3 = BorderFactory.createTitledBorder("Current Flights");
       currentFlights.setBorder(titleF3);

        listModel = new DefaultListModel();
        currentFlightsList = new JList(listModel);
        currentFlightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        currentFlightsList.setSelectedIndex(0);
        currentFlightsList.setVisibleRowCount(7);
        JScrollPane listScrollPane = new JScrollPane(currentFlightsList);
        currentFlights.add(listScrollPane);

        manageTickets.setLayout(new GridLayout(3,1));
        TitledBorder titleF4 = BorderFactory.createTitledBorder("Manage Tickets");
        manageTickets.setBorder(titleF4);

        JPanel manageTickets1 = new JPanel();
        JPanel manageTickets2 = new JPanel();
        JPanel manageTickets3 = new JPanel();

        listModel2 = new DefaultListModel();
        manageTicketsList = new JList(listModel2);
        manageTicketsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        manageTicketsList.setSelectedIndex(0);
        manageTicketsList.setVisibleRowCount(7);
        JScrollPane listScrollPane2 = new JScrollPane(manageTicketsList);
        manageTickets1.add(listScrollPane2);

       manageTickets2.setLayout(new BorderLayout());
       JLabel passengerID = new JLabel("Passenger ID");
       JLabel ticketPrice = new JLabel("Ticket Price");

       manageTickets2.add(passengerID,BorderLayout.WEST);
       manageTickets2.add(ticketPrice,BorderLayout.EAST);

       manageTickets3.setLayout(new GridLayout(1,3));
        JTextField passengerIDField = new JTextField();
        JButton buyTicket = new JButton("Buy Ticket");
        JButton cancelTicket = new JButton("Cancel Ticket");

        manageTickets3.add(passengerIDField);
        manageTickets3.add(buyTicket);
        manageTickets3.add(cancelTicket);

        manageTickets.add(manageTickets1);
        manageTickets.add(manageTickets2);
        manageTickets.add(manageTickets3);





    }
}