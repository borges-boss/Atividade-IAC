package iac.atividade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gabriel Borges
 *
 * 1) Escreva um algoritmo que leia um conjunto de fichas de pessoas(a última
 * ficha deve ter altura negativa e não deve entrar nos cálculos), cada uma
 * contendo, a altura e o código do sexo de uma pessoa (código = 1 se for
 * masculino e 2 se for feminino), e calcule e mostre na tela:
 *
 * - a maior e a menor altura da turma;
 *
 * - a média de altura das mulheres;
 *
 * - a média de altura dos homens;
 *
 * - a média de altura da turma.
 */
public class Main {

    public static List<Ficha> list = new ArrayList<>();

    //Calcular o media de alturas
    public static double calcMediaAltura(int filter) {
        double sum = 0.00;
        double count = 0;

        for (Ficha f : list) {
            if (f.getSexo() == filter) {
                sum += f.getAltura();
                count++;
            }
        }
        return (sum / count);
    }

    public static double calcMediaAltura() {
        double sum = 0.00;
        double count = 0;

        for (Ficha f : list) {
            sum += f.getAltura();
            count++;
        }
        return (sum / count);
    }

    public static double[] findMaxAndMin() {
        double alturas[] = new double[list.size()];
        double result[] = new double[2];

        for (int i = 0; i < list.size(); i++) {
            alturas[i] = list.get(i).getAltura();
        }
        Arrays.sort(alturas);
        result[0] = alturas[0];//Min
        result[1] = alturas[alturas.length - 1];//Max

        return result;
    }

    public static void printResults() {
        double[] findMaxAndMin = findMaxAndMin();
        System.err.println("Resultados");
        System.out.println("--------------------");
        System.out.println("Altura minima: " + findMaxAndMin[0]);
        System.out.println("Altura maxima: " + findMaxAndMin[1]);
        System.out.println("Media de altura das mulheres: " + String.valueOf(calcMediaAltura(2)));
        System.out.println("Media de altura das homens: " + String.valueOf(calcMediaAltura(1)));
        System.out.println("Media de altura da turma: " + String.valueOf(calcMediaAltura()));

    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double altura = 1;
        short sexo = 1;
        int count = 1;
        System.err.println("Cadastro de altura");
        System.out.println("Digite um numero negativo para encerrar (ex:-1)");;
        System.out.println("--------------------------------------");

        while (altura > 0 && (sexo == 1 || sexo == 2)) {
            System.out.println("Digite a altura: ");
            altura = read.nextDouble();

            if (altura < 0) {
                System.err.println("Cadastro encerrado");
                if (list.size() > 0) {
                    printResults();
                }
                break;
            }

            System.out.println("Digite o codigo do sexo(1 Masculino e 2 Feminino): ");
            sexo = read.nextShort();
            if (sexo > 2 && sexo <= 0) {
                System.err.println("Cadastro encerrado");
                if (list.size() > 0) {
                    printResults();
                }
                break;
            }

            list.add(new Ficha(altura, sexo));
            System.out.println("Ficha " + count + " cadastrada com sucesso!");
            count++;
        }

    }
}
