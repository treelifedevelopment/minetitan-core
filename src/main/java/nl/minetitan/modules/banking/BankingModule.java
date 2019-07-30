package nl.minetitan.modules.banking;
/*
Door: Maiky
Package: nl.minetitan.modules.banking in de class BankingModule.
*/

import nl.minetitan.Core;
import nl.minetitan.handler.CommandHandler;
import nl.minetitan.modules.MinetopiaModule;
import nl.minetitan.modules.banking.commands.BankingCommand;
import nl.minetitan.modules.banking.commands.PinCommand;
import nl.minetitan.modules.banking.listeners.BankAccountListener;
import nl.minetitan.modules.banking.listeners.BankListener;
import nl.minetitan.modules.banking.listeners.PinListener;
import nl.minetitan.modules.banking.listeners.PinpasListener;

public class BankingModule implements MinetopiaModule {

    @Override
    public void start() {
        CommandHandler handler = new CommandHandler();
        handler.register("banking", new BankingCommand());
        handler.register("pin", new PinCommand());

        Core.getInstance().getServer().getPluginManager().registerEvents(new BankListener(), Core.getInstance());
        Core.getInstance().getServer().getPluginManager().registerEvents(new BankAccountListener(), Core.getInstance());
        Core.getInstance().getServer().getPluginManager().registerEvents(new PinpasListener(), Core.getInstance());
        Core.getInstance().getServer().getPluginManager().registerEvents(new PinListener(), Core.getInstance());
    }

    @Override
    public void stop() {

    }
}
