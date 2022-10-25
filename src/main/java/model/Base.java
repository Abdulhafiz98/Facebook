package model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Base {
   int id = 0;
   static int idGen = 0;

   public Base(){
       this.id = idGen++;
   }



}
