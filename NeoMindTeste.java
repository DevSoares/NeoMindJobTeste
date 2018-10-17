package neomindteste;

import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author Luiz Vitor Soares
 * 
 * 
 * Algumas declarações sobre a solução do problema.
 * 
 * No e-mail recebido é pedido para que seja considerado:
 * 
•          00:00h possui um ângulo de 0
•          00:15h possui um ângulo de 45
•          00:30h possui um ângulo de 180
* 
* Porém quando fazemos uma análise do relógio percebemos que temos 12 horas, 60 minutos.
* Se dividirmos os 360 graus de uma circunferencia em 12 partes que é equivalente as 12 horas. 
* Teremos que cada parte corresponde a 30 graus.
* Se dividirmos os 360 graus de uma circunferencia em 60 partes que é equivalente aos 60 minutos.
* Teremos que cada parte corresponde a 6 graus.
* 
* Dessa forma vemos que o item 2 que aponta que "00:15h possui um ângulo de 45" não corresponde aos dados matemáticos.
* "00:15h" pode possuir dois ângulos se analisármos de duas formas.
* Forma 1, o ponteiro de horas se desloca apenas de hora em hora.
*   Nesse caso o ângulo formado seria de 90 graus.
* Forma 2, o ponteiro de horas se desloca proporcionalmente ao deslocamento do ponteiro de minutos.
*   Para isso devemos perceber que o deslocamento do ponteiro no período de 1 hora é de 30 graus.
*   Então para achar o valor que o ponteiro se desloca em graus durante os minutos devemos 
* dividir o valor de uma hora pela quantidade de minutos que uma hora possui.
*   Nesse caso chegamos a conclusão de que 30/60 = 0,5.
*   Onde o 0,5 é o valor em graus que um ponteiro se desloca no período de um minuto.
*   Explicado os valores, podemos concluir que o ângulo interno formado pelos ponteiros do relógio
* seria de 82,5 graus.
* 
* Como foi demonstrado duas formar de calcular os ângulos, nessa solução aplicarei as duas formas.

*
* No e-mail é pedido para usar o seguinte método. public long retornaAnguloRelogio(GregorianCalendar horario);
* Todavia pesquisando sobre a classe GregorianCalendar eu não consegui encontrar um método que poderia 
* converter o objeto para string, float ou int. A página que pesquisei é esta.
* https://docs.oracle.com/javase/7/docs/api/java/util/GregorianCalendar.html#method_summary
* Seguindo na busca encontrei uma possível solução a classe LocalTime, esta eu poderia converter os valores de hora e mituto
* para outros tipos de variáveis.
* https://www.tutorialspoint.com/java8/java8_datetime_api.htm
* No decorrer do desenvolvimento eu mudei o tipo de retorno da função public long retornaAnguloRelogio(GregorianCalendar horario);
* para public double retornaAnguloRelogio(int valor), fiz essa mudança pois ocorreu algumas variações de arredondamento do sistema.
* Como eu não estava mais usando o GregorianCalendar não fazia sentido usar um objeto como argumento na função, então eu removi o argumento.
* 
* Utilizando de polimorfismo eu criei duas classes estáticas.
*   public static double retornaAnguloRelogio(int seletor); 
*       Essa função utiliza o horário atual do sistema para as operações.
*   public static double retornaAnguloRelogio(float hora, float minuto, int seletor);
*       Essa função utiliza o valor inserido pelo usuário para as operações.
* 
* Nas duas funções existe o argumento "int seletor", esta variável controla como será efetuada as operações.
* Para os casos do ponteiro de horas ser fixo ou móvel.
* 
*/
public class NeoMindTeste {


    
    public static void main(String[] args) {
        float tempHora, tempMinuto;
        int valorMenu; 
        double debug;
        Scanner tecladoEntrada = new Scanner(System.in);
        

        
        do{
            System.out.println("Digite 1 para saber o ângulo formado pelos ponteiros do relógio.(Ponteiro móvel)");
            System.out.println("Digite 2 para saber o ângulo formado pelos ponteiros do relógio.(Ponteiro fixo)");
            System.out.println("Digite 3 para saber o ângulo formado pelos ponteiros do relógio.(Ponteiro móvel - INSERIR DATA)");
            System.out.println("Digite 4 para saber o ângulo formado pelos ponteiros do relógio.(Ponteiro fixo - INSERIR DATA)");
            System.out.println("Digite 5 para sair da solução");
            valorMenu = tecladoEntrada.nextInt();
            switch (valorMenu){
             case 1: 
                debug = retornaAnguloRelogio(valorMenu);
                System.out.println("O ângulo entre os ponteiros é de: "+debug +"º");
                break;
            case 2: 
                debug = retornaAnguloRelogio(valorMenu);
                System.out.println("O ângulo entre os ponteiros é de: "+debug +"º");
                break;
            case 3:
                System.out.println("Insira apenas a hora");
                tempHora = tecladoEntrada.nextFloat();
                System.out.println("Insira apenas os minutos");
                tempMinuto = tecladoEntrada.nextFloat();
                debug = retornaAnguloRelogio(tempHora,tempMinuto,valorMenu);
                System.out.println("O ângulo entre os ponteiros é de: "+debug +"º");
                break;
            case 4:
                System.out.println("Insira apenas a hora");
                tempHora = tecladoEntrada.nextFloat();
                System.out.println("Insira apenas os minutos");
                tempMinuto = tecladoEntrada.nextFloat();
                debug = retornaAnguloRelogio(tempHora,tempMinuto,valorMenu);
                System.out.println("O ângulo entre os ponteiros é de: "+debug +"º");
                break;
            default:
                break;
            }
               
        }while(valorMenu!=5);
    }
        
