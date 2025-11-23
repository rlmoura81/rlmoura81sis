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
    
    public BigDecimal custoHora(BigDecimal qtdehora, BigDecimal valorhora){
        return valorhora.multiply(qtdehora);
    }
    
    public BigDecimal custoTotal(BigDecimal customensal, BigDecimal custohora){
        BigDecimal resultado = customensal.add(custohora);
        return resultado;
    }
    
    public BigDecimal calculoMensalidade(BigDecimal salario, BigDecimal valormensalidade, BigDecimal valormensalidadepercent){
        BigDecimal resultado = null;
        if(valormensalidade != null && valormensalidadepercent == null){
            resultado = (valormensalidade.divide(salario, 3, RoundingMode.HALF_UP).multiply(Utilidade.converter("100,00")));
        }
        if(valormensalidade == null && valormensalidadepercent != null){
            resultado = salario.multiply(valormensalidadepercent.divide(Utilidade.converter("100,00")));
        }
        return resultado;
    }
    
    public BigDecimal custoTotalMensalidade(BigDecimal custototal, BigDecimal valormensalidade){
        return custototal.divide(valormensalidade, 2, RoundingMode.HALF_UP);
    }
    
    public BigDecimal custoHoraMensalidade(BigDecimal custohora, BigDecimal valormensalidade){
        return custohora.divide(valormensalidade, 2, RoundingMode.HALF_UP);
    }
    
        public BigDecimal qtdeSalario(BigDecimal salario, BigDecimal valormensalidade){
            return salario.divide(valormensalidade, 2, RoundingMode.HALF_UP);
    }
}
