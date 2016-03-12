package arceus.orefinder.block;

import arceus.orefinder.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import zero9010.orefinder.creativetab.creativeTab;

/**
 * Created by Arceusthepokemon on 1/3/2015.
 */
public class BlockMO extends Block {

    public BlockMO(Material materital) {

        super(materital);
        //setCreativeTab(creativeTab.miscobjects);

    }

    public BlockMO() {

        this(Material.iron);
        //setCreativeTab(creativeTab.miscobjects);

    }

    @Override
    public String getUnlocalizedName() {

        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));

    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);

    }
}
