package arceus.orefinder;

import arceus.orefinder.handler.ConfigurationHandler;
import arceus.orefinder.init.craftingRecipes;
import arceus.orefinder.init.initItem;
import arceus.orefinder.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI)
public class OreFinder {

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        initItem.init();
        craftingRecipes.init();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {


    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {


    }

}
