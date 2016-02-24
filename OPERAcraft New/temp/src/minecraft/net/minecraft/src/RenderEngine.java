package net.minecraft.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.IImageBuffer;
import net.minecraft.src.ITexturePack;
import net.minecraft.src.Icon;
import net.minecraft.src.IntHashMap;
import net.minecraft.src.TextureMap;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.ThreadDownloadImageData;
import org.lwjgl.opengl.GL11;

public class RenderEngine {

   private HashMap field_78362_c = new HashMap();
   private HashMap field_78359_d = new HashMap();
   private IntHashMap field_78360_e = new IntHashMap();
   private IntBuffer field_78358_g = GLAllocation.func_74527_f(4194304);
   private Map field_78368_i = new HashMap();
   private GameSettings field_78365_j;
   private TexturePackList field_78366_k;
   private BufferedImage field_78364_l = new BufferedImage(64, 64, 2);
   private final TextureMap field_94154_l;
   private final TextureMap field_94155_m;
   private int field_94153_n;


   public RenderEngine(TexturePackList p_i3192_1_, GameSettings p_i3192_2_) {
      this.field_78366_k = p_i3192_1_;
      this.field_78365_j = p_i3192_2_;
      Graphics var3 = this.field_78364_l.getGraphics();
      var3.setColor(Color.WHITE);
      var3.fillRect(0, 0, 64, 64);
      var3.setColor(Color.BLACK);
      int var4 = 10;
      int var5 = 0;

      while(var4 < 64) {
         String var6 = var5++ % 2 == 0?"missing":"texture";
         var3.drawString(var6, 1, var4);
         var4 += var3.getFont().getSize();
         if(var5 % 2 == 0) {
            var4 += 5;
         }
      }

      var3.dispose();
      this.field_94154_l = new TextureMap(0, "terrain", "textures/blocks/", this.field_78364_l);
      this.field_94155_m = new TextureMap(1, "items", "textures/items/", this.field_78364_l);
   }

   public int[] func_78346_a(String p_78346_1_) {
      ITexturePack var2 = this.field_78366_k.func_77292_e();
      int[] var3 = (int[])((int[])this.field_78359_d.get(p_78346_1_));
      if(var3 != null) {
         return var3;
      } else {
         int[] var5;
         try {
            InputStream var4 = var2.func_77532_a(p_78346_1_);
            if(var4 == null) {
               var5 = this.func_78348_b(this.field_78364_l);
            } else {
               var5 = this.func_78348_b(this.func_78345_a(var4));
            }

            this.field_78359_d.put(p_78346_1_, var5);
            return var5;
         } catch (IOException var6) {
            var6.printStackTrace();
            var5 = this.func_78348_b(this.field_78364_l);
            this.field_78359_d.put(p_78346_1_, var5);
            return var5;
         }
      }
   }

   private int[] func_78348_b(BufferedImage p_78348_1_) {
      return this.func_78340_a(p_78348_1_, new int[p_78348_1_.getWidth() * p_78348_1_.getHeight()]);
   }

   private int[] func_78340_a(BufferedImage p_78340_1_, int[] p_78340_2_) {
      int var3 = p_78340_1_.getWidth();
      int var4 = p_78340_1_.getHeight();
      p_78340_1_.getRGB(0, 0, var3, var4, p_78340_2_, 0, var3);
      return p_78340_2_;
   }

   public void func_98187_b(String p_98187_1_) {
      this.func_78342_b(this.func_78341_b(p_98187_1_));
   }

   private void func_78342_b(int p_78342_1_) {
      if(p_78342_1_ != this.field_94153_n) {
         GL11.glBindTexture(3553, p_78342_1_);
         this.field_94153_n = p_78342_1_;
      }

   }

   public void func_98185_a() {
      this.field_94153_n = -1;
   }

