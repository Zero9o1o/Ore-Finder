package arceus.orefinder.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class craftingRecipes {

    public static void init() {

        GameRegistry.addRecipe(new ItemStack(((initItem.woodenoreFinder)), 1), new Object[]{"xx ", " /x", " / ", '/', Items.stick, 'x', Blocks.log});

    }
}
