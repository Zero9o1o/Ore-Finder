package arceus.orefinder.client.gui;

import arceus.orefinder.OreFinderConfig;
import arceus.orefinder.reference.Reference;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen parentScreen) {
        super(parentScreen, getCategories(), Reference.MOD_ID, true, false , I18n.format("orefinder:gui.config.title"));
    }

    @SuppressWarnings("unchecked")
    private static List<IConfigElement> getCategories() {
        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyConfigElement.DummyCategoryElement(I18n.format("orefinder:config.category.general"), "orefinder:config.category.general", new ConfigElement(OreFinderConfig.config.getCategory(OreFinderConfig.GENERAL)).getChildElements()));
        list.add(new DummyConfigElement.DummyCategoryElement(I18n.format("orefinder:config.category.wooden"), "orefinder:config.category.wooden", new ConfigElement(OreFinderConfig.config.getCategory(OreFinderConfig.WOODEN)).getChildElements()));
        return list;
    }
}