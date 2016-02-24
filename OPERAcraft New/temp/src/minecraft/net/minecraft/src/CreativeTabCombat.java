package net.minecraft.src;

import java.util.List;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumEnchantmentType;
import net.minecraft.src.Item;

final class CreativeTabCombat extends CreativeTabs {

   CreativeTabCombat(int p_i3641_1_, String p_i3641_2_) {
      super(p_i3641_1_, p_i3641_2_);
   }

   public int func_78012_e() {
      return Item.field_77672_G.field_77779_bT;
   }

   public void func_78018_a(List p_78018_1_) {
      super.func_78018_a(p_78018_1_);
      this.func_92116_a(p_78018_1_, new EnumEnchantmentType[]{EnumEnchantmentType.armor, EnumEnchantmentType.armor_feet, EnumEnchantmentType.armor_head, EnumEnchantmentType.armor_legs, EnumEnchantmentType.armor_torso, EnumEnchantmentType.bow, EnumEnchantmentType.weapon});
   }
}
