import java.util.Random;

public class genpassw {
    public static void main(String[] args) {
        int lengthy = 10; // length of the password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // characters that can be used ( A, b, 0 )
        StringBuilder passwordi = new StringBuilder();
        Random randompasswordi = new Random();

        for (int i = 0; i < lengthy; i++) { // first i is 0 (our counter), then as i is less than the desired password length it continues and finally i increases to continue to the next character and so on
            int randomindx = randompasswordi.nextInt(characters.length()); // this generates a random integer which will be use to select a character from the characters list
            char randomchar = characters.charAt(randomindx); // this takes the character from the randomindx and saves it in randomchar
            passwordi.append(randomchar); // this puts everything together (appends) and into the new password
        }

        System.out.println("Suggested new password: " + passwordi);
    }
}