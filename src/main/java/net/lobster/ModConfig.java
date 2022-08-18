package net.lobster;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "lobster")
public class ModConfig implements ConfigData {
    @ConfigEntry.BoundedDiscrete(min=0,max=100)
    public int showChance = 100;
}