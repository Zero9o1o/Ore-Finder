package arceus.orefinder.handler;

import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
    public static Configuration Configuration;
    public static Boolean do_rng;
    public static byte wooned_ore_finder_size;
    public static byte wooned_rng;
    public static String[] ore_list;
    private static String[] oresIKnowOF = {"tile.oreCoal","tile.oreIron","tile.oreGold","tile.oreDiamond","tile.oreEmerald","tile.oreRedstone","tile.netherquartz"};

    public ConfigurationHandler() {
    }

    public static void init(File configFile) {
        if(Configuration == null) {
            Configuration = new Configuration(configFile);
            loadConfiguration();
        }
        loadConfiguration();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(OnConfigChangedEvent event) {
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }

    }

    private static void loadConfiguration() {
        Configuration var10002 = Configuration;
        do_rng = Configuration.getBoolean("do_rng", "general", true, "false positive and false negative true on false off");
        wooned_ore_finder_size = (byte) Configuration.getInt("wooden_ore_finder-Size", "general",5,1,20,"how big of it too look for ores");
        wooned_rng = (byte) Configuration.getInt("wooden_rng", "general",3,3,127,"rng on false positive and false negative");
        ore_list =  Configuration.getStringList("orenames","ores",oresIKnowOF,"list of all the Unlocalized Names of ores in the pack ");
        if(Configuration.hasChanged()) {
            Configuration.save();
        }

    }
}
