package com.example.lilylane.couriers.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * used to represent a response message
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponseMessage {

    private int code;
    private String message;
    private Object object;

}



