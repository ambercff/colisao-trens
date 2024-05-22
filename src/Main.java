import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double velocidadeA, velocidadeB,velocidadeBneg, posicaoA, posicaoB;
        Scanner ler = new Scanner(System.in);
        String continuar;

        while(true) {
            try {
                System.out.println("Insira a velocidade do trem A:");
                velocidadeA = ler.nextDouble();

                if (velocidadeA > 300) {
                    System.out.println("O limite do módulo da velocidade é 300km/h! Insira a velocidade novamente.");
                    continue;
                } else if (velocidadeA < 0) {
                    System.out.println("A velocidade deve ser positiva!");
                    continue;
                }

                System.out.println("Insira a velocidade do trem B:");
                velocidadeB = ler.nextDouble();
                velocidadeBneg = -velocidadeB;

                if (velocidadeB > 300) {
                    System.out.println("O limite do módulo da velocidade é 300km/h! Insira a velocidade novamente.");
                    continue;
                }

                System.out.println("Insira a posição do trem A:");
                posicaoA = ler.nextDouble();

                if (posicaoA < 0 || posicaoA > 10000) {
                    System.out.println("A posição deve ser entre KM 0 e KM 10.000! Insira a posição novamente.");
                    continue;
                }

                System.out.println("Insira a posição do trem B:");
                posicaoB = ler.nextDouble();

                if (posicaoB < 0 || posicaoB > 10000) {
                    System.out.println("A posição deve ser entre KM 0 e KM 10.000! Insira a posição novamente.");
                    continue;
                }

                if (posicaoA == posicaoB || posicaoA > posicaoB) {
                    System.out.println("Os trens não irão colidir!");
                    break;
                }

                double tempo = fazerEquacaoTempo(posicaoA, posicaoB, velocidadeA, velocidadeBneg);
                double posicaoFinal = fazerEquacaoHoraria(posicaoA, velocidadeA, tempo);

                tempo = tempo * 3600;

                int horas = 17;
                int minutos = 0;
                int segundos = 0;

                segundos += (int) tempo;

                while (segundos >= 60) {
                    segundos -= 60;
                    minutos++;

                    if (minutos >= 60) {
                        minutos -= 60;
                        horas++;
                    }
                }

                String horario = String.format("%02d:%02d:%02d", horas, minutos, segundos);

                System.out.printf("A colisão de trens acontecerá no KM %.2f e ocorrerá após %.2f segundos no horário de %s",
                        posicaoFinal, tempo, horario);

                ler.nextLine();

                System.out.println("\nDeseja executar novamente? Digite sim ou nao:");
                continuar = ler.nextLine();

                if (continuar.equals("sim")) {
                    System.out.println("Programa iniciando novamente");
                    continue;
                } else if (continuar.equals("nao")) {
                    break;
                } else {
                    System.out.println("Entrada incorreta! Digite sim ou nao.");
                }
            break;
            }
            catch (InputMismatchException e) {
                System.out.println("Insira um número!");
            }
            ler.nextLine();
        }

    }

    public static double fazerEquacaoTempo(double posicaoA, double posicaoB, double velocidadeA, double velocidadeB) {
        double tempo;
        return tempo = ((posicaoA - posicaoB) / (velocidadeB - velocidadeA));
    }

    public static double fazerEquacaoHoraria(double posicao, double velocidade, double tempo) {
        double posicaoFinal;

        return posicaoFinal = posicao + (velocidade * tempo);
    }
}