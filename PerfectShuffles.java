/**
 * Richard Fitzgerald
 * Programming IV
 * 8/28/19
 */
public class PerfectShuffles {
    private int[] deck;
    
    public PerfectShuffles(int size){
        deck = new int[size];
        for(int x = size - 1; x >= 0; x--){
            deck[x] = x;
        }
    }
    public int[] inShuffle(int[] input){
        int[] firsthalf = new int[input.length/2];
        int[] secondhalf = new int[input.length/2];
        int[] output = new int[input.length];
        for(int x = 0; x < input.length/2; x++){
            firsthalf[x] = input[x];
            secondhalf[x] = input[x + (input.length / 2)];
        }
        int y = 0;
        int z = 0;
        boolean useTopDeck = false;
        
        for(int x = 0; x < input.length; x++){
            if(!useTopDeck){
                output[x] = secondhalf[y];
                y++;
                useTopDeck = true;
            }else if (useTopDeck) {
                output[x] = firsthalf[z];
                z++;
                useTopDeck = false;
            }
        }
        return output;
    }
    public int[] outShuffle(int[] input){
        int[] firsthalf = new int[input.length/2];
        int[] secondhalf = new int[input.length/2];
        int[] output = new int[input.length];
        for(int x = 0; x < input.length/2; x++){
            firsthalf[x] = input[x];
            secondhalf[x] = input[x + input.length / 2];
        }
        int y = 0;
        int z = 0;
        boolean useTopDeck = true;
        
        for(int x = 0; x < input.length; x++){
            if(!useTopDeck){
                output[x] = secondhalf[y];
                y++;
                useTopDeck = true;
                
            }else if (useTopDeck) {
                output[x] = firsthalf[z];
                z++;
                useTopDeck = false;
                
                
            }
            
            
            
        }
        return output;
    }
    public int perfectInShuffle(){
        int count = 0;
       
        boolean isDone = false;
        int[] deck2 = this.inShuffle(deck);
        count++;
        while(!isDone){
            int trackDeck = 0;
            deck2 = this.inShuffle(deck2);
            count++;
            for(int x = 0; x < deck.length; x++){
                if (deck2[x] == deck[x]) {
                    trackDeck++;
                }
            }
            
            if (trackDeck == deck.length)    {
                isDone = true;
            }
        }
        return count;
    }
    public int perfectOutShuffle(){
        int count = 0;
       
        boolean isDone = false;
        int[] deck2 = this.outShuffle(deck);
        count++;
        while(!isDone){
            int trackDeck = 0;
            deck2 = this.outShuffle(deck2);
            count++;
            for(int x = 0; x < deck.length; x++){
                if (deck2[x] == deck[x]) {
                    trackDeck++;
                }
            }
            
            if (trackDeck == deck.length)    {
                isDone = true;
            }
        }
        return count;
    }
    
    public int[] moveTopCard(int pos){
        int[] deck2 = deck;
        String nums = Integer.toBinaryString(pos);
        for(int x = 0; x < nums.length(); x++){
            if (nums.charAt(x) == '1'){
                this.inShuffle(deck2);
            }else if(nums.charAt(x) == '0'){
                this.outShuffle(deck2);
            }
        }
        return deck2;
    }
}
