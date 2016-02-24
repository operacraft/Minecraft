package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.ModLoader;

public class EntityRendererProxy extends EntityRenderer {

   private Minecraft game;


   public EntityRendererProxy(Minecraft var1) {
      super(var1);
      this.game = var1;
   }

   public void func_78480_b(float var1) {
      super.func_78480_b(var1);
      ModLoader.onTick(var1, this.game);
   }
}
