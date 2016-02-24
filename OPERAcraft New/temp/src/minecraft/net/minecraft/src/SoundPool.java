package net.minecraft.src;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.SoundPoolEntry;

public class SoundPool {

   private Random field_77464_c = new Random();
   private Map field_77461_d = new HashMap();
   private List field_77462_e = new ArrayList();
   public int field_77465_a = 0;
   public boolean field_77463_b = true;


   public SoundPoolEntry func_77459_a(String p_77459_1_, File p_77459_2_) {
      try {
         return this.addSound(p_77459_1_, p_77459_2_.toURI().toURL());
      } catch (MalformedURLException var4) {
         var4.printStackTrace();
         throw new RuntimeException(var4);
      }
   }

   public SoundPoolEntry addSound(String var1, URL var2) {
      String var3 = var1;
      var1 = var1.substring(0, var1.indexOf("."));
      if(this.field_77463_b) {
         while(Character.isDigit(var1.charAt(var1.length() - 1))) {
            var1 = var1.substring(0, var1.length() - 1);
         }
      }

      var1 = var1.replaceAll("/", ".");
      if(!this.field_77461_d.containsKey(var1)) {
         this.field_77461_d.put(var1, new ArrayList());
      }

      SoundPoolEntry var4 = new SoundPoolEntry(var3, var2);
      ((List)this.field_77461_d.get(var1)).add(var4);
      this.field_77462_e.add(var4);
      ++this.field_77465_a;
      return var4;
   }

   public SoundPoolEntry func_77458_a(String p_77458_1_) {
      List var2 = (List)this.field_77461_d.get(p_77458_1_);
      return var2 == null?null:(SoundPoolEntry)var2.get(this.field_77464_c.nextInt(var2.size()));
   }

   public SoundPoolEntry func_77460_a() {
      return this.field_77462_e.isEmpty()?null:(SoundPoolEntry)this.field_77462_e.get(this.field_77464_c.nextInt(this.field_77462_e.size()));
   }
}
