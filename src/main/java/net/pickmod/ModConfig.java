package net.pickmod;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "pickmod")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean dummy = false;
}