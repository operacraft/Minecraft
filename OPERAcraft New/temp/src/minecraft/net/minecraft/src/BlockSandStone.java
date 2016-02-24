package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Icon;
import net.minecraft.src.IconRegister;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockSandStone extends Block {

   public static final String[] field_72189_a = new String[]{"default", "chiseled", "smooth"};
   private static final String[] field_94405_b = new String[]{"sandstone_side", "sandstone_carved", "sandstone_smooth"};
   private Icon[] field_94406_c;
   private Icon field_94403_cO;
   private Icon field_94404_cP;


   public BlockSandStone(int p_i3990_1_) {
      super(p_i3990_1_, Material.field_76246_e);
      this.func_71849_a(CreativeTabs.field_78030_b);
   }

   public Icon func_71858_a(int p_71858_1_, int p_71858_2_) {
      if(p_71858_1_ != 1 && (p_71858_1_ != 0 || p_71858_2_ != 1 && p_71858_2_ != 2)) {
         if(p_71858_1_ == 0) {
            return this.field_94404_cP;
         } else {
            if(p_71858_2_ < 0 || p_71858_2_ >= this.field_94406_c.length) {
               p_71858_2_ = 0;
            }

            return this.field_94406_c[p_71858_2_];
         }
      } else {
         return this.field_94403_cO;
      }
   }

   public int func_71899_b(int p_71899_1_) {
      return p_71899_1_;
   }

   public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_) {
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
      p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
   }

   public void func_94332_a(IconRegister p_94332_1_) {
      this.field_94406_c = new Icon[field_94405_b.length];

      for(int var2 = 0; var2 < this.field_94406_c.length; ++var2) {
         this.field_94406_c[var2] = p_94332_1_.func_94245_a(field_94405_b[var2]);
      }

      this.field_94403_cO = p_94332_1_.func_94245_a("sandstone_top");
      this.field_94404_cP = p_94332_1_.func_94245_a("sandstone_bottom");
   }

}
