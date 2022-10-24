package model;

import lombok.Getter;

@Getter
public abstract class Base {
    static int idGenerator=0;
    int id;

    public Base(){
        ++idGenerator;
        this.id = idGenerator;
    }
}
