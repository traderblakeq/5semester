package com.example.final_night_out.Models;

import lombok.Data;
import org.hibernate.annotations.Type;

@Data
public class Pictures {

    private String id;

    private String fileName;

    @Type(type="text")
    private String image;
}
