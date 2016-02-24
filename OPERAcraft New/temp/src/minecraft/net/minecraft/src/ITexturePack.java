package net.minecraft.src;

import java.io.IOException;
import java.io.InputStream;
import net.minecraft.src.RenderEngine;

public interface ITexturePack {

   void func_77533_a(RenderEngine var1);

   void func_77535_b(RenderEngine var1);

   InputStream func_98137_a(String var1, boolean var2) throws IOException;

   InputStream func_77532_a(String var1) throws IOException;

   String func_77536_b();

   String func_77538_c();

   String func_77531_d();

   String func_77537_e();

   boolean func_98138_b(String var1, boolean var2);

   boolean func_94179_g();
}
