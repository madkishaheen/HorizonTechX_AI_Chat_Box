import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Chatbot {

    // Main method that decides the chatbot response
    public String getResponse(String message) {

        message = message.toLowerCase().trim();

        // Calculator
        if (message.startsWith("calculate")) {
            return calculate(message);
        }

        // Greetings
        if (message.contains("hello") ||
            message.equals("hi") ||
            message.contains("hey")) {

            return "Hello! How can I help you?";
        }

        // How are you
        else if (message.contains("how are you")) {

            return "I am doing great! Thank you for asking.";
        }

        // Name
        else if (message.contains("your name")) {

            return "My name is JavaBot.";
        }

        // Who created you
        else if (message.contains("who created you")) {

            return "I am a Java-based rule-based chatbot created as an internship project.";
        }

        // What can you do
        else if (message.contains("what can you do")) {

            return "I can answer questions about Java, OOP, classes, objects, "
                    + "date, time, and simple calculations.";
        }

        // Help
        else if (message.equals("help")) {

            return "Available operations:\n"
                    + "1. Greetings\n"
                    + "2. Java questions\n"
                    + "3. OOP questions\n"
                    + "4. Class and Object questions\n"
                    + "5. Date and Time\n"
                    + "6. Calculator\n"
                    + "7. General conversation";
        }

        // Java
        else if (message.contains("what is java") ||
                 message.contains("tell me about java") ||
                 message.contains("explain java")) {

            return "Java is a popular object-oriented programming language. "
                    + "It is used to develop desktop, web, mobile and enterprise applications.";
        }

        // OOP
        else if (message.contains("what is oop") ||
                 message.contains("oops") ||
                 message.contains("object oriented programming")) {

            return "OOP stands for Object-Oriented Programming. "
                    + "Its main concepts are Encapsulation, Inheritance, "
                    + "Polymorphism and Abstraction.";
        }

        // Class
        else if (message.contains("what is a class") ||
                 message.equals("what is class") ||
                 message.contains("explain class")) {

            return "A class is a blueprint or template used to create objects in Java.";
        }

        // Object
        else if (message.contains("what is an object") ||
                 message.equals("what is object") ||
                 message.contains("explain object")) {

            return "An object is an instance of a class. "
                    + "It contains data and methods.";
        }

        // Encapsulation
        else if (message.contains("encapsulation")) {

            return "Encapsulation means wrapping data and methods together "
                    + "inside a class and controlling access to the data.";
        }

        // Inheritance
        else if (message.contains("inheritance")) {

            return "Inheritance allows one class to acquire properties and "
                    + "methods from another class.";
        }

        // Polymorphism
        else if (message.contains("polymorphism")) {

            return "Polymorphism means one method or object can have different forms.";
        }

        // Abstraction
        else if (message.contains("abstraction")) {

            return "Abstraction means hiding unnecessary implementation details "
                    + "and showing only important information.";
        }

        // Array
        else if (message.contains("what is array") ||
                 message.contains("arrays")) {

            return "An array is a collection of elements of the same data type "
                    + "stored under one variable name.";
        }

        // String
        else if (message.contains("what is string") ||
                 message.contains("strings")) {

            return "A String in Java is a sequence of characters.";
        }

        // Variable
        else if (message.contains("what is variable") ||
                 message.contains("variables")) {

            return "A variable is a named memory location used to store data.";
        }

        // Date
        else if (message.contains("date") ||
                 message.contains("today")) {

            LocalDate date = LocalDate.now();

            return "Today's date is "
                    + date.format(
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")
                    );
        }

        // Time
        else if (message.contains("time")) {

            LocalTime time = LocalTime.now();

            return "The current time is "
                    + time.format(
                        DateTimeFormatter.ofPattern("HH:mm:ss")
                    );
        }

        // Thank you
        else if (message.contains("thank")) {

            return "You're welcome! I am happy to help.";
        }

        // Goodbye
        else if (message.contains("bye") ||
                 message.contains("goodbye")) {

            return "Goodbye! Have a great day!";
        }

        // Unknown question
        else {

            return "Sorry, I don't understand that yet.\n"
                    + "Type 'help' to see what I can do.";
        }
    }


    // Calculator method
    private String calculate(String message) {

        try {

            String expression = message
                    .replace("calculate", "")
                    .trim();

            // Addition
            if (expression.contains("+")) {

                String[] numbers = expression.split("\\+");

                double a = Double.parseDouble(numbers[0].trim());
                double b = Double.parseDouble(numbers[1].trim());

                return "Answer: " + (a + b);
            }

            // Subtraction
            else if (expression.contains("-")) {

                String[] numbers = expression.split("-");

                double a = Double.parseDouble(numbers[0].trim());
                double b = Double.parseDouble(numbers[1].trim());

                return "Answer: " + (a - b);
            }

            // Multiplication
            else if (expression.contains("*")) {

                String[] numbers = expression.split("\\*");

                double a = Double.parseDouble(numbers[0].trim());
                double b = Double.parseDouble(numbers[1].trim());

                return "Answer: " + (a * b);
            }

            // Division
            else if (expression.contains("/")) {

                String[] numbers = expression.split("/");

                double a = Double.parseDouble(numbers[0].trim());
                double b = Double.parseDouble(numbers[1].trim());

                if (b == 0) {
                    return "You cannot divide by zero.";
                }

                return "Answer: " + (a / b);
            }

            return "Please use +, -, * or /.\n"
                    + "Example: calculate 10 + 20";

        } catch (Exception e) {

            return "I could not calculate that.\n"
                    + "Example: calculate 10 + 20";
        }
    }
}