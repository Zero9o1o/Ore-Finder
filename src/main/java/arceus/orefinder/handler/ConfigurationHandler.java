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
    public static byte wooned_rng;

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
        do_rng = Configuration.getBoolean("do_rng", "general", true, "false positive and false negative true on false off");
        wooned_ore_finder_size = (byte) Configuration.getInt("wooden_ore_finder-Size", "general", 5, 1, 20, "how big of it too look for ores");
        wooned_rng = (byte) Configuration.getInt("wooden_rng", "general", 3, 3, 127, "rng on false positive and false negative");

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
