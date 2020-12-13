package org.example.mvc.dataobject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDO {
    private Long id;
    private String name;
    private String sex;
    private int age;
}
