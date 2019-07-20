package nl.minetitan.sql;
/*
Door: Maiky
Package: nl.minetitan.sql in de class SQLManager.
*/

import com.zaxxer.hikari.HikariDataSource;
import nl.minetitan.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLManager implements SQLInterface {

    @Override
    public void createArchiveTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_archive(objectID int(32), objectDescription varchar(255))";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }

                if (statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createBankingTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_banking(UUID varchar(48), USERNAME varchar(48), BALANCE double(255,2))";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }

                if (statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createTemporaryDataTable() {

    }

    @Override
    public void createUserTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_users(UUID varchar(48), USERNAME varchar(48), LEVEL int(255), PREFIX varchar(255), " +
                "FITHEID int(255)," +
                "NAAMKLEUR varchar(255)," +
                "LEVELKLEUREN varchar(255)," +
                "CHATKLEUREN varchar(255))";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }

                if (statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
