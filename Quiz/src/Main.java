import java.util.Scanner;
import java.time.MonthDay;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Scores for four planetary archetypes
        int neptune = 0;
        int mars = 0;
        int uranus = 0;
        int jupiter = 0;

        System.out.println("==================================");
        System.out.println("          ASTROLOGY QUIZ");
        System.out.println("    Discover Your Cosmic Identity");
        System.out.println("==================================");

        // Question 1: Date of birth
        System.out.println("\n1. What is your date of birth?");

        int day;
        int month;

        while (true) {
            day = readNumber(scanner, "Enter day (1-31): ");
            month = readNumber(scanner, "Enter month (1-12): ");

            try {
                MonthDay.of(month, day);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date. Please try again.");
            }
        }

        String zodiacSign = getZodiacSign(day, month);

        // Question 2: Birth period
        System.out.println("\n2. During which part of the day were you born?");
        System.out.println("1. Early morning");
        System.out.println("2. Morning");
        System.out.println("3. Afternoon");
        System.out.println("4. Evening");
        System.out.println("5. Night");

        int birthPeriod = readChoice(scanner, 1, 5);

        // Question 3: Birthplace
        System.out.println("\n3. In which city and country were you born?");
        String birthplace = scanner.nextLine();

        // Question 4: Personality
        System.out.println("\n4. Which description sounds most like you?");
        System.out.println("1. I am creative, dreamy and musical.");
        System.out.println("2. I am assertive, energetic and impulsive.");
        System.out.println("3. I love technology, freedom and unusual ideas.");
        System.out.println("4. I am generous, adventurous and curious.");

        int answer = readChoice(scanner, 1, 4);

        if (answer == 1) neptune++;
        if (answer == 2) mars++;
        if (answer == 3) uranus++;
        if (answer == 4) jupiter++;

        // Question 5: Inspiration
        System.out.println("\n5. What inspires you most?");
        System.out.println("1. Music, art and imagination.");
        System.out.println("2. Challenges, competition and action.");
        System.out.println("3. New ideas, technology and freedom.");
        System.out.println("4. Travelling, discovering and learning.");

        answer = readChoice(scanner, 1, 4);

        if (answer == 1) neptune++;
        if (answer == 2) mars++;
        if (answer == 3) uranus++;
        if (answer == 4) jupiter++;

        // Question 6: Unexpected situations
        System.out.println("\n6. How do you react to unexpected situations?");
        System.out.println("1. I retreat into my thoughts and imagination.");
        System.out.println("2. I act immediately.");
        System.out.println("3. I look for an unconventional solution.");
        System.out.println("4. I see it as an opportunity to explore.");

        answer = readChoice(scanner, 1, 4);

        if (answer == 1) neptune++;
        if (answer == 2) mars++;
        if (answer == 3) uranus++;
        if (answer == 4) jupiter++;

        // Question 7: Ideal life
        System.out.println("\n7. What would you choose for your ideal life?");
        System.out.println("1. A creative life full of dreams.");
        System.out.println("2. A life full of challenges and achievements.");
        System.out.println("3. A free life without limits.");
        System.out.println("4. A life full of adventures and knowledge.");

        answer = readChoice(scanner, 1, 4);

        if (answer == 1) neptune++;
        if (answer == 2) mars++;
        if (answer == 3) uranus++;
        if (answer == 4) jupiter++;

        // Calculate the highest score
        int highestScore = Math.max(
                Math.max(neptune, mars),
                Math.max(uranus, jupiter)
        );

        // Display results
        System.out.println("\n==================================");
        System.out.println("         YOUR COSMIC PROFILE");
        System.out.println("==================================");

        System.out.println("Your Zodiac Sign: " + zodiacSign);
        System.out.println("Your birthplace: " + birthplace);

        System.out.println("\nYour Planetary Archetype:");

        if (neptune == highestScore) {
            System.out.println("Neptune — The Dreamer");
        }

        if (mars == highestScore) {
            System.out.println("Mars — The Warrior");
        }

        if (uranus == highestScore) {
            System.out.println("Uranus — The Innovator");
        }

        if (jupiter == highestScore) {
            System.out.println("Jupiter — The Explorer");
        }

        System.out.println("\nThank you for exploring your cosmic identity!");

        scanner.close();
    }

    // Read a number from the user
    public static int readNumber(Scanner scanner, String message) {

        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Validate multiple-choice answers
    public static int readChoice(Scanner scanner, int min, int max) {

        while (true) {
            int choice = readNumber(scanner, "Choose your answer: ");

            if (choice >= min && choice <= max) {
                return choice;
            }

            System.out.println("Please choose a number from "
                    + min + " to " + max + ".");
        }
    }

    // Determine zodiac sign
    public static String getZodiacSign(int day, int month) {

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
            return "Aries";

        if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
            return "Taurus";

        if ((month == 5 && day >= 21) || (month == 6 && day <= 20))
            return "Gemini";

        if ((month == 6 && day >= 21) || (month == 7 && day <= 22))
            return "Cancer";

        if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
            return "Leo";

        if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
            return "Virgo";

        if ((month == 9 && day >= 23) || (month == 10 && day <= 22))
            return "Libra";

        if ((month == 10 && day >= 23) || (month == 11 && day <= 21))
            return "Scorpio";

        if ((month == 11 && day >= 22) || (month == 12 && day <= 21))
            return "Sagittarius";

        if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
            return "Capricorn";

        if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
            return "Aquarius";

        return "Pisces";
    }
}