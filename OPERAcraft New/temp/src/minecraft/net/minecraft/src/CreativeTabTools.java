package net.minecraft.src;

import java.util.List;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumEnchantmentType;
import net.minecraft.src.Item;

final class CreativeTabTools extends CreativeTabs {

   CreativeTabTools(int p_i3640_1_, String p_i3640_2_) {
      super(p_i3640_1_, p_i3640_2_);
   }

   public int func_78012_e() {
      return Item.field_77708_h.field_77779_bT;
   }

   public void func_78018_a(List p_78018_1_) {
      super.func_78018_a(p_78018_1_);
      this.func_92116_a(p_78018_1_, new EnumEnchantmentType[]{EnumEnchantmentType.digger});
   }
}
