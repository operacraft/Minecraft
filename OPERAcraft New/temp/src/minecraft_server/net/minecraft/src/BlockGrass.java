package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockGrass extends Block {

   protected BlockGrass(int p_i3952_1_) {
      super(p_i3952_1_, Material.field_76247_b);
      this.func_71907_b(true);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_) {
      if(!p_71847_1_.field_72995_K) {
         if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) < 4 && Block.field_71971_o[p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ + 1, p_71847_4_)] > 2) {
            p_71847_1_.func_94575_c(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_71979_v.field_71990_ca);
         } else if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9) {
            for(int var6 = 0; var6 < 4; ++var6) {
               int var7 = p_71847_2_ + p_71847_5_.nextInt(3) - 1;
               int var8 = p_71847_3_ + p_71847_5_.nextInt(5) - 3;
               int var9 = p_71847_4_ + p_71847_5_.nextInt(3) - 1;
               int var10 = p_71847_1_.func_72798_a(var7, var8 + 1, var9);
               if(p_71847_1_.func_72798_a(var7, var8, var9) == Block.field_71979_v.field_71990_ca && p_71847_1_.func_72957_l(var7, var8 + 1, var9) >= 4 && Block.field_71971_o[var10] <= 2) {
                  p_71847_1_.func_94575_c(var7, var8, var9, Block.field_71980_u.field_71990_ca);
               }
            }
         }

      }
   }

   public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_) {
      return Block.field_71979_v.func_71885_a(0, p_71885_2_, p_71885_3_);
   }
}
