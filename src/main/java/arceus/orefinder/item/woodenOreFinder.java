package arceus.orefinder.item;

import arceus.orefinder.handler.ConfigurationHandler;
import arceus.orefinder.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static arceus.orefinder.handler.ConfigurationHandler.ore_list;


public class woodenOreFinder extends arcItem {

    private Random arcRandom = new Random();

    private boolean ore = false;

    public woodenOreFinder() {

        super();
        this.setUnlocalizedName(Names.Items.woodenoreFinder);
        this.setMaxStackSize(1);
        this.setMaxDamage(100);

    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (world.isRemote) {

            return true;

        } else {

            itemstack.damageItem(1, player);
            if (ConfigurationHandler.do_rng) {

                byte rng = (byte) arcRandom.nextInt(ConfigurationHandler.wooned_rng);
                System.out.println(rng);

                if (rng == 1) {

                    player.addChatMessage(new ChatComponentTranslation("msg.ore_found.txt"));
                    //System.out.println("ore hype !!!!");
                    return true;

                }

                if (rng == 2) {

                    player.addChatMessage(new ChatComponentTranslation("msg.no_ore_found.txt"));
                    //System.out.println("no ore ._.");
                    return true;

                }

            }

            ore = false;
            loop:
            for (byte i = (byte) -ConfigurationHandler.wooned_ore_finder_size; i < ConfigurationHandler.wooned_ore_finder_size; i++) {

                Block blockX;

                if (i == 0) {

                    blockX = world.getBlock(x + i, y, z);

                    for (byte k = 0; k < ore_list.length; k++) {

                        System.out.println(blockX.getUnlocalizedName());

                        if (blockX.getUnlocalizedName().contains(ore_list[k])) {

                            ore = true;
                            break loop;
                            //tile.grass  tile.stone
                        }

                    }

                } else {

                    blockX = world.getBlock(x + i, y, z);
                    for (byte k = 0; k < ore_list.length; k++) {

                        if (blockX.getUnlocalizedName().contains(ore_list[k])) {
                            ore = true;
                            break loop;

                        }

                    }

                    Block blockZ = world.getBlock(x, y, z + i);
                    for (byte k = 0; k < ore_list.length; k++) {

                        if (blockZ.getUnlocalizedName().contains(ore_list[k])) {
                            ore = true;
                            break loop;

                        }

                    }

                    Block blockY = world.getBlock(x, y + i, z);
                    for (byte k = 0; k < ore_list.length; k++) {

                        if (blockY.getUnlocalizedName().contains(ore_list[k])) {
                            ore = true;
                            break loop;

                        }

                    }

                }

            }

            if (ore) {

                player.addChatMessage(new ChatComponentTranslation("msg.ore_found.txt"));
                //System.out.println("ore = " + ore);
                return true;

            } else {

                player.addChatMessage(new ChatComponentTranslation("msg.no_ore_found.txt"));
                //System.out.println("no ore");
                return true;


            }
        }
    }
}
