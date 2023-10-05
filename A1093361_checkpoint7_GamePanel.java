
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class A1093361_checkpoint7_GamePanel extends JPanel {
    // Description : the obstacle location set in GUI index version.
    private ArrayList<Integer[]> obstacleList;
    // Description : the obstacle images set. bar_id -> obstacle image
    private HashMap<Integer, Image> obstacleImg = new HashMap<>();
    // Description : the image object of the map.
    private Image mapImg = new ImageIcon("Resource/map.png").getImage();
    // Description : the displaysize of the map
    private int scaler;
    private ArrayList<A1093361_checkpoint7_House> houseList = new ArrayList<A1093361_checkpoint7_House>();
    private ArrayList<A1093361_checkpoint7_Barrack> barrackList = new ArrayList<A1093361_checkpoint7_Barrack>();
    private ArrayList<A1093361_checkpoint7_Pyramid> pyramidList = new ArrayList<A1093361_checkpoint7_Pyramid>();
    private ArrayList<A1093361_checkpoint7_Soldier> soldierList = new ArrayList<A1093361_checkpoint7_Soldier>();
    // Description : the normal image size.
    // Hint : while the mapsize is not normal size, you have to think of the
    // displaysize.
    private int originalGridLen = 256;
    // Description : the image displaysize.
    private int gridLen;
    // Description : the map center point x-axis location.
    // Hint : While dragging the map, you may need to set the map location via this.
    private Integer centerX = 0;
    // Description : the map center point y-axis location.
    // Hint : While dragging the map, you may need to set the map location via this.
    private Integer centerY = 0;

    public A1093361_checkpoint7_GamePanel(ArrayList<A1093361_checkpoint7_House> houseList,
            ArrayList<A1093361_checkpoint7_Barrack> barrackList, ArrayList<A1093361_checkpoint7_Pyramid> pyramidList,
            ArrayList<Integer[]> obstacleList, HashMap<Integer, Image> obstacleImg, int scaler) {
        this.obstacleList = obstacleList;
        this.scaler = scaler;
        this.obstacleImg = obstacleImg;
        this.houseList = houseList;
        this.barrackList = barrackList;
        this.pyramidList = pyramidList;
        gridLen = originalGridLen / scaler;

        // TODO(Past) You need to set the center point location of the map into variable
        // centerX, centerY.
        // Hint: While setting the location, you have to consider about the scaler of
        // the map.
        // Hint2: If jfScaler is 4, then the value of centerX is 512; centerY is 512.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        setCenterX((4096 / scaler) / 2);
        setCenterY((4096 / scaler) / 2);
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    // Description : While painting this JPanel, we draw map on the given location
    // and other obstacles.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // TODO(1) You need to calculate the location where panel should start
        // drawImage,
        // and then draw the whole map on the panel.
        // Hint1: To get the location where panel should start drawImage(mapX, mapY),
        // use getWidth and getHeight function and calculate with centerX, centerY.
        // Hint2: If jfScaler is 4, then the value of mapX is -2xx; mapY is -2xx.
        // Hint3: To draw the whole map, you can use g.drawImage(Image img, int x, int
        // y, int Width, int Height) method.
        // Also, You should draw twice, one for map image, one for obstacle image.
        // Hint4: You should use setLocation(int X, int Y) method to set every
        // building's location.
        // To get X and Y, use getlocationX() function from buildings' object and
        // calculate with mapX and mapY.
        // As a reminder, you should also consider about the jfscaler while calculating
        // X and Y.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        if (mapImg != null) {
            g.drawImage(mapImg, -getCenterX() + this.getWidth() / 2, -getCenterY() + this.getHeight() / 2,
                    4096 / scaler, 4096 / scaler, null);//
        }

        // obstacle
        int i = 0;
        for (int y = 0; y <= 4096 / originalGridLen + 1; y++) {
            for (int x = 0; x < 4096 / originalGridLen + 1; x++) {
                if (i < obstacleList.size() && y == obstacleList.get(i)[0] && x == obstacleList.get(i)[1]) {
                    g.drawImage(obstacleImg.get(obstacleList.get(i)[2]),
                            -getCenterX() + this.getWidth() / 2 + gridLen * (x),
                            -getCenterY() + this.getHeight() / 2 + gridLen * (y), gridLen, gridLen, null);
                    i++;
                } else {
                    continue;
                }
            }
        }

        for (A1093361_checkpoint7_House temp : houseList) {

            temp.setLocation(-getCenterX() + this.getWidth() / 2 + gridLen *
                    (temp.getlocationX()),
                    -getCenterY() + this.getHeight() / 2 + gridLen * (temp.getlocationY()));
        }
        for (A1093361_checkpoint7_Barrack temp : barrackList) {

            temp.setLocation(-getCenterX() + this.getWidth() / 2 + gridLen * (temp.getlocationX()),
                    -getCenterY() + this.getHeight() / 2 + gridLen * (temp.getlocationY()));
        }
        for (A1093361_checkpoint7_Pyramid temp : pyramidList) {

            temp.setLocation(-getCenterX() + this.getWidth() / 2 + gridLen *
                    (temp.getlocationX()),
                    -getCenterY() + this.getHeight() / 2 + gridLen * (temp.getlocationY()));
        }
        int l = 0;
        for (A1093361_checkpoint7_Soldier temp : soldierList) {
            temp.setLocation(-getCenterX() + this.getWidth() / 2 + gridLen *
                    (temp.getlocationX()),
                    -getCenterY() + this.getHeight() / 2 + gridLen * (temp.getlocationY()));
        }
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    public Integer getCenterX() {
        return this.centerX;
    }

    public void setCenterX(Integer centerX) {
        this.centerX = centerX;
    }

    public Integer getCenterY() {
        return this.centerY;
    }

    public void setCenterY(Integer centerY) {
        this.centerY = centerY;
    }

    public Integer getGridLen() {
        return this.gridLen;
    }

    public void setHouseList(ArrayList<A1093361_checkpoint7_House> houseList) {
        this.houseList = houseList;
    }

    public void setBarrackList(ArrayList<A1093361_checkpoint7_Barrack> barrackList) {
        this.barrackList = barrackList;
    }

    public void setPyramidList(ArrayList<A1093361_checkpoint7_Pyramid> pyramidList) {
        this.pyramidList = pyramidList;
    }

    public void addToSoldierList(A1093361_checkpoint7_Soldier soldier) {
        this.soldierList.add(soldier);
    }

    public ArrayList<A1093361_checkpoint7_Soldier> getSoldierList() {
        return soldierList;
    }
}
