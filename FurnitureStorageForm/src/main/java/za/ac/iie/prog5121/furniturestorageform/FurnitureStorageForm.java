/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package za.ac.iie.prog5121.furniturestorageform;

/**
 *
 * @author anphewa
 */

import javax.swing.*; // Imports GUI components such as JFrame, JLabel, JTextField and JButton
import java.awt.*;    // Imports layout classes such as GridLayout

// JFrame represents the main window of a Java GUI application.
// extends JFrame allows this class to create and manage a GUI window.
public class FurnitureStorageForm extends JFrame {


    // ========== DECLARE GUI COMPONENTS ==========

    // We declare these components BEFORE the constructor because
    // they must be accessible in both the constructor and other
    // methods, such as processCustomer().

    // private means these variables can only be accessed directly
    // from inside the FurnitureStorageForm class.

    // JTextField creates a text box where users can type information.
    // txt is a naming prefix that identifies a text field.
    // These variables will hold the customer name and price fields.
    private JTextField txtCustomerName;
    private JTextField txtPrice;

    // JComboBox creates a dropdown list with selectable options.
    // cmb is a naming prefix that identifies a combo box.
    // <String> means the dropdown stores text values.
    // We declare it here so processCustomer() can read the selection.
    private JComboBox<String> cmbDuration;



    // ========== CONSTRUCTOR ==========

