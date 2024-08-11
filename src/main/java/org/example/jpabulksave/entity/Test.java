package org.example.jpabulksave.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(38)")
    private String id;
    private String name;
    private String nickName1;
    private String nickName2;
    private String nickName3;
    private String nickName4;
    private String nickName5;
    private String nickName6;
    private String nickName7;
    private String nickName8;


    public Test(String id, String name, String nickName1, String nickName2, String nickName3, String nickName4, String nickName5, String nickName6, String nickName7, String nickName8) {
        this.id = id;
        this.name = name;
        this.nickName1 = nickName1;
        this.nickName2 = nickName2;
        this.nickName3 = nickName3;
        this.nickName4 = nickName4;
        this.nickName5 = nickName5;
        this.nickName6 = nickName6;
        this.nickName7 = nickName7;
        this.nickName8 = nickName8;
    }

    public void updateNickName(String nickName1) {
        this.nickName1 = nickName1;
    }

}

