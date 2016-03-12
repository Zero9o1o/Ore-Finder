package arceus.orefinder.client.gui;

import arceus.orefinder.handler.ConfigurationHandler;
import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen) {

        super(guiScreen, (new ConfigElement(ConfigurationHandler.Configuration.getCategory("wooden"))).getChildElements(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.Configuration.toString()));

    }
}