   public int func_78341_b(String p_78341_1_) {
      if(p_78341_1_.equals("/terrain.png")) {
         this.field_94154_l.func_94246_d().func_94277_a(0);
         return this.field_94154_l.func_94246_d().func_94282_c();
      } else if(p_78341_1_.equals("/gui/items.png")) {
         this.field_94155_m.func_94246_d().func_94277_a(0);
         return this.field_94155_m.func_94246_d().func_94282_c();
      } else {
         Integer var2 = (Integer)this.field_78362_c.get(p_78341_1_);
         if(var2 != null) {
            return var2.intValue();
         } else {
            String var3 = p_78341_1_;

            try {
               int var4 = GLAllocation.func_74528_a();
               boolean var9 = p_78341_1_.startsWith("%blur%");
               if(var9) {
                  p_78341_1_ = p_78341_1_.substring(6);
               }

               boolean var6 = p_78341_1_.startsWith("%clamp%");
               if(var6) {
                  p_78341_1_ = p_78341_1_.substring(7);
               }

               InputStream var7 = this.field_78366_k.func_77292_e().func_77532_a(p_78341_1_);
               if(var7 == null) {
                  this.func_98184_a(this.field_78364_l, var4, var9, var6);
               } else {
                  this.func_98184_a(this.func_78345_a(var7), var4, var9, var6);
               }

               this.field_78362_c.put(var3, Integer.valueOf(var4));
               return var4;
            } catch (Exception var8) {
               var8.printStackTrace();
               int var5 = GLAllocation.func_74528_a();
               this.func_78351_a(this.field_78364_l, var5);
               this.field_78362_c.put(p_78341_1_, Integer.valueOf(var5));
               return var5;
            }
         }
      }
   }

   public int func_78353_a(BufferedImage p_78353_1_) {
      int var2 = GLAllocation.func_74528_a();
      this.func_78351_a(p_78353_1_, var2);
      this.field_78360_e.func_76038_a(var2, p_78353_1_);
      return var2;
   }

   public void func_78351_a(BufferedImage p_78351_1_, int p_78351_2_) {
      this.func_98184_a(p_78351_1_, p_78351_2_, false, false);
   }

   public void func_98184_a(BufferedImage p_98184_1_, int p_98184_2_, boolean p_98184_3_, boolean p_98184_4_) {
      this.func_78342_b(p_98184_2_);
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
      if(p_98184_3_) {
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
      }

      if(p_98184_4_) {
         GL11.glTexParameteri(3553, 10242, 10496);
         GL11.glTexParameteri(3553, 10243, 10496);
      } else {
         GL11.glTexParameteri(3553, 10242, 10497);
         GL11.glTexParameteri(3553, 10243, 10497);
      }

      int var5 = p_98184_1_.getWidth();
      int var6 = p_98184_1_.getHeight();
      int[] var7 = new int[var5 * var6];
      p_98184_1_.getRGB(0, 0, var5, var6, var7, 0, var5);
      if(this.field_78365_j != null && this.field_78365_j.field_74337_g) {
         var7 = this.func_98186_a(var7);
      }

      this.field_78358_g.clear();
      this.field_78358_g.put(var7);
      this.field_78358_g.position(0).limit(var7.length);
      GL11.glTexImage2D(3553, 0, 6408, var5, var6, 0, '\u80e1', '\u8367', this.field_78358_g);
   }

   private int[] func_98186_a(int[] p_98186_1_) {
      int[] var2 = new int[p_98186_1_.length];

      for(int var3 = 0; var3 < p_98186_1_.length; ++var3) {
         int var4 = p_98186_1_[var3] >> 24 & 255;
         int var5 = p_98186_1_[var3] >> 16 & 255;
         int var6 = p_98186_1_[var3] >> 8 & 255;
         int var7 = p_98186_1_[var3] & 255;
         int var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
         int var9 = (var5 * 30 + var6 * 70) / 100;
         int var10 = (var5 * 30 + var7 * 70) / 100;
         var2[var3] = var4 << 24 | var8 << 16 | var9 << 8 | var10;
      }

      return var2;
   }

   public void func_78349_a(int[] p_78349_1_, int p_78349_2_, int p_78349_3_, int p_78349_4_) {
      this.func_78342_b(p_78349_4_);
      GL11.glTexParameteri(3553, 10241, 9728);
      GL11.glTexParameteri(3553, 10240, 9728);
      GL11.glTexParameteri(3553, 10242, 10497);
      GL11.glTexParameteri(3553, 10243, 10497);
      if(this.field_78365_j != null && this.field_78365_j.field_74337_g) {
         p_78349_1_ = this.func_98186_a(p_78349_1_);
      }

      this.field_78358_g.clear();
      this.field_78358_g.put(p_78349_1_);
      this.field_78358_g.position(0).limit(p_78349_1_.length);
      GL11.glTexSubImage2D(3553, 0, 0, 0, p_78349_2_, p_78349_3_, '\u80e1', '\u8367', this.field_78358_g);
   }

   public void func_78344_a(int p_78344_1_) {
      this.field_78360_e.func_76049_d(p_78344_1_);
      GL11.glDeleteTextures(p_78344_1_);
   }

