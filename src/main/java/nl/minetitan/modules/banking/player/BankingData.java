package nl.minetitan.modules.banking.player;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.player in de class BankingData.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.banking.enums.AccountType;
import org.bukkit.Bukkit;

import java.sql.*;
import java.util.*;

public class BankingData {

    public BankingAccount createAccount(AccountType type, UUID holderUUID, double startBalance, String identifier){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO minetopia_banking VALUES(?,?,?,?,?)";

        int newID = new BankingData().getAccountsIDs().size()+1;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, newID);
            statement.setString(2, holderUUID.toString());
            statement.setString(3, type.toString());
            statement.setString(4, identifier);
            statement.setDouble(5, 500.0);

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

        return new BankingAccount(newID);
    }

    private List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                if (md.getColumnName(i).equalsIgnoreCase("ACCOUNTID")) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
            }
            rows.add(row);
        }
        return rows;
    }

    public List<Map<String, Object>> getAccountsIDs(){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("SELECT * FROM minetopia_banking");

            ResultSet set = statement.executeQuery();

            return resultSetToList(set);
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
        return null;
    }

    public boolean doesAccountExist(int id){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("SELECT * FROM minetopia_banking WHERE ACCOUNTID=?");

            statement.setInt(1, id);

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }

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
        return false;
    }

    private int getRowCount(ResultSet resultSet) {
        if (resultSet == null) {
            return 0;
        }
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            try {
                resultSet.beforeFirst();
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
        return 0;
    }

}
