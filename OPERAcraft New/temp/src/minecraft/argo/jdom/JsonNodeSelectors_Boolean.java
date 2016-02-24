package argo.jdom;

import argo.jdom.JsonNode;
import argo.jdom.JsonNodeType;
import argo.jdom.LeafFunctor;

final class JsonNodeSelectors_Boolean extends LeafFunctor {

   public boolean func_98312_a(JsonNode p_98312_1_) {
      return JsonNodeType.TRUE == p_98312_1_.func_74616_a() || JsonNodeType.FALSE == p_98312_1_.func_74616_a();
   }

   public String func_74628_a() {
      return "A short form boolean";
   }

   public Boolean func_98311_b(JsonNode p_98311_1_) {
      return Boolean.valueOf(JsonNodeType.TRUE == p_98311_1_.func_74616_a());
   }

   public String toString() {
      return "a true or false";
   }

   // $FF: synthetic method
   public Object func_74633_c(Object p_74633_1_) {
      return this.func_98311_b((JsonNode)p_74633_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public boolean func_74630_a(Object p_74630_1_) {
      return this.func_98312_a((JsonNode)p_74630_1_);
   }
}
