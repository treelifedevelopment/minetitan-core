package nl.minetitan.util;
/*
Door: Maiky
Package: nl.minetitan.util in de class FastMath.
*/

import nl.minetitan.Core;
import org.bukkit.Bukkit;

import java.text.DecimalFormat;
import java.util.Random;

public class FastMath {

    public static double calculateTemperature(double d){
            boolean weert = Bukkit.getWorld(Core.getInstance().getConfig().getString("world")).hasStorm();
            long tijd = Bukkit.getWorld(Core.getInstance().getConfig().getString("world")).getTime();
            if (Bukkit.getWorld(Core.getInstance().getConfig().getString("world")).getName().equalsIgnoreCase("Graydale")) {
                if (weert && tijd >= 0L && tijd < 1000L)
                    return Double.valueOf(-1.22D);
                if (weert && tijd >= 1000L && tijd < 3000L)
                    return Double.valueOf(-1.96D);
                if (weert && tijd >= 3000L && tijd < 5000L)
                    return Double.valueOf(-0.21D);
                if (weert && tijd >= 5000L && tijd < 7000L)
                    return Double.valueOf(0.43D);
                if (weert && tijd >= 7000L && tijd < 9000L)
                    return Double.valueOf(1.12D);
                if (weert && tijd >= 90000L && tijd < 11000L)
                    return Double.valueOf(1.41D);
                if (weert && tijd >= 11000L && tijd < 13000L)
                    return Double.valueOf(0.53D);
                if (weert && tijd >= 13000L && tijd < 15000L)
                    return Double.valueOf(0.19D);
                if (weert && tijd >= 15000L && tijd < 17000L)
                    return Double.valueOf(-1.62D);
                if (weert && tijd >= 17000L && tijd < 19000L)
                    return Double.valueOf(-1.39D);
                if (weert && tijd >= 19000L && tijd < 21000L) {
                    return Double.valueOf(-2.12D);
                }
                if (!weert && tijd >= 0L && tijd < 1000L)
                    return Double.valueOf(2.73D);
                if (!weert && tijd >= 1000L && tijd < 3000L)
                    return Double.valueOf(2.96D);
                if (!weert && tijd >= 3000L && tijd < 5000L)
                    return Double.valueOf(3.21D);
                if (!weert && tijd >= 5000L && tijd < 7000L)
                    return Double.valueOf(4.43D);
                if (!weert && tijd >= 7000L && tijd < 9000L)
                    return Double.valueOf(5.12D);
                if (!weert && tijd >= 90000L && tijd < 11000L)
                    return Double.valueOf(6.41D);
                if (!weert && tijd >= 11000L && tijd < 13000L)
                    return Double.valueOf(7.22D);
                if (!weert && tijd >= 130000L && tijd < 15000L)
                    return Double.valueOf(7.19D);
                if (!weert && tijd >= 15000L && tijd < 17000L)
                    return Double.valueOf(6.31D);
                if (!weert && tijd >= 170000L && tijd < 19000L)
                    return Double.valueOf(5.39D);
                if (!weert && tijd >= 19000L && tijd < 21000L) {
                    return Double.valueOf(4.82D);
                }
                return Double.valueOf(18.27D);
            }
            if (weert && tijd >= 0L && tijd < 1000L)
                return Double.valueOf(15.22D);
            if (weert && tijd >= 1000L && tijd < 3000L)
                return Double.valueOf(16.96D);
            if (weert && tijd >= 3000L && tijd < 5000L)
                return Double.valueOf(17.21D);
            if (weert && tijd >= 5000L && tijd < 7000L)
                return Double.valueOf(17.43D);
            if (weert && tijd >= 7000L && tijd < 9000L)
                return Double.valueOf(18.12D);
            if (weert && tijd >= 90000L && tijd < 11000L)
                return Double.valueOf(18.41D);
            if (weert && tijd >= 11000L && tijd < 13000L)
                return Double.valueOf(17.53D);
            if (weert && tijd >= 130000L && tijd < 15000L)
                return Double.valueOf(17.19D);
            if (weert && tijd >= 15000L && tijd < 17000L)
                return Double.valueOf(16.62D);
            if (weert && tijd >= 170000L && tijd < 19000L)
                return Double.valueOf(16.39D);
            if (weert && tijd >= 19000L && tijd < 21000L) {
                return Double.valueOf(15.12D);
            }
            if (!weert && tijd >= 0L && tijd < 1000L)
                return Double.valueOf(22.73D);
            if (!weert && tijd >= 1000L && tijd < 3000L)
                return Double.valueOf(22.96D);
            if (!weert && tijd >= 3000L && tijd < 5000L)
                return Double.valueOf(23.21D);
            if (!weert && tijd >= 5000L && tijd < 7000L)
                return Double.valueOf(24.43D);
            if (!weert && tijd >= 7000L && tijd < 9000L)
                return Double.valueOf(25.12D);
            if (!weert && tijd >= 90000L && tijd < 11000L)
                return Double.valueOf(26.41D);
            if (!weert && tijd >= 11000L && tijd < 13000L)
                return Double.valueOf(27.22D);
            if (!weert && tijd >= 130000L && tijd < 15000L)
                return Double.valueOf(27.19D);
            if (!weert && tijd >= 15000L && tijd < 17000L)
                return Double.valueOf(26.31D);
            if (!weert && tijd >= 170000L && tijd < 19000L)
                return Double.valueOf(25.39D);
            if (!weert && tijd >= 19000L && tijd < 21000L) {
                return Double.valueOf(24.82D);
            }
            return Double.valueOf(18.27D);
        }

}
