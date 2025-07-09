package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean aplicacaoEmExecucao = true;
        Scanner scanner = new Scanner(System.in);
        ConsultaMoeda consultaMoeda = new ConsultaMoeda();

        System.out.println("||| Seja bem-vindo/a ao Conversor de Moedas |||");

        while (aplicacaoEmExecucao) {
            System.out.print("""
                    ----------------------------------------------------------
                    Escolha uma das opções de conversão válida:
                    
                    1) Dólar (USD)           --> Peso Argentino (ARS)
                    2) Peso Argentino (ARS)  --> Dólar (USD)
                    3) Dólar (USD)           --> Real Brasileiro (BRL)
                    4) Real Brasileiro (BRL) --> Dólar (USD)
                    5) Dólar (USD)           --> Peso Colombiano (COP)
                    6) Peso Colombiano (COP) --> Dólar (USD)
                    7) Sair
                    ----------------------------------------------------------
                    """);
            int conversaoEscolhida = scanner.nextInt();

            if (conversaoEscolhida == 7) {
                System.out.println("Saindo do conversor...");
                scanner.close();
                break;
            }

            System.out.print("Digite o valor desejado para a conversão: ");
            double valorDeConversao = scanner.nextDouble();

            try {
                switch (conversaoEscolhida) {
                    case 1: {
                        Moeda moeda = consultaMoeda.buscaValorDaMoeda("USD", "ARS", valorDeConversao);
                        System.out.println(moeda);
                        break;
                    }
                    case 2: {
                        Moeda moeda = consultaMoeda.buscaValorDaMoeda("ARS", "USD", valorDeConversao);
                        System.out.println(moeda);
                        break;
                    }
                    case 3: {
                        Moeda moeda = consultaMoeda.buscaValorDaMoeda("USD", "BRL", valorDeConversao);
                        System.out.println(moeda);
                        break;
                    }
                    case 4: {
                        Moeda moeda = consultaMoeda.buscaValorDaMoeda("BRL", "USD", valorDeConversao);
                        System.out.println(moeda);
                        break;
                    }
                    case 5: {
                        Moeda moeda = consultaMoeda.buscaValorDaMoeda("USD", "COP", valorDeConversao);
                        System.out.println(moeda);
                        break;
                    }
                    case 6: {
                        Moeda moeda = consultaMoeda.buscaValorDaMoeda("COP", "USD", valorDeConversao);
                        System.out.println(moeda);
                        break;
                    }
                    default: {
                        System.out.println("Opção inválida!");
                        break;
                    }
                }

                System.out.print("""
                        Converter Novamente?
                        1 - SIM
                        2 - NÃO
                        """);
                int escolha = scanner.nextInt();
                if (escolha == 2) {
                    System.out.println("Saindo do conversor...");
                    scanner.close();
                    break;
                }

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
                aplicacaoEmExecucao = false;
            }
        }
    }
}