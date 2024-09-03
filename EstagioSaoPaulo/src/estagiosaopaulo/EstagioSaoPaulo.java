package estagiosaopaulo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import estagiosaopaulo.modelos.FaturamentoDiario;
import estagiosaopaulo.modelos.FaturamentoResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class EstagioSaoPaulo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*
         1) Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
        Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
        Imprimir(SOMA);
        Ao final do processamento, qual será o valor da variável SOMA?
         */
        int indice = 13;
        int soma = 0;
        int k = 0;

        while (k < indice) {
            k += 1;
            soma += k;
        }
        System.out.println("1) O Valor da SOMA é:> " + soma);

        /*
        2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor 
        sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...),
        escreva um programa na linguagem que desejar onde, informado um número,
        ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número 
        informado pertence ou não a sequência.

        IMPORTANTE: Esse número pode ser informado através de qualquer entrada de sua 
        preferência ou pode ser previamente definido no código;
         */
        System.out.println("\n2) Informe um número para verificar se ele faz parte da sequência Fibonacci:> ");
        int numero;
        numero = input.nextInt();

        if (ehFibonacci(numero, 0, 1)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

        /*
        3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora,
        faça um programa, na linguagem que desejar, que calcule e retorne?:
        - O menor valor do faturamento ocorrido em um dia do mês;
        - O maior valor de faturamento ocorrido em um dia do mês;
        - Número de dias do mês em que o valor de faturamento diário foi superior à média mensal
        
        IMPORTANTE:
        a) Usar Json ou XML disponível como fonte de dados do faturamento mensal;
        b) Podem existir dias sem faturamento, como no final de semanas e feriados.
        Estes dias devem ser ignorados no calculo da média.
         */
        int opcao;
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());

        System.out.println("\n3)Informe o mês para ter as informações desejadas (1 ao 10):> ");
        opcao = input.nextInt();
        try {
            // Ler o JSON e convertê-lo em um objeto FaturamentoResponse
            FaturamentoResponse response = mapper.readValue(new File("src/util/arquivo.json"), FaturamentoResponse.class);

            // Processar a lista de faturamento

            processarFaturamento(response, opcao);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //4) Dado o fator de faturamento mensal de uma destribuidora, detalhado por estado:
        //SP- R$67.836,43
        //RJ- R$36.678,66
        //MG- R$29.229,88
        //ES- R$27.165,48
        //OUTROS- R$19.849,53
        //Escreva um programa na linguagem que desejar e calcule o percentual de representação
        //que cada estado teve dentro do valor total mensal da distribuidora
        
        
        double saoPaulo = 67836.43;
        double rioDeJaneiro = 36678.66;
        double minasGerais = 29229.88;
        double espiritoSanto = 27165.48;
        double outros = 19849.53;
        double total = saoPaulo + rioDeJaneiro + minasGerais + espiritoSanto + outros;
        
        System.out.println("\n4) % de cada Estado:");
        System.out.println("SP :> " + String.format("%.1f",(saoPaulo * 100)/total) + "%");
        System.out.println("RJ :> " + String.format("%.1f",(rioDeJaneiro * 100)/total)+ "%");
        System.out.println("MG :> " + String.format("%.1f",(minasGerais * 100)/total)+ "%");
        System.out.println("ES :> " + String.format("%.1f",(espiritoSanto * 100)/total)+ "%");
        System.out.println("OUTROS :> " + String.format("%.1f",(outros * 100)/total)+ "%");
        
        //5) Escreva um programa que inverta uma string sem utilizar recursos pontos
        String palavra;
        System.out.println("\n5) Informe uma String para ser invertida");
        palavra = input.next();
        int quantidadeLetras = palavra.length();
        String util = "";
        
        for(int i = quantidadeLetras-1; i >= 0; i--) {
            util += (Character.toString(palavra.charAt(i)));
        }
        palavra = util;
        System.out.println("Palavra invertida:> " + palavra);
        

    }// FIM MAIN

    // inicia com numeroAtual = 0 e proximoNumero = 1
    public static boolean ehFibonacci(int numero, int numeroAtual, int proximoNumero) {

        //caso o numeroAtual for = ao número ou proximoNumero for = ao número retorna verdadeiro
        if (numero == numeroAtual || numero == proximoNumero) {
            return true;
            //caso ultrapasse o valor do número retorna falso
        } else if (proximoNumero > numero) {
            return false;

        } else {
            //1º numeroAtual = 1 e proximoNumero = (1+1) = 2
            //2º numeroAtual = 2 e proximoNumero = (1+2) = 3
            //3º numero atual = 3 e proximoNumero = (2+3) = 5
            //4º numero atual = 5 e proximo numero = (3+5) = 8
            return ehFibonacci(numero, proximoNumero, numeroAtual + proximoNumero);
        }
    }

    private static void processarFaturamento(FaturamentoResponse listaFaturamento, int mes) {
        /*
        - O menor valor do faturamento ocorrido em um dia do mês;
        - O maior valor de faturamento ocorrido em um dia do mês;
        - Número de dias do mês em que o valor de faturamento diário foi superior à média mensal
        
        IMPORTANTE:
        a) Usar Json ou XML disponível como fonte de dados do faturamento mensal;
        b) Podem existir dias sem faturamento, como no final de semanas e feriados.
        Estes dias devem ser ignorados no calculo da média.
         */
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        int utilDiaMedia = 0;
        double total = 0;

        Iterator<FaturamentoDiario> lista = listaFaturamento.getFaturamentoDiario().iterator();
        
        while (lista.hasNext()) {
            
            
            FaturamentoDiario faturamento = lista.next();
            
            if (faturamento.getData().getMonthValue() == mes && faturamento.getFaturamento() != 0) {
                
                total += faturamento.getFaturamento();
                
                if(faturamento.getFaturamento() < menorValor) {
                    menorValor = faturamento.getFaturamento();
                }
                
                
                if(faturamento.getFaturamento() > maiorValor) {
                    maiorValor = faturamento.getFaturamento();
                }
                
                utilDiaMedia++;
            }
        }
        System.out.println("Valo total: " + total + " valor utildia" + utilDiaMedia);
        double media = total/utilDiaMedia;
        
        System.out.println("Informações do Faturamento do Mês " + mes);
        System.out.println("Menor valor: " + String.format("%.1f",menorValor));
        System.out.println("Maior valor: " + String.format("%.1f",maiorValor));
        System.out.println("Média do mês: " + String.format("%.1f", media));
    }
}
