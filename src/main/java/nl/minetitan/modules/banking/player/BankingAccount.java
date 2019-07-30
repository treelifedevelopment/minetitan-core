package nl.minetitan.modules.banking.player;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.player in de class BankingAccount.
*/

import nl.minetitan.Core;
import nl.minetitan.modules.banking.enums.AccountType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BankingAccount {

    private int accountID;
    public BankingAccount(int accountID){
        this.accountID = accountID;
    }

    public int getID(){
        return this.accountID;
    }

    public boolean has(double amount){
        if (amount <= getBalance()){
            return true;
        }else{
            return false;
        }
    }

    public void deposit(double amount){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("UPDATE minetopia_banking SET BALANCE=? WHERE ACCOUNTID=?");

            statement.setDouble(1, getBalance() + amount);
            statement.setInt(2, getID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void take(double amount){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("UPDATE minetopia_banking SET BALANCE=? WHERE ACCOUNTID=?");

            statement.setDouble(1, getBalance() - amount);
            statement.setInt(2, getID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public double getBalance() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("SELECT * FROM minetopia_banking WHERE ACCOUNTID=?");

            statement.setInt(1, accountID);

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getDouble("BALANCE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }

    public AccountType getAccountType() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("SELECT * FROM minetopia_banking WHERE ACCOUNTID=?");

            statement.setInt(1, accountID);

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return AccountType.valueOf(set.getString("ACCOUNT_TYPE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isHolder(UUID uuid){
        if (getHolders().get(0).equalsIgnoreCase(uuid.toString())){
            return true;
        }else{
            return false;
        }
    }

    public List<String> getHolders(){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("SELECT * FROM minetopia_banking WHERE ACCOUNTID=?");

            statement.setInt(1, accountID);

            ResultSet set = statement.executeQuery();

            if (set.next()) {

                List<String> list = new ArrayList<>();

                String holder = set.getString("ACCOUNTHOLDER_UUID");

                if (holder.contains(";")){
                    String[] holders = holder.split(";");

                    for (String s : holders){
                        list.add(s);
                    }
                }else{
                    list.add(holder);
                }

                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getIdentifier(){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement("SELECT * FROM minetopia_banking WHERE ACCOUNTID=?");

            statement.setInt(1, accountID);

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getString("IDENTIFIER");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isPersonal(int accountID){
        if (getAccountType() == AccountType.PERSONAL){
            return true;
        }else{
            return false;
        }
    }

}
