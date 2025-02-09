package com.example.idk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BaseResponse<T> {
    private String status;
    private T data;
    private String message;

    public BaseResponse(String status,T data, String message)
    {
        this.data = data;
        this.message = message;
        this.status = status;
    }

}

