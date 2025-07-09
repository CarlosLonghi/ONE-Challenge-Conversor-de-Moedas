package org.example;

import com.google.gson.annotations.SerializedName;

public record ErroExchangerateApi(
        String result,
        @SerializedName("error-type") String errorType
) {
}
