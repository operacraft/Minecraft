package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Icon;
import net.minecraft.src.IconRegister;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockWood extends Block {

   public static final String[] field_72152_a = new String[]{"oak", "spruce", "birch", "jungle"};
   public static final String[] field_94386_b = new String[]{"wood", "wood_spruce", "wood_birch", "wood_jungle"};
   private Icon[] field_94387_c;


   public BlockWood(int p_i4023_1_) {
      super(p_i4023_1_, Material.field_76245_d);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_2_ < 0 || p_71858_2_ >= this.field_94387_c.length) {
         p_71858_2_ = 0;
      }

      return this.field_94387_c[p_71858_2_];
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 3));
   }

   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94387_c = new Icon[field_94386_b.length];

      for(int var2 = 0; var2 < this.field_94387_c.length; ++var2) {
         this.field_94387_c[var2] = p_94332_1_.func_94245_a(field_94386_b[var2]);
      }

   }

}
