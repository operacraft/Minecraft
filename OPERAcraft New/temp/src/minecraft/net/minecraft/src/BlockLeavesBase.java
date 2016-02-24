package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;

public class BlockLeavesBase extends Block {

   protected boolean field_72131_c;


   protected BlockLeavesBase(int p_i9098_1_, Material p_i9098_2_, boolean p_i9098_3_) {
      super(p_i9098_1_, p_i9098_2_);
      this.field_72131_c = p_i9098_3_;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_) {
      int var6 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_);
      return !this.field_72131_c && var6 == this.field_71990_ca?false:super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_);
   }
}
