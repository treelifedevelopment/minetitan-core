package nl.minetitan.modules.database;
/*
Door: Maiky
Package: nl.minetitan.modules.database in de class DatabaseModule.
*/

import nl.minetitan.modules.MinetopiaModule;
import nl.minetitan.sql.SQLManager;

public class DatabaseModule implements MinetopiaModule {

    @Override
    public void start() {
        SQLManager manager = new SQLManager();

        manager.createArchiveTable();
        manager.createBankingTable();
        manager.createTimeInfoTable();
        manager.createUserTable();
        manager.createPrefixTable();
        manager.createInventoryTable();
    }

    @Override
    public void stop() {

    }
}
