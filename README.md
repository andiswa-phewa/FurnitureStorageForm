# Furniture Storage Application
## PROG6112 – Programming 1B
### Question 2.1 and Question 2.2

## Project Overview

The Furniture Storage Application is a Java GUI application developed using Java Swing in NetBeans. It allows users to enter customer details, select a storage duration and calculate VAT and the total furniture storage cost.

## Application Features

- Enter a customer's name and storage price.
- Select a storage duration of 3, 6 or 12 months.
- Calculate VAT at 15% of the storage price.
- Calculate the total cost based on price, VAT and duration.
- Display the results using a message box.
- Display a Save button, which will be implemented in Question 2.3.

## Java Concepts Used

### JFrame
Creates the main application window. The `extends JFrame` statement allows our class to function as a GUI window.

### JPanel and GridLayout
JPanel is a container used to hold GUI components. GridLayout arranges these components into rows and columns.

### JLabel and JTextField
JLabel displays text such as "Customer Name", while JTextField allows users to enter information.

### JComboBox
Creates a dropdown list containing selectable options, such as 3, 6 and 12 months.

### JButton and ActionListener
JButton creates clickable buttons. ActionListener determines what happens when a button is clicked.

### JOptionPane
Displays information, calculation results and error messages in a pop-up window.

### Constructor
A constructor runs automatically when an object is created. In this application, it creates and arranges the GUI components.

### Access Modifiers
The `private` keyword restricts direct access to variables and methods to the class in which they are declared.

### Input Handling and Conversion
- `getText()` retrieves information from a text field.
- `trim()` removes unnecessary spaces at the beginning and end of text.
- `getSelectedItem()` retrieves the selected dropdown option.
- `Double.parseDouble()` converts text into a decimal number.
- `Integer.parseInt()` converts text into a whole number.

### Exception Handling
`try` and `catch` handle errors such as entering letters instead of a valid price, preventing the application from unexpectedly terminating.

## Calculations

VAT = Price × 0.15

Total = (Price + VAT) × Duration

**Example:**

Customer Name: Joe Bloggs

Duration: 3 months

Price: R1000

VAT: R150

Total: R3450

## Running the Application

1. Open the FurnitureStorageApp project in NetBeans.
2. Open `FurnitureStorageForm.java`.
3. Right-click and select Run File.
4. Enter the customer details and select a duration.
5. Click PROCESS to display the calculated results.

## Next Steps

Question 2.3 will introduce saving customer information to `data.txt`. The remaining questions will cover menu systems, interfaces, separate calculation classes and unit testing.
