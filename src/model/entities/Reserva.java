/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Dell
 */
public class Reserva {

    private Integer quartoNumero;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reserva(Integer quartoNumero, Date entrada, Date saida) {
        this.quartoNumero = quartoNumero;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getQuartoNumero() {
        return quartoNumero;
    }

    public void setQuartoNumero(Integer quartoNumero) {
        this.quartoNumero = quartoNumero;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public long duracao() {
        //pegando a diferença das datas em milesegundos
        long diferenca = saida.getTime() - entrada.getTime();

        //convertende de milesegundos para dias
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);

    }
    public String  updateDate(Date entrada, Date saida){
        
        Date now = new Date();
            if (entrada.before(now) || saida.before(now)) {
                return "Erro na atualização da reserva: deve ser para datas futuras";
            } 
            if (!saida.after(entrada)) {
                return "verifique a data de saita tem que ser depois da data de entrada";
            } 
        this.entrada = entrada;
        this.saida = saida;  
        return null;
    }

    @Override
    public String toString(){
    
        return "Quarto"
                +quartoNumero
                +", entrada: "
                +sdf.format(entrada)
                +", saida: "
                +sdf.format(saida)
                +", "
                + duracao()
                +" noites";
    }
}
