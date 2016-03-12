package arceus.orefinder.creativetab;

import arceus.orefinder.init.initItem;
import arceus.orefinder.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class creativeTab {

    public static final CreativeTabs orefinder = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {

            return initItem.woodenoreFinder;

        }

        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel() {
            return StatCollector.translateToLocal("key.categories.orefinder");
        }

    };

}
