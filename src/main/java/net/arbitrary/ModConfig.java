package net.arbitrary;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "arbitrary")
public class ModConfig implements ConfigData {
    public String pretense = "";
}