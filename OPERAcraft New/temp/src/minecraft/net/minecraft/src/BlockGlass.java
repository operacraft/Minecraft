package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockGlass extends BlockBreakable {

   public BlockGlass(int p_i9057_1_, Material p_i9057_2_, boolean p_i9057_3_) {
      super(p_i9057_1_, "glass", p_i9057_2_, p_i9057_3_);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71925_a(Random p_71925_1_) {
      return 0;
   }

   public int func_71856_s_() {
      return 0;
   }

   public boolean func_71926_d() {
      return false;
   }

   public boolean func_71886_c() {
      return false;
   }

   protected boolean func_71906_q_() {
      return true;
   }
}