    public static double retornaAnguloRelogio(int seletor){
        double angulo;
        float valorHora, valorMinuto;
        float tempA, tempB;
        LocalTime horario = LocalTime.now();
        if(seletor==1){           
            if(horario.getHour()>12){
               tempA = horario.getHour()-12;
               tempA = tempA*30;
               tempB = horario.getMinute();
               valorHora = tempA + tempB*0.5f;
               valorMinuto = tempB*6;
               angulo = (double) (valorHora -valorMinuto);
               if(angulo<0){
                   angulo = angulo*-1;
               }
            }else{
               tempA = horario.getHour();
               tempA = tempA*30;
               tempB = horario.getMinute();
               valorHora = tempA + tempB*0.5f;
               valorMinuto = tempB*6;
               angulo = (double) (valorHora -valorMinuto);
               if(angulo<0){
                   angulo = angulo*-1;
               }
            }
        }else{
             if(horario.getHour()>=12){
               tempA = horario.getHour()-12;
               tempA = tempA*30;
               tempB = horario.getMinute();
               valorHora = tempA;
               valorMinuto = tempB*6;
               angulo = (double) (valorHora -valorMinuto);
               if(angulo<0){
                   angulo = angulo*-1;
               }
            }else{
               tempA = horario.getHour();
               tempA = tempA*30;
               tempB = horario.getMinute();
               valorHora = tempA;
               valorMinuto = tempB*6;
               angulo = (double) (valorHora -valorMinuto);
               if(angulo<0){
                   angulo = angulo*-1;
               }
            }
        }
        
        return angulo;
    }
    
    public static double retornaAnguloRelogio(float hora, float minuto, int seletor){
        float tempA, tempB, valorMinuto, valorHora;
        double angulo;
        tempA = hora;
        tempB = minuto;
        if(seletor==3){
            if(tempA>=12){
                tempA = tempA - 12;
                tempA = tempA*30;
                valorHora = tempA + tempB*0.5f;
                valorMinuto = tempB*6;
                angulo = (double) (valorHora - valorMinuto);
                if(angulo<0){
                    angulo = angulo*-1;
                } 
            }else{
                tempA = tempA*30;
                valorHora = tempA + tempB*0.5f;
                valorMinuto = tempB*6;
                angulo = (double) (valorHora - valorMinuto);
                if(angulo<0){
                    angulo = angulo*-1;
                }          
            }
        }else{
            if(tempA>=12){
                tempA = tempA - 12;
                tempA = tempA*30;
                valorHora = tempA;
                valorMinuto = tempB*6;
                angulo = (double) (valorHora - valorMinuto);
                if(angulo<0){
                    angulo = angulo*-1;
                } 
            }else{
                tempA = tempA*30;
                valorHora = tempA;
                valorMinuto = tempB*6;
                angulo = (double) (valorHora - valorMinuto);
                if(angulo<0){
                    angulo = angulo*-1;
                }          
            }
        }
        return angulo;
    }
}
