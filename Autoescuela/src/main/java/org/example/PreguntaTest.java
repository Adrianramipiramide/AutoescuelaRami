package org.example;

import javax.swing.plaf.metal.MetalIconFactory;

public class PreguntaTest {
    private int id;
    private String enunciado;
    private String respuesta1;

    private String respuesta2;
    private String respuesta3;
    private int correcta;

    private  static int aciertos = 0;
    private static int fallos = 0;

    public PreguntaTest(int id, String enunciado, String respuesta1, String respuesta2, String respuesta3, int correcta) {
        this.id = id;
        this.enunciado = enunciado;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.correcta = correcta;
    }

    public static boolean esCorrecta(int respuesta, int correcta){

        if(respuesta == correcta){
            aciertos++;
            System.out.println("Has acertado la pregunta");
            System.out.println("Aciertos: " +aciertos + " Fallos: "+ fallos);

            return true;
        }else {
            fallos++;
            System.out.println("No has acertado la pregunta");
            System.out.println("Aciertos: " +aciertos + " Fallos: "+ fallos);
            return false;
        }
    }
}
