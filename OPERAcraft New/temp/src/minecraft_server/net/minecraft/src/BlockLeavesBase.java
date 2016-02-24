package net.minecraft.src;

import net.minecraft.src.Block;
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
}
