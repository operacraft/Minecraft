package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockWood extends Block {

   public static final String[] field_72152_a = new String[]{"oak", "spruce", "birch", "jungle"};
   public static final String[] field_94386_b = new String[]{"wood", "wood_spruce", "wood_birch", "wood_jungle"};


   public BlockWood(int p_i4023_1_) {
      super(p_i4023_1_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

}
