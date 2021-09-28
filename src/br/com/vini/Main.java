package br.com.vini;

import br.com.vini.helpers.CharacterHelper;
import br.com.vini.helpers.ScreenPrinter;
import br.com.vini.model.Character;

import java.util.Scanner;

public class Main {

    private static int timer = 1;

    public static void main(String[] args) {
        Scanner sys = new Scanner(System.in);

        System.out.println("Com quem vc deseja lutar? 1 = arqueiro / 2 = cavalero / 3 = mago");
        String chosenPlayer = sys.nextLine();
        Character player = CharacterHelper.characterFactory(chosenPlayer);

        System.out.println("Contra quem vc deseja lutar? 1 = arqueiro / 2 = cavalero / 3 = mago");
        String chosenEnemy = sys.nextLine();
        Character enemy = CharacterHelper.characterFactory(chosenEnemy);

        ScreenPrinter.startGame(player,enemy);
        while(player.getHp() > 0 && enemy.getHp() > 0){
            CharacterHelper.play(player, enemy, true);
            CharacterHelper.play(enemy,player, false);
            ScreenPrinter.refreshData(player,enemy,timer);
            timer += 1;
        }
        ScreenPrinter.printWinner(player,enemy);
    }

}
