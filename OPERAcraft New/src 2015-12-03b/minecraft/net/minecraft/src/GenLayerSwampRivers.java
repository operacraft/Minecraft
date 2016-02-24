package net.minecraft.src;

public class GenLayerSwampRivers extends GenLayer
{
    public GenLayerSwampRivers(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        this.parent = par3GenLayer;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] var5 = this.parent.getInts(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
        int[] var6 = IntCache.getIntCache(par3 * par4);

        for (int var7 = 0; var7 < par4; ++var7)
        {
            for (int var8 = 0; var8 < par3; ++var8)
            {
                this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
                int var9 = var5[var8 + 1 + (var7 + 1) * (par3 + 2)];

                if ((var9 != BiomeGenBase.swampland.biomeID || this.nextInt(6) != 0) && (var9 != BiomeGenBase.jungle.biomeID && var9 != BiomeGenBase.jungleHills.biomeID || this.nextInt(8) != 0))
                {
                    var6[var8 + var7 * par3] = var9;
                }
                else
                {
                    var6[var8 + var7 * par3] = BiomeGenBase.river.biomeID;
                }
            }
        }

        return var6;
    }
}
