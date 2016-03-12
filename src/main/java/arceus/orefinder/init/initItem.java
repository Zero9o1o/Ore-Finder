package arceus.orefinder.init;

import arceus.orefinder.item.woodenOreFinder;
import arceus.orefinder.reference.Names;
import arceus.orefinder.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class initItem {

    public static final woodenOreFinder woodenoreFinder = new woodenOreFinder();

    public static void init() {

        GameRegistry.registerItem(woodenoreFinder, Names.Items.woodenoreFinder);

    }

}
