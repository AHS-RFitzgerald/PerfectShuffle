/**
 * Richard Fitzgerald
 * Project
 * Programming IV
 * Date
 */
public class PerfectShufflesRunner {

   
    public static void main(String[] args) {
        PerfectShuffles deck = new PerfectShuffles(8);
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(deck.perfectInShuffle());
        System.out.println(deck.perfectOutShuffle());
    }

}