   public int func_78350_a(String p_78350_1_, String p_78350_2_) {
      ThreadDownloadImageData var3 = (ThreadDownloadImageData)this.field_78368_i.get(p_78350_1_);
      if(var3 != null && var3.field_78462_a != null && !var3.field_78459_d) {
         if(var3.field_78461_c < 0) {
            var3.field_78461_c = this.func_78353_a(var3.field_78462_a);
         } else {
            this.func_78351_a(var3.field_78462_a, var3.field_78461_c);
         }

         var3.field_78459_d = true;
      }

      return var3 != null && var3.field_78461_c >= 0?var3.field_78461_c:(p_78350_2_ == null?-1:this.func_78341_b(p_78350_2_));
   }

   public boolean func_82773_c(String p_82773_1_) {
      return this.field_78368_i.containsKey(p_82773_1_);
   }

   public ThreadDownloadImageData func_78356_a(String p_78356_1_, IImageBuffer p_78356_2_) {
      ThreadDownloadImageData var3 = (ThreadDownloadImageData)this.field_78368_i.get(p_78356_1_);
      if(var3 == null) {
         this.field_78368_i.put(p_78356_1_, new ThreadDownloadImageData(p_78356_1_, p_78356_2_));
      } else {
         ++var3.field_78460_b;
      }

      return var3;
   }

   public void func_78347_c(String p_78347_1_) {
      ThreadDownloadImageData var2 = (ThreadDownloadImageData)this.field_78368_i.get(p_78347_1_);
      if(var2 != null) {
         --var2.field_78460_b;
         if(var2.field_78460_b == 0) {
            if(var2.field_78461_c >= 0) {
               this.func_78344_a(var2.field_78461_c);
            }

            this.field_78368_i.remove(p_78347_1_);
         }
      }

   }

   public void func_78343_a() {
      this.field_94154_l.func_94248_c();
      this.field_94155_m.func_94248_c();
   }

   public void func_78352_b() {
      ITexturePack var1 = this.field_78366_k.func_77292_e();
      this.func_94152_c();
      Iterator var2 = this.field_78360_e.func_76039_d().iterator();

      BufferedImage var3;
      while(var2.hasNext()) {
         int var4 = ((Integer)var2.next()).intValue();
         var3 = (BufferedImage)this.field_78360_e.func_76041_a(var4);
         this.func_78351_a(var3, var4);
      }

      ThreadDownloadImageData var12;
      for(var2 = this.field_78368_i.values().iterator(); var2.hasNext(); var12.field_78459_d = false) {
         var12 = (ThreadDownloadImageData)var2.next();
      }

      var2 = this.field_78362_c.keySet().iterator();

      String var5;
      while(var2.hasNext()) {
         var5 = (String)var2.next();

         try {
            int var6 = ((Integer)this.field_78362_c.get(var5)).intValue();
            boolean var7 = var5.startsWith("%blur%");
            if(var7) {
               var5 = var5.substring(6);
            }

            boolean var8 = var5.startsWith("%clamp%");
            if(var8) {
               var5 = var5.substring(7);
            }

            BufferedImage var9 = this.func_78345_a(var1.func_77532_a(var5));
            this.func_98184_a(var9, var6, var7, var8);
         } catch (IOException var11) {
            var11.printStackTrace();
         }
      }

      var2 = this.field_78359_d.keySet().iterator();

      while(var2.hasNext()) {
         var5 = (String)var2.next();

         try {
            var3 = this.func_78345_a(var1.func_77532_a(var5));
            this.func_78340_a(var3, (int[])((int[])this.field_78359_d.get(var5)));
         } catch (IOException var10) {
            var10.printStackTrace();
         }
      }

      Minecraft.func_71410_x().field_71466_p.func_98304_a();
      Minecraft.func_71410_x().field_71464_q.func_98304_a();
   }

   private BufferedImage func_78345_a(InputStream p_78345_1_) throws IOException {
      BufferedImage var2 = ImageIO.read(p_78345_1_);
      p_78345_1_.close();
      return var2;
   }

   public void func_94152_c() {
      this.field_94154_l.func_94247_b();
      this.field_94155_m.func_94247_b();
   }

   public Icon func_96448_c(int p_96448_1_) {
      switch(p_96448_1_) {
      case 0:
         return this.field_94154_l.func_96455_e();
      case 1:
      default:
         return this.field_94155_m.func_96455_e();
      }
   }
}
