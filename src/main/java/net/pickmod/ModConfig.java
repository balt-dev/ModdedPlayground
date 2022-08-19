package net.pickmod;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "pickmod")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean showChest = true;
    @ConfigEntry.Gui.Tooltip
    public boolean showLock = true;
    @ConfigEntry.Gui.Tooltip
    public boolean disableUnackedError = true;
}