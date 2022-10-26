package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE(1),
    FEMALE(2);
    final int num;

}
