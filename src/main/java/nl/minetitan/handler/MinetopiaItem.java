package nl.minetitan.handler;
/*
Door: Maiky
Package: nl.minetitan.handler in de class MinetopiaItem.
*/

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MinetopiaItem {

    private Material material;

    public MinetopiaItem(Material material){
        this.material = material;
    }

    public ItemStack createItem(){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList("Officieel MineTopia Item"));
        item.setItemMeta(meta);
        return item;
    }

}
