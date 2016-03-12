package arceus.orefinder.client.gui;

import arceus.orefinder.client.gui.ModGuiConfig;
import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionCategoryElement;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionGuiHandler;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class GuiFactory implements IModGuiFactory {
    public GuiFactory() {
    }

    public void initialize(Minecraft minecraftInstance) {
    }

    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return ModGuiConfig.class;
    }

    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}