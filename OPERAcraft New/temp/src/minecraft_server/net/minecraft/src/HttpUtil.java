package net.minecraft.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.src.ILogAgent;

public class HttpUtil {

   public static String func_76179_a(Map p_76179_0_) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = p_76179_0_.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if(var3.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static String func_76183_a(ILogAgent p_76183_0_, URL p_76183_1_, Map p_76183_2_, boolean p_76183_3_) {
      return func_76180_a(p_76183_0_, p_76183_1_, func_76179_a(p_76183_2_), p_76183_3_);
   }

   public static String func_76180_a(ILogAgent p_76180_0_, URL p_76180_1_, String p_76180_2_, boolean p_76180_3_) {
      try {
         HttpURLConnection var4 = (HttpURLConnection)p_76180_1_.openConnection();
         var4.setRequestMethod("POST");
         var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var4.setRequestProperty("Content-Length", "" + p_76180_2_.getBytes().length);
         var4.setRequestProperty("Content-Language", "en-US");
         var4.setUseCaches(false);
         var4.setDoInput(true);
         var4.setDoOutput(true);
         DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
         var5.writeBytes(p_76180_2_);
         var5.flush();
         var5.close();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
         StringBuffer var8 = new StringBuffer();

         String var7;
         while((var7 = var6.readLine()) != null) {
            var8.append(var7);
            var8.append('\r');
         }

         var6.close();
         return var8.toString();
      } catch (Exception var9) {
         if(!p_76180_3_) {
            if(p_76180_0_ != null) {
               p_76180_0_.func_98234_c("Could not post to " + p_76180_1_, var9);
            } else {
               Logger.getAnonymousLogger().log(Level.SEVERE, "Could not post to " + p_76180_1_, var9);
            }
         }

         return "";
      }
   }
}
