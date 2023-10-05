import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class A1093361_checkpoint7_QueryDB {
    // //Description : the driver description of mysql
    // private static final String driver = "com.mysql.cj.jdbc.Driver";
    // //Description : the protocol description of mysql
    // private static final String protocol = "jdbc:mysql://140.127.220.220:3306/";
    // Description : the obstacle set queried from database.
    private static ArrayList<Integer[]> data = new ArrayList<Integer[]>();
    // Description : the filename of obstacle image queried from database.
    private static HashMap<Integer, String> typeChar = new HashMap<Integer, String>();
    // Description : the primary key of map in database.
    private static String mapID = "0";

    public static void queryData(ArrayList<Integer[]> data, HashMap<Integer, String> typeChar) {
        // TODO(Past): Querying the barrier location from the server, and set it into
        // Arraylist data.
        // TODO(Past): Querying the bar_type and the corresponding file_name from the
        // server, and set it into HashMap.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        final String URL = "jdbc:postgresql://140.127.220.226:5432/oopiickp";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, "fallckp", "2021OOPIIpwd");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        A1093361_checkpoint7_QueryDB db = new A1093361_checkpoint7_QueryDB();
        db.findObstacleType(connection, typeChar);
        db.findObstacleInfo(connection, data);
        db.arrangeObstacle(db.getObstacle());
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/

    }

    private void findObstacleType(Connection connection, HashMap<Integer, String> styleHashMap) {
        final String SELECT_QUERY = "SELECT obstacle_type,filename FROM obstacle_style";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            while (resultSet.next()) {
                Integer type = null;
                String display = null;
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (resultSet.getObject(i) == null) {
                        display = "";
                        continue;
                    }

                    String temp = resultSet.getObject(i).toString();
                    if (i == 1) {
                        type = Integer.parseInt(temp);
                    }
                    if (i == 2) {
                        display = temp;
                    }
                }
                styleHashMap.put(type, display);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        setObstacleImg(styleHashMap);
    }

    private void findObstacleInfo(Connection connection, ArrayList<Integer[]> obstacleList) {
        final String SELECT_QUERY = "SELECT obstacle_info.x_coordinate,obstacle_info.y_coordinate,obstacle_info.obstacle_type FROM obstacle_info WHERE obstacle_info.map_id="
                + getMapID();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

            while (resultSet.next()) {
                Integer[] obstacle = new Integer[3];
                // int over = 0;
                for (int i = 1; i <= 3; i++) {
                    Integer temp = Integer.parseInt(resultSet.getObject(i).toString());

                    switch (i) {
                        case 1:
                            obstacle[0] = temp;
                            break;
                        case 2:
                            obstacle[1] = temp;
                            break;
                        case 3:
                            obstacle[2] = temp;
                            obstacleList.add(obstacle);
                            break;
                    }
                    // if (over == 1) {
                    // break;
                    // }
                }

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        setObstacle(obstacleList);
    }

    private void arrangeObstacle(ArrayList<Integer[]> obstacleList) {
        // arrange (,x)
        ArrayList<Integer[]> temp1 = new ArrayList<Integer[]>();
        for (int i = 1; i <= 16; i++) {
            for (Integer[] box : obstacleList) {
                if (i == box[1]) {
                    temp1.add(box);
                }
            }
        }

        // arrange (x,)
        ArrayList<Integer[]> temp2 = new ArrayList<Integer[]>();
        for (int i = 1; i <= 16; i++) {
            for (Integer[] box : temp1) {
                if (i == box[0]) {
                    temp2.add(box);
                }
            }
        }

        // final arrange
        obstacleList.clear();
        for (int i = 1; i <= 16; i++) {
            for (Integer[] box : temp2) {
                if (i == box[1]) {
                    obstacleList.add(box);
                }
            }
        }
        setObstacle(obstacleList);
    }

    public ArrayList getObstacle() {
        return this.data;
    }

    public void setObstacle(ArrayList<Integer[]> data) {
        this.data = data;
    }

    public String getMapID() {
        return this.mapID;
    }

    public void setMapID(String mapID) {
        this.mapID = mapID;
    }

    public HashMap getObstacleImg() {
        return this.typeChar;
    }

    public void setObstacleImg(HashMap<Integer, String> typeChar) {
        this.typeChar = typeChar;
    }
}
