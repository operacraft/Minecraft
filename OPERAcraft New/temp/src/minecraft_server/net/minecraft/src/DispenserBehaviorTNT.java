package net.minecraft.src;

import net.minecraft.src.BehaviorDefaultDispenseItem;
import net.minecraft.src.BlockDispenser;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EnumFacing;
import net.minecraft.src.IBlockSource;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

final class DispenserBehaviorTNT extends BehaviorDefaultDispenseItem {

   protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
      EnumFacing var3 = BlockDispenser.func_100009_j_(p_82487_1_.func_82620_h());
      World var4 = p_82487_1_.func_82618_k();
      int var5 = p_82487_1_.func_82623_d() + var3.func_82601_c();
      int var6 = p_82487_1_.func_82622_e() + var3.func_96559_d();
      int var7 = p_82487_1_.func_82621_f() + var3.func_82599_e();
      EntityTNTPrimed var8 = new EntityTNTPrimed(var4, (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), (EntityLiving)null);
      var4.func_72838_d(var8);
      --p_82487_2_.field_77994_a;
      return p_82487_2_;
   }
}
