import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUser {

    private Connection connectionObj;
    private Statement statementObj;
    private ResultSet resultSet;
    private final String dbString = "jdbc:mysql://localhost:3306/rv";
    private final String userName = "root";
    private final String password = "spooky";
    private String SQLString = "SELECT * FROM customer";

    public void showCustomerInfo() {

        try {
                //Get a connection to the database
                connectionObj = DriverManager.getConnection(dbString, userName, password);

                //Create a statement
                statementObj = connectionObj.createStatement();

                //Execute SQL query
                resultSet = statementObj.executeQuery(SQLString);

                //Process the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name"));
                }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public void createCustomer(String firstName, String lastName) {

        try {
            //Get a connection to the database
            connectionObj = DriverManager.getConnection(dbString, userName, password);

            //Create a statement
            statementObj = connectionObj.createStatement();

            //Execute SQL query
            String sql = "INSERT INTO `customer`(first_name, last_name) VALUE ('"+firstName+"', '"+lastName+"' )";

            statementObj.execute(sql);

            System.out.println("insert complete");


        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
