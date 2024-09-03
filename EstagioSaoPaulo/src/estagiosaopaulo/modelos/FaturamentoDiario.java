package estagiosaopaulo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

/**
 *
 * @author Danilo Saraiva
 */
public class FaturamentoDiario {
    private LocalDate data;
    private double faturamento;

    @JsonProperty("data")
    public LocalDate getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(LocalDate data) {
        this.data = data;
    }
    @JsonProperty("faturamento")
    public double getFaturamento() {
        return faturamento;
    }
    @JsonProperty("faturamento")
    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }
    
}
