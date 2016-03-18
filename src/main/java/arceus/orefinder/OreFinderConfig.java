package arceus.orefinder;

import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class OreFinderConfig {
    public static Configuration config;

    public static String GENERAL = "general";
    public static String WOODEN = "wooden";

    public static Boolean doRandomResult;
    public static Boolean doWoodenFalsePositive;

    public static byte woodenSize;
//    public static byte iron_ore_finder_size;

    public static float woodenChance;
//    public static float iron_chance_false_result;

    public OreFinderConfig(){

    }

    public static void init(File configFile){
        if (config == null){
            config = new Configuration(configFile);
            loadFromConfig();
        }

        loadFromConfig();
    }

    private static void loadFromConfig(){
        doRandomResult = config.getBoolean("doRandomResult", GENERAL, true,  "If false disables all false result features");

        woodenChance = config.getFloat("woodenChance", WOODEN, 0.80f, 0.0f, 1.0f, "The chance for wooden prospecting tool to return a false result");
        woodenSize = (byte) config.getInt("woodenSize", WOODEN, 5, 1, 100, "The size of the area that the wooden prospecting tool scans");
        doWoodenFalsePositive = config.getBoolean("doWoodenFalsePositive", WOODEN, true, "Enables wooden prospecting tool to return false positives");

//        iron_chance_false_result = config.getFloat("chance_of_false_result", "iron", 0.60f, 0.0f, 1.0f, "The chance of getting a false result");
//        iron_ore_finder_size = (byte) config.getInt("ore_finder-Size", "iron", 5, 1, 100, "The length on each axis to scan for ores");

        if (config.hasChanged()){
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event) {

        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {

            loadFromConfig();

        }

    }
}
