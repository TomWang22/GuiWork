import javax.swing.*;
public class DropDown {
    public static void main(String[] args) {
        String[] optionsToChoose = {"American", "Chinese Food", "Japanese food", "Indian food"};

        String getFavFood = (String) JOptionPane.showInputDialog(
                null,
                "What type of food you like the most?",
                "Choose the type of food you like",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[3]);

        System.out.println("Your chosen styleoffood: " + getFavFood);
    }
}
