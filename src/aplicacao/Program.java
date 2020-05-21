/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.Exception.DominioExcecao;
import model.entities.Reserva;

/**
 *
 * @author Dell
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Entre com o numero do quarto:");
            int numero = sc.nextInt();

            System.out.println("Entre com data de entrada no formato dd/MM/yyyy");
            Date entrada = sdf.parse(sc.next());

            System.out.println("Entre com data de saida no formato dd/MM/yyyy");
            Date saida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero, entrada, saida);
            System.out.println("Reserva " + reserva);

            System.out.println();
            System.out.print("Entre com a data para atualizar");

            System.out.println("Entre com data de entrada no formato dd/MM/yyyy");
            entrada = sdf.parse(sc.next());
            System.out.println("Entre com data de saida no formato dd/MM/yyyy");
            saida = sdf.parse(sc.next());

            reserva.updateDate(entrada, saida);

            System.out.println("Reserva " + reserva);
        } catch (ParseException e) {
            System.out.println("Valor da data invalido");
        } catch (DominioExcecao e) {
            System.out.println("Erro ao fazer a reserva"+e.getMessage());
        }
        catch( RuntimeException e ){
            System.out.println("Unsexpected error");
        }
        sc.close();

    }

}