    // A constructor has the same name as the class.
    // It does not have a return type, not even void.
    // It runs automatically when a FurnitureStorageForm object
    // is created using the new keyword.
    public FurnitureStorageForm() {


        // ========== WINDOW SETTINGS ==========

        // setTitle() displays a heading at the top of the window.
        setTitle("Furniture Storage");

        // setSize() sets the window dimensions in pixels.
        // The first number is the width, the second is the height.
        setSize(430, 270);

        // This closes the entire program when the X button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // null tells Java to centre the window on the screen.
        setLocationRelativeTo(null);



        // ========== CREATE THE PANEL ==========

        // JPanel is a container that holds GUI components.
        // It helps us arrange labels, text fields and buttons.

        // GridLayout arranges components into rows and columns.
        // 4 means four rows, while 2 means two columns.
        // 10 is the horizontal space between components.
        // 15 is the vertical space between components.
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));

        // setBorder() creates spacing inside the edges of our panel.
        // createEmptyBorder() adds invisible space around components.
        // The values represent TOP, LEFT, BOTTOM and RIGHT.
        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );



        // ========== CUSTOMER NAME COMPONENTS ==========

        // JLabel displays text on the window.
        // Unlike JTextField, the user cannot type into a JLabel.
        // We declare this label inside the constructor because
        // other methods do not need to access it.
        JLabel lblCustomerName = new JLabel("Customer Name:");

        // new creates the actual JTextField object.
        // The variable was declared before the constructor.
        // This field allows the user to type their name.
        txtCustomerName = new JTextField();



        // ========== STORAGE DURATION COMPONENTS ==========

        // Create a label to identify the storage duration field.
        JLabel lblDuration = new JLabel("Duration:");

        // A String array stores multiple text values.
        // Here we store the available storage periods in months.
        String[] durations = {"3", "6", "12"};

        // JComboBox displays the array values in a dropdown list.
        // The user can select 3, 6 or 12 months.
        // We pass the durations array into the JComboBox constructor.
        cmbDuration = new JComboBox<>(durations);



        // ========== STORAGE PRICE COMPONENTS ==========

        // Create a label to identify the price field.
        JLabel lblPrice = new JLabel("Price:");

        // Create the text field for entering the storage price.
        // We will convert this text into a number when processing.
        txtPrice = new JTextField();



        // ========== CREATE BUTTONS ==========

        // JButton creates a clickable button.
        // btn is a naming prefix used for buttons.

        // These buttons are declared inside the constructor because
        // we only need to create and configure them here.
        // They do not need to be accessible from other methods.
        JButton btnProcess = new JButton("PROCESS");
        JButton btnSave = new JButton("SAVE");



        // ========== ADD COMPONENTS TO THE PANEL ==========

        // add() places a component inside our JPanel.
        // GridLayout automatically arranges the components
        // according to the order in which we add them.

        // ROW 1: Customer name label and input field.
        panel.add(lblCustomerName);
        panel.add(txtCustomerName);

        // ROW 2: Storage duration label and dropdown list.
        panel.add(lblDuration);
        panel.add(cmbDuration);

        // ROW 3: Storage price label and input field.
        panel.add(lblPrice);
        panel.add(txtPrice);

        // ROW 4: Process button and Save button.
        panel.add(btnProcess);
        panel.add(btnSave);

        // Add the completed JPanel to our JFrame window.
        // Without add(panel), the components would not appear.
        add(panel);



        // ========== PROCESS BUTTON EVENT ==========

        // addActionListener() tells Java what to do
        // when the user clicks a button.

        // e represents the event, which is the button click.
        // -> is a lambda arrow that connects the event
        // to the code that should run.

        // When PROCESS is clicked, call processCustomer().
        // We define the processCustomer() method below.
        btnProcess.addActionListener(e -> processCustomer());



        // ========== SAVE BUTTON EVENT ==========

        // The Save button is required in Question 2.2.
        // We are not saving information to a file yet.
        // That functionality will be added in Question 2.3.

        // For now, clicking Save displays a message.
        btnSave.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Save functionality will be added in Q2.3."
                )
        );

    } // End of constructor



    // ========== PROCESS CUSTOMER METHOD ==========

    // This is a method that we created ourselves.
    // It runs when the user clicks the PROCESS button.

    // private means it can only be called directly inside this class.
    // void means this method does not return a value.
    private void processCustomer() {


        // ========== GET CUSTOMER NAME ==========

        // getText() retrieves the text entered in a JTextField.
        // trim() removes spaces at the beginning and end of the text.
        // Example: "  Joe Bloggs  " becomes "Joe Bloggs".
        // String is used because customer names are text.
        String customerName = txtCustomerName.getText().trim();



        // ========== GET STORAGE PRICE ==========

        // Retrieve the information entered into the price text field.
        // JTextField always returns text, even if numbers were entered.
        // We therefore store the value as a String first.
        String priceText = txtPrice.getText().trim();



        // ========== CHECK FOR EMPTY FIELDS ==========

        // isEmpty() checks whether a String contains no characters.
        // || is the logical OR operator.
        // This condition becomes true if either field is empty.
        if (customerName.isEmpty() || priceText.isEmpty()) {

            // JOptionPane displays a message in a pop-up box.
            // this refers to the current FurnitureStorageForm window.
            JOptionPane.showMessageDialog(
                    this, "Please enter a customer name and price."
            );

            // return stops the method immediately.
            // We do not want calculations to run with missing data.
            return;
        }



        // ========== CONVERT INPUT INTO NUMBERS ==========

        // try allows us to execute code that might cause an error.
        // If a conversion fails, catch will handle the error.
        try {

            // Double.parseDouble() converts text into a decimal number.
            // Example: the String "1000" becomes the double 1000.0.
            // We use double because prices may include cents.
            double price = Double.parseDouble(priceText);


            // ========== VALIDATE PRICE ==========

            // <= means less than or equal to.
            // Double.isFinite() checks that the value is a normal,
            // finite number rather than Infinity or NaN.
            // ! means NOT, so !Double.isFinite(price) means
            // the entered number is not finite.
            if (price <= 0 || !Double.isFinite(price)) {

                JOptionPane.showMessageDialog(
                        this, "Please enter a valid price greater than zero."
                );

                // Stop processing if the price is invalid.
                return;
            }



            // ========== GET SELECTED DURATION ==========

            // getSelectedItem() retrieves the item selected
            // by the user from the JComboBox dropdown.

            // toString() converts that item into String text.
            // For example, selecting 3 gives us the String "3".
            String selectedDuration =
                    cmbDuration.getSelectedItem().toString();


            // Integer.parseInt() converts text into a whole number.
            // Example: the String "3" becomes the integer 3.
            // We use int because our duration is in whole months.
            int duration = Integer.parseInt(selectedDuration);



            // ========== CALCULATE VAT ==========

            // VAT is calculated at 15% of the storage price.
            // 0.15 represents 15 divided by 100.
            // Example: 1000 * 0.15 = 150.
            double vat = price * 0.15;



            // ========== CALCULATE TOTAL ==========

            // First add VAT to the original price.
            // Then multiply the result by the storage duration.
            // Example: (1000 + 150) * 3 = 3450.
            double total = (price + vat) * duration;



            // ========== PREPARE THE REPORT ==========

            // A String can contain both text and variable values.
            // The + operator joins text and values together.
            // \n creates a new line in the output.

            // The output contains the customer name, duration,
            // VAT amount and total storage cost.
            String report = "Customer Name: " + customerName
                    + "\nStorage Duration: " + duration
                    + "\nVAT: R " + vat
                    + "\nTOTAL: R " + total;



            // ========== DISPLAY RESULTS ==========

            // showMessageDialog() displays our report in a pop-up.
            // this makes the message box appear relative to our form.
            // report is the String containing all the information.
            JOptionPane.showMessageDialog(this, report);


        } catch (NumberFormatException e) {

            // NumberFormatException happens when Java cannot
            // convert text into a valid number.
            // Example: entering "abc" instead of 1000.

            // catch prevents the program from crashing
            // and allows us to show a useful error message.
            JOptionPane.showMessageDialog(
                    this, "Invalid price. Please enter numbers only."
            );
        }

    } // End of processCustomer() method



    // ========== MAIN METHOD ==========

    // main() is the starting point of a Java application.
    // Java executes this method when the program starts.
    public static void main(String[] args) {

        // Create an object of our FurnitureStorageForm class.
        // This automatically runs the constructor above.
        // The constructor creates and arranges the GUI components.
        FurnitureStorageForm form = new FurnitureStorageForm();

        // Display the GUI window on the screen.
        // true makes the JFrame visible to the user.
        form.setVisible(true);
    }

} // End of FurnitureStorageForm class

