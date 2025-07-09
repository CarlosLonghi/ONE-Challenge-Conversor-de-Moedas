package org.example;

import com.google.gson.annotations.SerializedName;

public record Moeda(
        @SerializedName("base_code")
        String baseCode,

        @SerializedName("target_code")
        String targetCode,

        @SerializedName("conversion_result")
        double conversionResult,

        @SerializedName("time_last_update_utc")
        String timeLastUpdateUtc
) {

    @Override
    public String toString() {
        return "Moeda Base= " + baseCode + '\n' +
                "Moeda Alvo= " + targetCode + '\n' +
                "Resultado da conversão= " + conversionResult + " (" + targetCode+ ")\n" +
                "Ultima atualização= " + timeLastUpdateUtc + "\n";
    }
}
