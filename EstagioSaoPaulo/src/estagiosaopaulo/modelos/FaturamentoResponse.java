package estagiosaopaulo.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Danilo Saraiva
 */
public class FaturamentoResponse {
    private List<FaturamentoDiario> faturamentoDiario;
    
    @JsonProperty("faturamentoDiario")
    public List<FaturamentoDiario> getFaturamentoDiario() {
        return faturamentoDiario;
    }
    @JsonProperty("faturamentoDiario")
    public void setFaturamentoDiario(List<FaturamentoDiario> faturamentoDiario) {
        this.faturamentoDiario = faturamentoDiario;
    }
}
