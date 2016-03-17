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

    public static byte woodenSize;
    public static byte iron_ore_finder_size;

    public static float woodenChance;
    public static float iron_chance_false_result;

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
        doRandomResult = config.getBoolean("doRandomResult", GENERAL, true, I18n.format("orefinder:config.doRandomResult.tooltip"), "orefinder:config.doRandomResult");

        woodenChance = config.getFloat("woodenChance", WOODEN, 0.80f, 0.0f, 1.0f, I18n.format("orefinder:config.woodenChance.tooltip"), "orefinder:config.woodenChance");
        woodenSize = (byte) config.getInt("woodenSize", WOODEN, 5, 1, 100, I18n.format("orefinder:config.woodenSize.tooltip"), "orefinder:config.woodenSize");

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
