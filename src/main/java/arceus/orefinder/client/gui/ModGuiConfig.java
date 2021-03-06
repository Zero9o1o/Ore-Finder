package arceus.orefinder.client.gui;

import arceus.orefinder.OreFinderConfig;
import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;


public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen) {
        super(guiScreen, (new ConfigElement(OreFinderConfig.config.getCategory("general"))).getChildElements(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(OreFinderConfig.config.toString()));
    }
}