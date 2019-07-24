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

    public void createFitnessTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_fitness(UUID varchar(88), POINTS int(255), HAS_RESET varchar(48))";

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

    public void createInventoryTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_inventories(UUID varchar(88), BASE64 LONGTEXT)";

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

    public void createPrefixTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_userprefixes(UUID varchar(88), PREFIXES varchar(255), SCOPE varchar(255))";

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

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_banking(ACCOUNTID int(255)," +
                " ACCOUNTHOLDER_UUID varchar(48)," +
                " ACCOUNT_TYPE varchar(100)," +
                " IDENTIFIER varchar(100)," +
                " BALANCE double(255,2))";

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
    public void createTimeInfoTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_timeonline(UUID varchar(48), DAYS int(255), HOURS int(255), MINUTES int(255), SECONDS int(255))";

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

    public void createChatkleurTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_chatkleur(UUID varchar(90), KLEUREN LONGTEXT, SCOPE varchar(32))";

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
    public void createUserTable() {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "CREATE TABLE IF NOT EXISTS minetopia_users(UUID varchar(48), LEVEL int(255)," +
                "FITHEID int(255)," +
                "NAAMKLEUR varchar(255)," +
                "LEVELKLEUREN varchar(255)," +
                "LUCKYSHARDS double(255,4))";

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
