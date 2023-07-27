package FinalExamPreparation;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> mpMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> hpMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String hero = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);
            mpMap.put(hero, mp);
            hpMap.put(hero, hp);
        }

        String text = scanner.nextLine();
        while (!text.equals("End")) {
            String[] textTokens = text.split(" - ");
            String command = textTokens[0];
            String heroName = textTokens[1];
            int heroMP = mpMap.get(heroName);
            int heroHP = hpMap.get(heroName);

            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(textTokens[2]);
                    String spellName = textTokens[3];
                    int currentMP = mpMap.get(heroName);
                    if (currentMP >= neededMP) {
                        int mpLeft = currentMP - neededMP;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                        mpMap.put(heroName, mpLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(textTokens[2]);
                    String attacker = textTokens[3];
                    int currentHP = hpMap.get(heroName);
                    currentHP -= damage;
                    if (currentHP > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                        hpMap.put(heroName, currentHP);
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        hpMap.remove(heroName);
                        mpMap.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(textTokens[2]);
                    int currentMPHero = mpMap.get(heroName);
                    currentMPHero += amount;
                    if (currentMPHero > 200) {
                        currentMPHero = 200;
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, currentMPHero - mpMap.get(heroName));
                    mpMap.put(heroName, currentMPHero);
                    break;
                case "Heal":
                    int amountToHeal = Integer.parseInt(textTokens[2]);
                    int currentHpHero = hpMap.get(heroName);
                    currentHpHero += amountToHeal;
                    if (currentHpHero > 100) {
                        currentHpHero = 100;
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, currentHpHero - hpMap.get(heroName));
                    hpMap.put(heroName, currentHpHero);
                    break;
            }
            text = scanner.nextLine();
        }

        hpMap.forEach((heroName, value) -> {
            System.out.println(heroName);
            System.out.println(" HP: " + value);
            System.out.println(" MP: " + mpMap.get(heroName));
        });
    }
}
