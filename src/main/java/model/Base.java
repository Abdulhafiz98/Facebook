package model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Base {
   int id;
   static int idGen = 0;

   public Base(){
      idGen++;
       this.id = idGen;
   }
}
