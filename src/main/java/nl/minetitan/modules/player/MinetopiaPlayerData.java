package nl.minetitan.modules.player;
/*
Door: Maiky
Package: nl.minetitan.modules.player in de class MinetopiaPlayerData.
*/

import nl.minetitan.Core;
import nl.minetitan.handler.MinetopiaItem;
import nl.minetitan.modules.banking.player.BankingData;
import nl.minetitan.serialize.BukkitSerialization;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MinetopiaPlayerData {

    private UUID uuid;

    public MinetopiaPlayerData(Player player){
        this.uuid = player.getUniqueId();
    }

    public MinetopiaPlayerData(UUID uuid){this.uuid = uuid;}

    public String s = null;

    public String getPrefixScope(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_userprefixes WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                String chatkleuren = set.getString("SCOPE");
                return chatkleuren;
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
        return "Zwerver";
    }

    public void setPrefixes(String input){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_userprefixes SET PREFIXES=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, input);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public void setPrefixScope(String input){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_userprefixes SET SCOPE=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, input);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public String getPrefixesRaw(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_userprefixes WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                String chatkleuren = set.getString("PREFIXES");

                return chatkleuren;
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
        return "Zwerver";
    }

    public int getFitheidPunten(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_fitness WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                return rs.getInt("POINTS");
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
        return 0;
    }

    public void setFitness(int input){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_users SET FITHEID=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, input);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public void setFitheidPunten(int input){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_fitness SET POINTS=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, input);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public List<String> getPrefixes(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_userprefixes WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                String chatkleuren = set.getString("PREFIXES");
                if (chatkleuren.contains(";")){
                    String[] colors = chatkleuren.split(";");

                    List<String> returnable = new ArrayList<>();

                    for (String color : colors){
                        returnable.add(color);
                    }

                    return returnable;
                }else{
                    return Arrays.asList(chatkleuren);
                }
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
        return Arrays.asList("Zwerver");
    }

    public void setLuckyshards(double amount) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_users SET LUCKYSHARDS=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setDouble(1, amount);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public double getLuckyshards(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_users WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                return set.getDouble("LUCKYSHARDS");
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
        return 0.0;
    }

    public String getChatcolorsRaw(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_chatkleur WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getString("KLEUREN");
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
        return "7";
    }

    public List<String> getChatcolors(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_chatkleur WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                String chatkleuren = set.getString("KLEUREN");
                if (chatkleuren.contains(";")){
                    String[] colors = chatkleuren.split(";");

                    List<String> returnable = new ArrayList<>();

                    for (String color : colors){
                        returnable.add(color);
                    }

                    return returnable;
                }else{
                    return Arrays.asList(chatkleuren);
                }
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
        return Arrays.asList("7");
    }

    public int getFitness(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_users WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getInt("FITHEID");
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
        return 0;
    }

    public void setSecondsOnline(int seconds){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_timeonline SET SECONDS=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, seconds);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();

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

    public void setMinutesOnline(int minutes){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_timeonline SET MINUTES=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, minutes);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();

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

    public void setHoursOnline(int hours){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_timeonline SET HOURS=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, hours);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();

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


    public void setDaysOnline(int days){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_timeonline SET DAYS=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, days);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();

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

    public int getSecondsOnline(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_timeonline WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getInt("SECONDS");
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
        return 1;
    }

    public String getChatkleurScope(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_chatkleur WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getString("SCOPE");
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
        return "7";
    }

    public void setChatkleuren(String input){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_chatkleur SET KLEUREN=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, input);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public void addChatkleur(String kleur){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_chatkleur SET KLEUREN=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            String chatkleuren = "";
            for (String color : getChatcolors()){
                chatkleuren += color + ";";
            }

            chatkleuren += kleur;

            statement.setString(1, chatkleuren);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public void setChatkleurScope(String kleur){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_chatkleur SET SCOPE=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, kleur);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public void setNaamkleur(String kleur){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_users SET NAAMKLEUR=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, kleur);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public void setLevel(int level){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_users SET LEVEL=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, level);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
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

    public int getMinutesOnline(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_timeonline WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getInt("MINUTES");
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
        return 1;
    }

    public int getHoursOnline(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_timeonline WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getInt("HOURS");
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
        return 1;
    }

    public int getDaysOnline(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_timeonline WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getInt("DAYS");
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
        return 0;
    }

    public void saveInventory(Inventory inventory){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE minetopia_inventories SET BASE64=? WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, BukkitSerialization.toBase64(inventory));
            statement.setString(2, uuid.toString());

            statement.executeUpdate();
            System.out.println("Updated inventory of " + uuid.toString());
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


    public int getLevel(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_users WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getInt("LEVEL");
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
        return 1;
    }

    public String getNaamkleur(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_users WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return set.getString("NAAMKLEUR");
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
        return "7";
    }

    public void createUser(boolean overwrite){
        if (overwrite && existsInDatabase() && existsInBankingDatabase()){
            // TODO
        }else{
            if (!existsInDatabase()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_users VALUES(?,?,?,?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setString(1, uuid.toString());
                    statement.setInt(2, 1);
                    statement.setInt(3, 20);
                    statement.setString(4, "7");
                    statement.setString(5, "b");
                    statement.setDouble(6, 0.0000);

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

            if (!existsInBankingDatabase()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_banking VALUES(?,?,?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setInt(1, new BankingData().getAccountsIDs().size()+1);
                    statement.setString(2, uuid.toString());
                    statement.setString(3, "PERSONAL");
                    statement.setString(4, "no-identifier");
                    statement.setDouble(5, 0.0);

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

            if(!existsInTimeInfoDatabase()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_timeonline VALUES(?,?,?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setString(1, uuid.toString());
                    statement.setInt(2, 0);
                    statement.setInt(3, 0);
                    statement.setInt(4, 0);
                    statement.setInt(5, 0);

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

            if(!existsInPrefixDatabase()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_userprefixes VALUES(?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setString(1, uuid.toString());
                    statement.setString(2, "Zwerver");
                    statement.setString(3, "Zwerver");

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

            if(!existsInInventoryDatabase()){
                Connection connection = null;
                    PreparedStatement statement = null;

                    String sql = "INSERT INTO minetopia_inventories VALUES(?,?)";

                    try {
                        connection = Core.getInstance().getHikari().getConnection();
                        statement = connection.prepareStatement(sql);

                        statement.setString(1, uuid.toString());

                        Inventory inventory = Bukkit.createInventory(null, 4*9, "Temp");
                        for (int i = 1; i < 17; i++){
                            inventory.addItem(new MinetopiaItem(Material.APPLE).createItem());
                        }

                        statement.setString(2, BukkitSerialization.toBase64(inventory));

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

            if (!existsInFitnessDatabase()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_fitness VALUES(?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setString(1, uuid.toString());
                    statement.setInt(2, 0);
                    statement.setString(3, "false");

                    statement.executeUpdate();

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

            if(!existsInChatkleurDB()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_chatkleur VALUES(?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setString(1, uuid.toString());
                    statement.setString(2, "7");
                    statement.setString(3, "7");

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
    }

    public boolean existsInChatkleurDB(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_chatkleur WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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


    public boolean existsInFitnessDatabase(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_fitness WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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

    public boolean existsInDatabase(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_users WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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

    public boolean existsInPrefixDatabase(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_userprefixes WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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

    public boolean existsInTimeInfoDatabase(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_timeonline WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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

    public ItemStack[] getInventoryInner(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_inventories WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                try {
                    return BukkitSerialization.fromBase64(rs.getString("BASE64")).getContents();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        return null;
    }

    public boolean existsInInventoryDatabase(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_inventories WHERE UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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

    public boolean existsInBankingDatabase(){
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM minetopia_banking WHERE ACCOUNTHOLDER_UUID=?";

        try {
            connection = Core.getInstance().getHikari().getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, uuid.toString());

            ResultSet set = statement.executeQuery();

            if (set.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
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
