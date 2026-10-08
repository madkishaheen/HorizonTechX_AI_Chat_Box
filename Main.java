import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // Create chatbot object
        Chatbot bot = new Chatbot();

        // Create window
        JFrame frame = new JFrame("Java AI Chatbot");

        frame.setSize(600, 650);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());


        // =========================
        // CHAT AREA
        // =========================

        JTextArea chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setLineWrap(true);

        chatArea.setWrapStyleWord(true);

        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));


        JScrollPane scrollPane = new JScrollPane(chatArea);


        // =========================
        // INPUT FIELD
        // =========================

        JTextField inputField = new JTextField();

        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        inputField.setText("Type your message...");


        // Remove placeholder when clicked
        inputField.addFocusListener(
            new java.awt.event.FocusAdapter() {

                public void focusGained(
                    java.awt.event.FocusEvent e) {

                    if (inputField.getText()
                            .equals("Type your message...")) {

                        inputField.setText("");
                    }
                }

                public void focusLost(
                    java.awt.event.FocusEvent e) {

                    if (inputField.getText().isEmpty()) {

                        inputField.setText(
                            "Type your message..."
                        );
                    }
                }
            }
        );


        // =========================
        // BUTTONS
        // =========================

        JButton sendButton = new JButton("Send");

        JButton clearButton = new JButton("Clear");

        JButton helpButton = new JButton("Help");

        JButton exitButton = new JButton("Exit");


        // =========================
        // BOTTOM PANEL
        // =========================

        JPanel inputPanel = new JPanel(
            new BorderLayout()
        );

        inputPanel.add(
            inputField,
            BorderLayout.CENTER
        );

        inputPanel.add(
            sendButton,
            BorderLayout.EAST
        );


        // =========================
        // BUTTON PANEL
        // =========================

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(helpButton);

        buttonPanel.add(clearButton);

        buttonPanel.add(exitButton);


        // =========================
        // MAIN BOTTOM PANEL
        // =========================

        JPanel bottomPanel = new JPanel(
            new BorderLayout()
        );

        bottomPanel.add(
            inputPanel,
            BorderLayout.CENTER
        );

        bottomPanel.add(
            buttonPanel,
            BorderLayout.SOUTH
        );


        // =========================
        // WELCOME MESSAGE
        // =========================

        chatArea.append(
            "Bot: Hello! I am JavaBot.\n"
            + "Bot: How can I help you today?\n\n"
        );


        // =========================
        // SEND BUTTON
        // =========================

        sendButton.addActionListener(e -> {

            String message =
                inputField.getText().trim();


            if (message.isEmpty()
                    || message.equals(
                        "Type your message..."
                    )) {

                return;
            }


            // Display user message
            chatArea.append(
                "You: " + message + "\n"
            );


            // Get chatbot response
            String response =
                bot.getResponse(message);


            // Display bot response
            chatArea.append(
                "Bot: " + response + "\n\n"
            );


            // Clear input
            inputField.setText("");


            // Stop chatting after bye
            if (message.toLowerCase()
                    .contains("bye")) {

                sendButton.setEnabled(false);

                inputField.setEnabled(false);
            }
        });


        // =========================
        // ENTER KEY
        // =========================

        inputField.addActionListener(
            e -> sendButton.doClick()
        );


        // =========================
        // HELP BUTTON
        // =========================

        helpButton.addActionListener(e -> {

            chatArea.append(
                "Bot: Available operations:\n"
                + "- Greetings\n"
                + "- Java questions\n"
                + "- OOP questions\n"
                + "- Class and Object questions\n"
                + "- Encapsulation\n"
                + "- Inheritance\n"
                + "- Polymorphism\n"
                + "- Abstraction\n"
                + "- Arrays\n"
                + "- Strings\n"
                + "- Variables\n"
                + "- Date and Time\n"
                + "- Calculator\n\n"
            );
        });


        // =========================
        // CLEAR BUTTON
        // =========================

        clearButton.addActionListener(e -> {

            chatArea.setText("");

            chatArea.append(
                "Bot: Chat cleared.\n"
                + "Bot: How can I help you?\n\n"
            );
        });


        // =========================
        // EXIT BUTTON
        // =========================

        exitButton.addActionListener(e -> {

            int answer = JOptionPane.showConfirmDialog(
                frame,
                "Do you want to exit?",
                "Exit Chatbot",
                JOptionPane.YES_NO_OPTION
            );


            if (answer == JOptionPane.YES_OPTION) {

                System.exit(0);
            }
        });


        // =========================
        // ADD COMPONENTS
        // =========================

        frame.add(
            scrollPane,
            BorderLayout.CENTER
        );

        frame.add(
            bottomPanel,
            BorderLayout.SOUTH
        );


        // Center the window
        frame.setLocationRelativeTo(null);


        // Display window
        frame.setVisible(true);
    }
}