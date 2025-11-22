package br.com.rlmoura81.financeiro;

import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinanceiroCalculo {
    
    Utilidade util = new Utilidade();
    
    public BigDecimal qtdeSalAtual(BigDecimal salariomin, BigDecimal salarioatual){
        return salariomin.divide(salarioatual, 2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal qtdeSalMaior(BigDecimal salariomin, BigDecimal salariomaior){
        return salariomin.divide(salariomaior, 2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal custoMensalHora(BigDecimal despesa){
        BigDecimal horames = Utilidade.converter("720");
        return despesa.divide(horames, 2, RoundingMode.HALF_UP);
    }

    public BigDecimal salarioHora(BigDecimal salario, BigDecimal hora){
        return salario.divide(hora, 2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal salarioMeta(BigDecimal salario, BigDecimal qtdesalario, BigDecimal salariomin){
        BigDecimal resultado = null;
        if(salario != null && qtdesalario == null){
            resultado = salario.divide(salariomin, 2, RoundingMode.HALF_UP);
        }
        if(salario == null && qtdesalario != null){
            resultado = salariomin.multiply(qtdesalario);
        }
        return resultado;
    }
    
    public BigDecimal valorHoraMeta(BigDecimal salario, BigDecimal qtdehora, BigDecimal valorhora){
        BigDecimal resultado = null;
        if(salario != null && valorhora == null){
            resultado = salario.divide(qtdehora, 2, RoundingMode.HALF_UP);
        }
        if(salario == null && valorhora != null){
            resultado = valorhora.multiply(qtdehora);
        }        
        return resultado;
    }    
}
