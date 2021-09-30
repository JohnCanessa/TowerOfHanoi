import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public class TowerOfHanoi {

    
    /**
     * Standard Tower of Hanoi game.
     * Excessive Recursive type.
     * 
     * Rules: 
     * 
     * 1. Only one disk can be moved at a time.
     * 2. Each move consists of taking the upper disk from one of the stacks 
     *    and placing it on top of another stack i.e. a disk can only be moved 
     *    if it is the uppermost disk on a stack.
     * 3. No disk may be placed on top of a smaller disk.
     * 
     * On the board:
     * 
     * o Left rod:      Source
     * o Center rod:    Auxiliary
     * o Right rod:     Destination
     * 
     * The pattern here is:
     * 
     * a) Shift 'n-1' disks from 'S' to 'A'.
     * b) Shift last disk from 'S' to 'D'.
     * c) Shift 'n-1' disks from 'A' to 'D'.
     */
    static void towerOfHanoi(int nDisc, char source, char auxiliary, char destination) {

        // **** base case ****
        if (nDisc == 1) {
            System.out.println("<<< move disk 1 from " + source + " to " + destination);
            return;
        }

        // **** recursive call (ource, destination, auxiliary) ****
        towerOfHanoi(nDisc - 1, source, destination, auxiliary);

        // **** ****
        System.out.println("<<< move disk " + nDisc + " from " + source + " to " + destination );

        // **** recursive call (source, auxiliary, destination) ****
        towerOfHanoi(nDisc - 1, auxiliary, source, destination);
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read number of discs ****
        int nDiscs = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< nDiscs: " + nDiscs);
        
        // **** play standard Tower of Hanoi (source, destination auxiliary) ****
        towerOfHanoi(nDiscs, 'S', 'A', 'D');
    }

}