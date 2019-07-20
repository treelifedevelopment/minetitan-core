package nl.minetitan.modules;
/*
Door: Maiky
Package: nl.minetitan.modules in de class ModuleManager.
*/

import lombok.Getter;
import lombok.Setter;
import nl.minetitan.Core;
import nl.minetitan.modules.database.DatabaseModule;
import nl.minetitan.modules.player.PlayerModule;

public class ModuleManager implements MinetopiaModule{

    @Getter @Setter
    private Core core;

    public ModuleManager(Core instance){
        setCore(instance);
    }

    @Override
    public void start(){
        // Modules
        PlayerModule module = new PlayerModule(core);
        DatabaseModule module1 = new DatabaseModule();

        // Starters
        module.start();
        module1.start();
    }

    @Override
    public void stop(){
        // Modules
        PlayerModule module = new PlayerModule(core);
        DatabaseModule module1 = new DatabaseModule();

        // Stoppers
        module.stop();
        module1.stop();
    }

}
