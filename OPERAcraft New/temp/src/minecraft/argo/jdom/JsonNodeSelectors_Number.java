package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.LeafFunctor;

final class JsonNodeSelectors_Number extends LeafFunctor {

   public boolean func_98314_a(JsonNode p_98314_1_) {
      return JsonNodeType.NUMBER == p_98314_1_.func_74616_a();
   }

   public String func_74628_a() {
      return "A short form nullable number";
   }

   public String func_98313_b(JsonNode p_98313_1_) {
      return p_98313_1_.getText();
   }

   public String toString() {
      return "a value that is a number";
   }

   // $FF: synthetic method
   public Object func_74633_c(Object p_74633_1_) {
      return this.func_98313_b((JsonNode)p_74633_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_74630_a(Object p_74630_1_) {
      return this.func_98314_a((JsonNode)p_74630_1_);
   }
}
