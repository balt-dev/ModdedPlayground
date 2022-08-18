package net.yummy;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "modid")
public class ModConfig implements ConfigData {
    public boolean toggleA = true;
    public boolean toggleB = false;

    @ConfigEntry.Gui.CollapsibleObject
    public InnerStuff stuff = new InnerStuff();

    @ConfigEntry.Gui.Excluded
    public InnerStuff invisibleStuff = new InnerStuff();

    static class InnerStuff {
        int a = 0;
        int b = 1;
    }
}