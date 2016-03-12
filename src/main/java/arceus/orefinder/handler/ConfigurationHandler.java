package arceus.orefinder.handler;

import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration Configuration;
    public static Boolean do_rng;
    public static byte wooned_ore_finder_size;
    public static Float wooned_rng2;

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

        Configuration var10002 = Configuration;

        //wooden ore finder
        do_rng = Configuration.getBoolean("false_p/g", "wooden", true, "do false positive and false negative. ");
        wooned_ore_finder_size = (byte) Configuration.getInt("ore_finder-Size", "wooden", 5, 1, 100, "how long in each axis to look for ores");
        wooned_rng2 = Configuration.getFloat("chance_of_p/n", "wooden", 0.66f, 0.0f, 1.0f, "chance of geting a false positive or false negative.");

        //

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
