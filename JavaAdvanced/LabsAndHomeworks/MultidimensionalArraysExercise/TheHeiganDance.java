package MultidimensionalArraysExercise;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double playerHitPoints = 18500.0;
        double heiganHitPoints = 3000000.0;
        double damagePerTurn = Double.parseDouble(scanner.nextLine());

        int playerRow = 7;
        int playerCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        while (playerHitPoints > 0 && heiganHitPoints > 0) {
            heiganHitPoints -= damagePerTurn;

            if (activeCloud) {
                playerHitPoints -= 3500;
                activeCloud = false;
                lastSpell = "Plague Cloud";

                if (playerHitPoints <= 0) {
                    break;
                }
            }

            if (heiganHitPoints <= 0) {
                break;
            }

            String[] spellInfo = scanner.nextLine().split("\\s+");
            String spell = spellInfo[0];
            int spellRow = Integer.parseInt(spellInfo[1]);
            int spellCol = Integer.parseInt(spellInfo[2]);

            boolean[][] heiganChamber = new boolean[15][15];

            for (int i = spellRow - 1; i <= spellRow + 1; i++) {
                for (int j = spellCol - 1; j <= spellCol + 1; j++) {
                    if (i >= 0 && i < 15 && j >= 0 && j < 15) {
                        heiganChamber[i][j] = true;
                    }
                }
            }

            if (heiganChamber[playerRow][playerCol]) {
                boolean canMoveUp = playerRow - 1 >= 0 && !heiganChamber[playerRow - 1][playerCol];
                boolean canMoveRight = playerCol + 1 < 15 && !heiganChamber[playerRow][playerCol + 1];
                boolean canMoveDown = playerRow + 1 < 15 && !heiganChamber[playerRow + 1][playerCol];
                boolean canMoveLeft = playerCol - 1 >= 0 && !heiganChamber[playerRow][playerCol - 1];

                if (canMoveUp) {
                    playerRow--;
                } else if (canMoveRight) {
                    playerCol++;
                } else if (canMoveDown) {
                    playerRow++;
                } else if (canMoveLeft) {
                    playerCol--;
                } else {
                    if (spell.equals("Cloud")) {
                        playerHitPoints -= 3500;
                        lastSpell = "Plague Cloud";
                        activeCloud = true;
                    } else if (spell.equals("Eruption")) {
                        playerHitPoints -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }

        // Print the result
        if (heiganHitPoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (playerHitPoints > 0) {
            System.out.printf("Player: %.0f%n", playerHitPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);


    }
}
