package com.thoughtworks.nho.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    int code = 200;
    String msg = "Success";
    Object object;
}
