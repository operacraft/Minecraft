package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockBreakable extends Block {

   private boolean field_72245_a;
   private String field_94430_b;


   protected BlockBreakable(int p_i9059_1_, String p_i9059_2_, Material p_i9059_3_, boolean p_i9059_4_) {
      super(p_i9059_1_, p_i9059_3_);
      this.field_72245_a = p_i9059_4_;
      this.field_94430_b = p_i9059_2_;
   }

   public boolean func_71926_d() {
      return false;
   }
}
