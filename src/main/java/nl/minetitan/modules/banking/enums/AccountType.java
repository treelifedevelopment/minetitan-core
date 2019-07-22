package nl.minetitan.modules.banking.enums;
/*
Door: Maiky
Package: nl.minetitan.modules.banking.enums in de class AccountType.
*/

import org.bukkit.Material;

public enum AccountType {

    PERSONAL(Material.GOLD_BLOCK),
    BUISNESS(Material.DIAMOND_BLOCK),
    SAVINGS(Material.REDSTONE_BLOCK);

    private Material item;

    AccountType(Material item){
        this.item = item;
    }

    public Material getItem(){
        return this.item;
    }

}
