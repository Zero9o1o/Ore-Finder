package arceus.orefinder;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class OreFinderConfig {
    public static final String GENERAL = "general";
    public static final String WOODEN = "wooden";

    public static Configuration config;
    public static File configFile;

    public static Boolean doRandomResult;

    public static byte woodenSize;
    public static byte iron_ore_finder_size;

    public static float woodenChance;
    public static float iron_chance_false_result;

    public static void loadFromFile(File configFile) {
        OreFinderConfig.configFile = configFile;
        config = new Configuration(configFile);
        loadFromConfig();
    }

    private static void loadFromConfig(){
        doRandomResult = config.getBoolean("doRandomResult", GENERAL, true, I18n.format("orefinder:config.doRandomResult.tooltip"), "orefinder:config.doRandomResult");

        woodenChance = config.getFloat("woodenChance", WOODEN, 0.80f, 0.0f, 1.0f, I18n.format("orefinder:config.woodenChance.tooltip"), "orefinder:config.woodenChance");
        woodenSize = (byte) config.getInt("woodenSize", WOODEN, 5, 1, 100, I18n.format("orefinder:config.woodenSize.tooltip"), "orefinder:config.woodenSize");

//        iron_chance_false_result = config.getFloat("chance_of_false_result", "iron", 0.60f, 0.0f, 1.0f, "The chance of getting a false result");
//        iron_ore_finder_size = (byte) config.getInt("ore_finder-Size", "iron", 5, 1, 100, "The length on each axis to scan for ores");

        config.save();
    }

    public static void lightReload() {
        loadFromConfig();
    }

    public static void hardReload() {
        loadFromFile(configFile);
    }
}
