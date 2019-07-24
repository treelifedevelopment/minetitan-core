package nl.minetitan.handler.enums;
/*
Door: Maiky
Package: nl.minetitan.handler.enums in de class Chatkleur.
*/

import lombok.Getter;

public enum Chatkleur {

    RESET("&7", 7),
    WIT("&f", 0),
    BLAUW("&9", 3),
    DONKER_BLAUW("&1", 11),
    LICHT_BLAUW("&b", 3),
    DONKER_ROOD("&4", 14),
    ROOD("&c", 14),
    GEEL("&e", 4),
    ORANJE("&6", 1),
    DONKER_GRIJS("&8", 15),
    LICHT_GROEN("&a", 5),
    DONKER_GROEN("&2", 13),
    PAARS("&5", 10),
    ROZE("&d", 2);

    @Getter
    private String s;
    @Getter
    private int durability;

    Chatkleur(String s, int dura){
        this.s = s;
        this.durability = dura;
    }

}
