package net.minecraft.src;

import net.minecraft.src.EntityFireworkRocket;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemFirework extends Item {

   public ItemFirework(int p_i8013_1_) {
      super(p_i8013_1_);
   }

   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
      if(!p_77648_3_.field_72995_K) {
         EntityFireworkRocket var11 = new EntityFireworkRocket(p_77648_3_, (double)((float)p_77648_4_ + p_77648_8_), (double)((float)p_77648_5_ + p_77648_9_), (double)((float)p_77648_6_ + p_77648_10_), p_77648_1_);
         p_77648_3_.func_72838_d(var11);
         if(!p_77648_2_.field_71075_bZ.field_75098_d) {
            --p_77648_1_.field_77994_a;
         }

         return true;
      } else {
         return false;
      }
   }
}
