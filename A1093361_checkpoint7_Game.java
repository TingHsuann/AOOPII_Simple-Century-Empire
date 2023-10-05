// This is the main class of checkpoint this time.
public class A1093361_checkpoint7_Game {
    public static void main(String[] args) {
        // The TODO This Time (Checkpoint7) :You need to initialize GameFrame object
        // (int FWidth, int FHeight,
        // String mapID, int jfScaler, int algorithm)
        // the size of JFrame is 500*500, mapID and jfScaler are the values that get
        // from the command line.
        // Finally, set JFrame visible.
        // Hint: Beware of the value that you should put in GameFrame object all
        // correct.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        String map_id = args[0];
        int jfScaler = Integer.parseInt(args[1]);
        int algorithm = Integer.parseInt(args[2]);
        A1093361_checkpoint7_GameFrame gameFrame = new A1093361_checkpoint7_GameFrame(500, 500, map_id, jfScaler,
                algorithm);
        gameFrame.setVisible(true);
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/

    }
}
