/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG05_Ejerc1_util;

import java.time.LocalDate;

/**
 *
 * @author Edu
 */
public class ValidaUtil {
    
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    public static boolean validaKm(int km){
        /**
         * método estatico que valida si los km son validos o no
         * @param km el numero que queremos comprobar, tipo int
         * @return <code> verdadero </code> si el dato km es mayor que cero
         * @return <code> falso </code> si el dato km es menor o igual a cero
         */
        boolean validez=true;
        if (km<=0) {
            validez=false;
        }
        return validez;
    }
    
    public static boolean validaFecha(LocalDate fechaMatriculacion){
        /**
         * metodo que comprueba si la fecha de matriculacion es anterior a la actual.
         * @param fechaMatriculacion que es la fecha que queremos comprobar
         * @return <code> verdadero </code> si la fecha es correcta y es anterior a la actual
         * @return <code> falso </code> si la fecha es incorrecta y es posterior a la actual
         */
        boolean fechaValida;
        LocalDate fechaHoy=LocalDate.now();
        fechaValida=fechaMatriculacion.isAfter(fechaHoy);
        return !fechaValida;
    }
    
    private static char calcularLetraNIF(int dni) {
        /**
         * el metodo calcula la letra que deberia tener el DNI dado
         * @param dni, el numero del dni que queremos comprobar, tipo int
         * @return letra, la letra correspondiente a ese numero, tipo char
         */
        char letra;
        // Cálculo de la letra NIF
        letra = LETRAS_DNI.charAt(dni % 23);
        // Devolución de la letra NIF
        return letra;
    }

    private static char extraerLetraNIF(String nif) {
        /**
         * metodo que extrae la letra del nif introducido
         * @param nif, el nif del que extraer la letra
         * @return letra, un char con la letra en mayúsucula
         */
        char letra = nif.charAt(nif.length() - 1);
        //return letra;
        return Character.toUpperCase(letra); //Devolvemos su equivalente en mayúscula para poder comparar con las letras de la cadena LETRAS_DNI
    }

    private static int extraerNumeroNIF(String nif) {
        /**
         * metodo que extrae el numero del nif introducido
         * @param nif, el nif del que extraer el numero
         * @return numero, el numero del nif, tipo int
         */
        int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));
        return numero;
    }

    public static void validarNIF(String nif) throws Exception {
        /**
         * método que da excepciones si el nif no es valido, siempre da la misma excepcion
         * de modo que en Principal no sabremos por cual de las 3 formas no es valido, solo
         * sabremos que no lo es. El metodo no devuelve nada, por tanto si no salta excepcion sabremos que funciona
         * bien
         * @param nif es el DNI que queremos examinar
         * Lanza excepcion cuando el DNI no es valido
         * 
         */
        char letra_calculada;
        char letra_leida;
        int dni_leido;

        if (nif == null) {  // El parámetro debe ser un objeto no vacío
            
            throw new Exception();

        } else if (nif.length() < 8 || nif.length() > 9) {    // La cadena debe estar entre 8(7+1) y 9(8+1) caracteres
            
            throw new Exception();

        } else {
            letra_leida = extraerLetraNIF(nif);    // Extraemos la letra de NIF (letra)
            dni_leido = extraerNumeroNIF(nif);  // Extraemos el número de DNI (int)
            letra_calculada = calcularLetraNIF(dni_leido);  // Calculamos la letra de NIF a partir del número extraído
            if (letra_leida != letra_calculada) {   // Comparamos la letra extraída con la calculada
                throw new Exception ();
            }
        }
        
    }
}
