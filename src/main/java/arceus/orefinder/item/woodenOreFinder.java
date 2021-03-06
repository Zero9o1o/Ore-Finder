package arceus.orefinder.item;

import arceus.orefinder.OreFinderConfig;
import arceus.orefinder.item.world.oreFinderChunk;
import arceus.orefinder.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class woodenOreFinder extends prospectorTool {

    private oreFinderChunk oreChunk;
    private boolean ore = false;

    public woodenOreFinder() {
        super();
        this.setUnlocalizedName(Names.Items.woodenoreFinder);
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (world.isRemote) {

            return true;

        } else {

            itemstack.damageItem(1, player);

            if (oreChunk == null) {

                oreChunk = new oreFinderChunk(world.getChunkFromBlockCoords(x, z).getChunkCoordIntPair(), rng(OreFinderConfig.woodenChance));

            } else if (oreChunk.var1 == -1) {

                oreChunk.var1 = rng(OreFinderConfig.woodenChance);

            } else if (!oreChunk.chunkXZ.equals(world.getChunkFromBlockCoords(x, z).getChunkCoordIntPair())) {

                oreChunk = new oreFinderChunk(world.getChunkFromBlockCoords(x, z).getChunkCoordIntPair(), rng(OreFinderConfig.woodenChance));

            }

            if (oreChunk.var1 == 1) {

                player.addChatMessage(new ChatComponentTranslation("msg.no_ore_found.txt"));
                System.out.println("false negative");

            } else if (OreFinderConfig.doWoodenFalsePositive && oreChunk.var1 == 2) {

                player.addChatMessage(new ChatComponentTranslation("msg.ore_found.txt"));
                System.out.println("false positive");

            } else {

                ore = false;
                for (byte i = (byte) -OreFinderConfig.woodenSize; i < OreFinderConfig.woodenSize; i++) {

                    Block blockX;

                    if (i == 0) {

                        blockX = world.getBlock(x + i, y, z);

                        System.out.println(blockX.getUnlocalizedName());

                        if (blockX.getUnlocalizedName().contains("ore") || blockX.getUnlocalizedName().contains("Ore")) {

                            ore = true;
                            break;
                        }

                    } else {

                        blockX = world.getBlock(x + i, y, z);
                        if (blockX.getUnlocalizedName().contains("ore") || blockX.getUnlocalizedName().contains("Ore")) {

                            ore = true;
                            break;
                        }

                        Block blockZ = world.getBlock(x, y, z + i);

                        if (blockZ.getUnlocalizedName().contains("ore") || blockZ.getUnlocalizedName().contains("Ore")) {
                            ore = true;
                            break;

                        }

                        Block blockY = world.getBlock(x, y + i, z);

                        if (blockY.getUnlocalizedName().contains("ore") || blockY.getUnlocalizedName().contains("Ore")) {
                            ore = true;
                            break;

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

        return false;
    }
}
