import javax.swing.*;
public class DropDown {
    public static void main(String[] args) {
        String[] optionsToChoose = {"dogshit", "anzyshit", "tacobellshit", "mcshit", "takeoutshit"};

        String getFavFruit = (String) JOptionPane.showInputDialog(
                null,
                "What Shit you like the most?",
                "Choose shit",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[3]);

        System.out.println("Your chosen shit: " + getFavFruit);
    }
}
