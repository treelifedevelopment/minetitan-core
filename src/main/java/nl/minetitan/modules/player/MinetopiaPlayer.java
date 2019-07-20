package nl.minetitan.modules.player;
/*
Door: Maiky
Package: nl.minetitan.modules.player in de class MinetopiaPlayer.
*/

import nl.minetitan.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MinetopiaPlayer {

    private UUID uuid;

    public MinetopiaPlayer(Player player){
        this.uuid = player.getUniqueId();
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
        if (overwrite && existsInDatabase()){
            // TODO
        }else{
            if (!existsInDatabase()){
                Connection connection = null;
                PreparedStatement statement = null;

                String sql = "INSERT INTO minetopia_users VALUES(?,?,?,?,?,?,?,?)";

                try {
                    connection = Core.getInstance().getHikari().getConnection();
                    statement = connection.prepareStatement(sql);

                    statement.setString(1, uuid.toString());
                    statement.setString(2, Bukkit.getOfflinePlayer(uuid).getName());
                    statement.setInt(3, 1);
                    statement.setString(4, "Zwerver");
                    statement.setInt(5, 20);
                    statement.setString(6, "7");
                    statement.setString(7, "b");
                    statement.setString(8, "7");

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

}
