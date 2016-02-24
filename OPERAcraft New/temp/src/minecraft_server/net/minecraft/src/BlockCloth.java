package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockCloth extends Block {

   public BlockCloth() {
      super(35, Material.field_76253_m);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

   public static int func_72238_e_(int p_72238_0_) {
      return ~p_72238_0_ & 15;
   }

   public static int func_72239_d(int p_72239_0_) {
      return ~p_72239_0_ & 15;
   }
}
