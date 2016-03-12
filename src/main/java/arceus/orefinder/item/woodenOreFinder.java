package arceus.orefinder.item;

import arceus.orefinder.handler.ConfigurationHandler;
import arceus.orefinder.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.Random;

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

                float rng = arcRandom.nextFloat();
                System.out.println(rng);

                if (rng <= ConfigurationHandler.wooned_rng2 / 2) {

                    player.addChatMessage(new ChatComponentTranslation("msg.ore_found.txt"));
                    return true;

                }

                if (rng <= ConfigurationHandler.wooned_rng2 ) {

                    player.addChatMessage(new ChatComponentTranslation("msg.no_ore_found.txt"));
                    return true;

                }
            }

            ore = false;
            for (byte i = (byte) -ConfigurationHandler.wooned_ore_finder_size; i < ConfigurationHandler.wooned_ore_finder_size; i++) {

                Block blockX;

                if (i == 0) {

                    blockX = world.getBlock(x + i, y, z);

                    System.out.println(blockX.getUnlocalizedName());

                    if (blockX.getUnlocalizedName().contains("ore") || blockX.getUnlocalizedName().contains("Ore")) {

                        ore = true;
                    }

                } else {

                    blockX = world.getBlock(x + i, y, z);
                    if (blockX.getUnlocalizedName().contains("ore") || blockX.getUnlocalizedName().contains("Ore")) {

                        ore = true;
                    }

                    Block blockZ = world.getBlock(x, y, z + i);

                    if (blockZ.getUnlocalizedName().contains("ore") || blockZ.getUnlocalizedName().contains("Ore")) {
                        ore = true;

                    }

                    Block blockY = world.getBlock(x, y + i, z);

                    if (blockY.getUnlocalizedName().contains("ore") || blockY.getUnlocalizedName().contains("Ore")) {
                        ore = true;

                    }
                }
            }

            if (ore) {

                player.addChatMessage(new ChatComponentTranslation("msg.ore_found.txt"));
                return true;

            } else {

                player.addChatMessage(new ChatComponentTranslation("msg.no_ore_found.txt"));
                return true;

            }
        }
    }
}
