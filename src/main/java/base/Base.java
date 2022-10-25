package base;

import lombok.Getter;

@Getter
public abstract class Base {
   int id = 0;
   static int idGen = 0;

   public Base(){
       this.id = idGen++;
   }



}
