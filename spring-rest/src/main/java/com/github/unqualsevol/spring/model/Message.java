package com.github.unqualsevol.spring.model;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by agimenez on 19/09/17.
 */
public class Message implements Serializable{
    private String name;
    private String value;
    //private LocalDate date;

    public Message(){
        super();
    }

    /*public Message(String name, String value, LocalDate date) {
        this.name = name;
        this.value = value;
        this.date = date;
    }*/

    public Message(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    /*@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonSerialize(using = DateSerializer.class)
    public LocalDate getDate() {
        return date;
    }*/
}
