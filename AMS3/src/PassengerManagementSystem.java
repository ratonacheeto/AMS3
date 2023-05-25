import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class PassengerManagementSystem extends JPanel implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;
    private JButton removePassenger;
    private JTextField PassengerName;

    private JTextField PassengerSurname;
    private JTextField PassengerBirthYear;
    private JTextField LuggageCount;

    private Choice PassengerType;

    private AirportPassenger passenger;


    public PassengerManagementSystem( JTextField PassengerName, JTextField PassengerSurname, JTextField PassengerBirthYear, JTextField LuggageCount, JButton removePassenger, JButton addPassenger) {
        super(new BorderLayout());
        this.removePassenger = removePassenger;
        this.PassengerName = PassengerName;
        this.PassengerSurname = PassengerSurname;
        this.PassengerBirthYear = PassengerBirthYear;
        this.LuggageCount = LuggageCount;
        listModel = new DefaultListModel();

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(7);
        JScrollPane listScrollPane = new JScrollPane(list);

        AddPassengerListener addPassengerListener = new AddPassengerListener(addPassenger);
        addPassenger.setText("Add Passenger");
        addPassenger.addActionListener(addPassengerListener);
        addPassenger.setEnabled(false);

        removePassenger.setText("Remove Passenger");
        removePassenger.addActionListener(new RemovePassengerListener());

        PassengerName.addActionListener(addPassengerListener);
        PassengerName.getDocument().addDocumentListener(addPassengerListener);

        add(listScrollPane, BorderLayout.CENTER);

    }

    class RemovePassengerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = list.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                removePassenger.setEnabled(false);

            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }

    //This listener is shared by the text field and the hire button.
    class AddPassengerListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public AddPassengerListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            //AirportPassenger passenger1 = new AirportPassenger(PassengerName.getText(), PassengerSurname.getText(), LuggageCount.getText(), PassengerBirthYear.getComponentCount());

            String name = PassengerName.getText();
            String surname = PassengerSurname.getText();

            int birthYear = parseInt(PassengerBirthYear.getText());

            if (name.equals("") || surname.equals("") )  {
                PassengerName.requestFocusInWindow();
                PassengerName.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            }


            listModel.addElement(name + " " + surname + " " + birthYear);

            //Reset the text field.
            PassengerName.requestFocusInWindow();
            PassengerName.setText("");

            PassengerSurname.requestFocusInWindow();
            PassengerSurname.setText("");

            LuggageCount.requestFocusInWindow();
            LuggageCount.setText("");

            PassengerBirthYear.requestFocusInWindow();
            PassengerBirthYear.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
//            protected boolean alreadyInList(String name) {
//                return listModel.contains(name);
//            }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                removePassenger.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                removePassenger.setEnabled(true);
            }
        }
    }

}
