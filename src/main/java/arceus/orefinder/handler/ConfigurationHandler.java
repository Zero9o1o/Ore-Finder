package arceus.orefinder.handler;

import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration Configuration;

    public static Boolean do_random_false_results;

    public static byte wooded_ore_finder_size;
    public static byte iron_ore_finder_size;

    public static float wooded_chance_false_result;
    public static float iron_chance_false_result;

    public ConfigurationHandler() {
    }

    public static void init(File configFile) {

        if (Configuration == null) {

            Configuration = new Configuration(configFile);
            loadConfiguration();

        }

        loadConfiguration();

    }

    private static void loadConfiguration() {

        //Configuration var10002 = Configuration;

        //wooden ore finder
        do_random_false_results = Configuration.getBoolean("enable_false_result", "general", true, "If true then false results are enabled.");

        wooded_chance_false_result = Configuration.getFloat("chance_of_false_result", "wooden", 0.80f, 0.0f, 1.0f, "The chance of getting a false result");
        wooded_ore_finder_size = (byte) Configuration.getInt("ore_finder-Size", "wooden", 5, 1, 100, "The length on each axis to scan for ores");

        iron_chance_false_result = Configuration.getFloat("chance_of_false_result", "iron", 0.60f, 0.0f, 1.0f, "The chance of getting a false result");
        iron_ore_finder_size = (byte) Configuration.getInt("ore_finder-Size", "iron", 5, 1, 100, "The length on each axis to scan for ores");

        if (Configuration.hasChanged()) {
            Configuration.save();
        }

    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(OnConfigChangedEvent event) {

        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {

            loadConfiguration();

        }

    }
}
