package arceus.orefinder.item.world;

import net.minecraft.world.ChunkCoordIntPair;

public class oreFinderChunk {

    public ChunkCoordIntPair chunkXZ;
    public byte var1;

    public oreFinderChunk(ChunkCoordIntPair CHUNK_XZ,byte VAR_1 ){

        this.chunkXZ = CHUNK_XZ;
        this.var1 = VAR_1;

    }
}
