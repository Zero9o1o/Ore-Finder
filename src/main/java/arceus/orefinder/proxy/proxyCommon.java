package arceus.orefinder.proxy;

import arceus.orefinder.OreFinderConfig;
import arceus.orefinder.init.craftingRecipes;
import arceus.orefinder.init.initItem;
//import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class proxyCommon {

    public void preInit(FMLPreInitializationEvent event){
        OreFinderConfig.init(event.getSuggestedConfigurationFile());
//        FMLCommonHandler.instance().bus().register(new OreFinderConfig());

        initItem.init();
        craftingRecipes.init();
    }

    public void init(FMLInitializationEvent event) {


    }


    public void postInit(FMLPostInitializationEvent event) {


    }
}
