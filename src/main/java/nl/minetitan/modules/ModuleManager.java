package nl.minetitan.modules;
/*
Door: Maiky
Package: nl.minetitan.modules in de class ModuleManager.
*/

import lombok.Getter;
import lombok.Setter;
import nl.minetitan.Core;
import nl.minetitan.modules.banking.BankingModule;
import nl.minetitan.modules.database.DatabaseModule;
import nl.minetitan.modules.fitness.FitnessModule;
import nl.minetitan.modules.player.PlayerModule;
import nl.minetitan.modules.plots.WorldGuardModule;
import nl.minetitan.modules.prefix.PrefixModule;

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
        BankingModule module2 = new BankingModule();
        PrefixModule module3 = new PrefixModule();
        FitnessModule module4 = new FitnessModule();
        WorldGuardModule module5 = new WorldGuardModule();

        // Starters
        module.start();
        module1.start();
        module2.start();
        module3.start();
        module4.start();
        module5.start();
    }

    @Override
    public void stop(){
        // Modules
        PlayerModule module = new PlayerModule(core);
        DatabaseModule module1 = new DatabaseModule();
        BankingModule module2 = new BankingModule();
        PrefixModule module3 = new PrefixModule();
        FitnessModule module4 = new FitnessModule();
        WorldGuardModule module5 = new WorldGuardModule();

        // Stoppers
        module.stop();
        module1.stop();
        module2.stop();
        module3.stop();
        module4.stop();
        module5.stop();
    }

}
