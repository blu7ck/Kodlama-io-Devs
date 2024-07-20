package com.blu4ck.Kodlama.io.Devs.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Language {
    private int id;
    private String name;

    public Language(){

    }
    public Language(int id, String name){
        this.id = id;
        this.name = name;
    }
}
