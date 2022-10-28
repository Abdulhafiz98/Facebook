package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString(callSuper = true)
public enum Gender {
    Male(1),
    Female(0);
    final int num;

}
