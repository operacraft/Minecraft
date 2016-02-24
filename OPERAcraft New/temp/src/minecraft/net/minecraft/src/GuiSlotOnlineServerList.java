package net.minecraft.src;

import net.minecraft.src.EnumChatFormatting;
import net.minecraft.src.GuiScreenOnlineServers;
import net.minecraft.src.GuiScreenSelectLocation;
import net.minecraft.src.McoServer;
import net.minecraft.src.Tessellator;
import net.minecraft.src.ThreadConnectToOnlineServer;
import org.lwjgl.opengl.GL11;

class GuiSlotOnlineServerList extends GuiScreenSelectLocation {

   // $FF: synthetic field
   final GuiScreenOnlineServers field_96294_a;


   public GuiSlotOnlineServerList(GuiScreenOnlineServers p_i10004_1_) {
      super(GuiScreenOnlineServers.func_98075_b(p_i10004_1_), p_i10004_1_.field_73880_f, p_i10004_1_.field_73881_g, 32, p_i10004_1_.field_73881_g - 64, 36);
      this.field_96294_a = p_i10004_1_;
   }

   protected int func_77217_a() {
      return GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size() + 1;
   }

   protected void func_77213_a(int p_77213_1_, boolean p_77213_2_) {
      if(p_77213_1_ < GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size()) {
         GuiScreenOnlineServers.func_98089_b(this.field_96294_a, p_77213_1_);
         McoServer var3 = (McoServer)GuiScreenOnlineServers.func_98094_c(this.field_96294_a).get(GuiScreenOnlineServers.func_98072_d(this.field_96294_a));
         GuiScreenOnlineServers.func_96161_f(this.field_96294_a).field_73742_g = GuiScreenOnlineServers.func_98076_f(this.field_96294_a).field_71449_j.field_74286_b.equals(var3.field_96405_e);
         GuiScreenOnlineServers.func_98092_g(this.field_96294_a).field_73742_g = var3.field_96404_d.equals("OPEN") && !var3.field_98166_h;
         if(p_77213_2_ && GuiScreenOnlineServers.func_98092_g(this.field_96294_a).field_73742_g) {
            GuiScreenOnlineServers.func_98078_c(this.field_96294_a, GuiScreenOnlineServers.func_98072_d(this.field_96294_a));
         }

      }
   }

   protected boolean func_77218_a(int p_77218_1_) {
      return p_77218_1_ == GuiScreenOnlineServers.func_98072_d(this.field_96294_a);
   }

   protected boolean func_104086_b(int p_104086_1_) {
      return p_104086_1_ < GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size() && ((McoServer)GuiScreenOnlineServers.func_98094_c(this.field_96294_a).get(p_104086_1_)).field_96405_e.toLowerCase().equals(GuiScreenOnlineServers.func_98091_h(this.field_96294_a).field_71449_j.field_74286_b);
   }

   protected int func_77212_b() {
      return this.func_77217_a() * 36;
   }

   protected void func_77221_c() {
      this.field_96294_a.func_73873_v_();
   }

   protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_) {
      if(p_77214_1_ < GuiScreenOnlineServers.func_98094_c(this.field_96294_a).size()) {
         this.func_96292_b(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
      }

   }

   private void func_96292_b(int p_96292_1_, int p_96292_2_, int p_96292_3_, int p_96292_4_, Tessellator p_96292_5_) {
      McoServer var6 = (McoServer)GuiScreenOnlineServers.func_98094_c(this.field_96294_a).get(p_96292_1_);
      this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_104038_i(this.field_96294_a), var6.func_96398_b(), p_96292_2_ + 2, p_96292_3_ + 1, 16777215);
      short var7 = 207;
      byte var8 = 1;
      if(var6.field_98166_h) {
         GuiScreenOnlineServers.func_101012_b(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_104094_d, this.field_104095_e);
      } else if(var6.field_96404_d.equals("CLOSED")) {
         GuiScreenOnlineServers.func_101009_c(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_104094_d, this.field_104095_e);
      } else if(var6.field_96405_e.equals(GuiScreenOnlineServers.func_104032_j(this.field_96294_a).field_71449_j.field_74286_b) && var6.field_104063_i < 7) {
         this.func_96293_a(p_96292_1_, p_96292_2_ - 14, p_96292_3_, var6);
         GuiScreenOnlineServers.func_104030_a(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_104094_d, this.field_104095_e, var6.field_104063_i);
      } else if(var6.field_96404_d.equals("OPEN")) {
         GuiScreenOnlineServers.func_104031_c(this.field_96294_a, p_96292_2_ + var7, p_96292_3_ + var8, this.field_104094_d, this.field_104095_e);
         this.func_96293_a(p_96292_1_, p_96292_2_ - 14, p_96292_3_, var6);
      }

      this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98084_i(this.field_96294_a), var6.func_96397_a(), p_96292_2_ + 2, p_96292_3_ + 12, 7105644);
      this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_101005_j(this.field_96294_a), var6.field_96405_e, p_96292_2_ + 2, p_96292_3_ + 12 + 11, 5000268);
   }

   private void func_96293_a(int p_96293_1_, int p_96293_2_, int p_96293_3_, McoServer p_96293_4_) {
      if(p_96293_4_.field_96403_g != null) {
         synchronized(GuiScreenOnlineServers.func_101007_h()) {
            if(GuiScreenOnlineServers.func_101010_i() < 5 && (!p_96293_4_.field_96411_l || p_96293_4_.field_102022_m)) {
               (new ThreadConnectToOnlineServer(this, p_96293_4_)).start();
            }
         }

         boolean var5 = p_96293_4_.field_96415_h > 61;
         boolean var6 = p_96293_4_.field_96415_h < 61;
         boolean var7 = var5 || var6;
         if(p_96293_4_.field_96414_k != null) {
            this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98079_k(this.field_96294_a), p_96293_4_.field_96414_k, p_96293_2_ + 215 - GuiScreenOnlineServers.func_98087_l(this.field_96294_a).func_78256_a(p_96293_4_.field_96414_k), p_96293_3_ + 1, 8421504);
         }

         if(var7) {
            String var8 = EnumChatFormatting.DARK_RED + p_96293_4_.field_96413_j;
            this.field_96294_a.func_73731_b(GuiScreenOnlineServers.func_98074_m(this.field_96294_a), var8, p_96293_2_ + 200 - GuiScreenOnlineServers.func_101000_n(this.field_96294_a).func_78256_a(var8), p_96293_3_ + 1, 8421504);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GuiScreenOnlineServers.func_101004_o(this.field_96294_a).field_71446_o.func_98187_b("/gui/icons.png");
         byte var13 = 0;
         boolean var9 = false;
         String var10 = null;
         if(var7) {
            var10 = var5?"Client out of date!":"Server out of date!";
            byte var14 = 5;
            this.field_96294_a.func_73729_b(p_96293_2_ + 205, p_96293_3_, var13 * 10, 176 + var14 * 8, 10, 8);
         }

         byte var11 = 4;
         if(this.field_104094_d >= p_96293_2_ + 205 - var11 && this.field_104095_e >= p_96293_3_ - var11 && this.field_104094_d <= p_96293_2_ + 205 + 10 + var11 && this.field_104095_e <= p_96293_3_ + 8 + var11) {
            GuiScreenOnlineServers.func_101011_a(this.field_96294_a, var10);
         }

      }
   }
}
