package base;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public abstract class Base {
   int id = 0;
   static int idGen = 0;

   public Base(){
       this.id = idGen++;
   }



}
