package nl.minetitan.handler.config;

import nl.minetitan.Core;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configurator {

    private File file;
    private FileConfiguration config;

    private Core plugin = Core.getInstance();
    private String fileName;

    public Configurator(String filename){
        this.fileName = filename;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig(){
        try {
            config.save ( file );
        } catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void loadConfig() {
        file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(fileName, false);
        }

        config= new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
