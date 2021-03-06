package org.muni.fi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class SQLServerDB implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    private Connection connection = null;

    public Integer getFreePlaces(Date start, Date end)
    {
        try
        {
            String SQL = "SELECT SUM(chairs) FROM tables;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            int chairsMax = 0;
            while (resultSet.next())
            {
                chairsMax = resultSet.getInt(1);
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            SQL = "SELECT SUM(people) FROM reservations WHERE start <= '"
                    + dateFormat.format(start) + "' AND finish <= '" + dateFormat.format(end) + "';";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            int reserved = 0;
            while (resultSet.next())
            {
                reserved = resultSet.getInt(1);
            }

            return chairsMax - reserved;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return -2;
    }

    public SQLServerDB()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=idrink;user=sa;password=*****";
            connection = DriverManager.getConnection(connectionUrl);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}