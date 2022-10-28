package model;

import base.Base;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Post extends Base {

    private int userId;
    private String text;
}