/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROG05_Ejerc1;
import java.time.LocalDate;
import java.util.Scanner;
import PROG05_Ejerc1_util.ValidaUtil;
        
/**
 *
 * @author Edu
 * @version 1.0 del 30/01/2020
 */
public class Principal {
    
    
    public static void main(String[] args) {
        /**
         * En la clase main ocurrirá toda nuestra gestión
         * Los de aquí debajo son los atributos del método.
         * opcion: será la opcion seleccionada del menú
         * fin: nos dice si hemos seleccionado la opcion de salida
         * objetoCreado: Nos dice si hemos creado ya el vehiculo o no
         * coche: será nuestro objeto de la clase Vehiculo
         * lectura: es donde almacenamos la lectura de la linea de forma auxiliar
         */
        int opcion;
        boolean fin=false;
        boolean objetoCreado=false;
        Vehiculo coche=null;
        Scanner lectura = new Scanner (System.in);/**Aquí guardaremos la lectura de la linea auxiliarmente*/
        
        
        do {
            /**
             * Utilizamos un do-while para mostrar el menú y que siempre volvamos al menú
             * solamente salimos del bucle cuando hemos seleccionado la opcion de salida
             * del menú, indicada por fin, saldremos cuando fin==true
             */
            opcion=menu(); /**llamamos al método menu(), creado para que todo sea mas claro*/
            switch (opcion) {
                case 1: /**la opcion 1 del menú*/
                    try {/**
                           * Para que todo esté mas claro, el código que intentamos y puede arrojar excepciones
                           * está en el método opcionUno(), al ser muy largo prefería tenerlo así, por claridad
                           * Este método puede arrojar la excepcion en 3 casos, que son que alguna de las condiciones 
                           * del ejercicio se cumpla, es decir, que km sea menor o igual a 0, que la fecha sea posterior
                           * a la actual o que el DNI no sea válido
                           * 
                           * El método devuelve el mismo objeto coche creado, puesto que llama al constructor
                           * dentro del método.
                           */
                        coche=opcionUno();
                        objetoCreado=true;
                    } catch (Exception e) {/**
                                             * Si capturamos la excepcion significa que alguno de los datos no
                                             * son válidos, por tanto, volveremos al menu principal, y nuestra variable 
                                             * objetoCreado será false para no arrastrar datos de un objeto anterior y
                                             * que no se confunda
                                             */
                        System.out.println("Los datos introducidos no son válidos, vuelta al menú principal");
                        objetoCreado=false;
                    }
                    break;
                case 2: /**Opcion 2 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println("La matrícula del vehículo es: "+coche.getMatricula());
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 3:/**Opcion 3 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println("Los kilometros recorridos del vehículo son: "+coche.getKm());
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 4: /**Opcion 4 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println("Introduzca los kilométros recorridos que quiera añadir: ");
                        int auxKm=lectura.nextInt();
                        coche.setKm(auxKm);
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 5: /**Opcion 5 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println("El coche tiene "+coche.getAnios()+" años de antigüedad.");
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 6: /**Opcion 6 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println("El propietario es: "+coche.getNombrePropietario()+" con DNI: "+coche.getDNI());
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 7: /**Opcion 7 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println(coche.getDescripcion());
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 8: /**Opcion 8 del menú, hay un if para no mostrar datos si no se creó el objeto*/
                    if (objetoCreado==true) {
                        System.out.println("El coche tiene un precio de: "+coche.getPrecio());
                    } else {
                        System.out.println("Aún no hay vehículo creado");
                    }
                    break;
                case 9: /**Opcion 9 del menú, aquí seleccionamos la salida y modificamos la variable fin a true*/
                    fin=true;
                    break;
            }
            
        } while (!fin);
        
    }
    
    private static int menu(){
        /**
         * Método que sirve para mostrar el menú del sistema, creado por tener más claridad,
         * se encarga de imprimir el menú por pantalla y se leer la entrada por teclado de la opcion
         * seleccionada, luego devuelve el valor de esa eleccion en tipo int.
         * @return opcion es la opcion elegida por el usuario, tipo int
         */
        Scanner lectura = new Scanner (System.in);/**Aquí guardaremos la lectura de la linea auxiliarmente*/
        int opcion;
        
        System.out.println("--------------------------------");
        System.out.println("Bienvenido al menú:");
        System.out.println("--------------------------------");
        System.out.println("1. Nuevo vehículo.");
        System.out.println("2. Ver matrícula.");
        System.out.println("3. Ver Número de Kilómetros.");
        System.out.println("4. Actualizar Kilómetros.");
        System.out.println("5. Ver años de antiguedad.");
        System.out.println("6. Mostrar propietario.");
        System.out.println("7. Mostrar Descripción.");
        System.out.println("8. Mostrar Precio.");
        System.out.println("9. Salir.");
        System.out.println("--------------------------------");
        System.out.println("Escoja su opción:");
        opcion=lectura.nextInt();
        lectura.nextLine();
        return opcion;
    }
    private static LocalDate conversorFecha(int anioMatriculacion, int mesMatriculacion, int diaMatriculacion){
        /**
         * Método que se encarga de convertir los datos introducidos por el usuario
         * en una fecha del tipo LocalDate
         * @param anioMatriculacion es el año introducido por el usuario, tipo int
         * @param mesMatriculacion es el mes introducido por el usuario, tipo int
         * @param diaMatriculacion es el dia introducido por el usuario, tipo int
         * @return date la fecha formada por los parámetros, de tipo LocalDate
         */
        LocalDate date;
        date=LocalDate.of(anioMatriculacion, mesMatriculacion, diaMatriculacion);
        return date;
    }
    
    private static Vehiculo opcionUno() throws Exception{
        /**
         * método creado para tener las sentencias de la opcion uno y tener mejor visibilidad
         * en el switch, arroja una Exception de manera que si alguno de los datos introducidos
         * no es válido, la Exception nos lo va a indicar y habrá que tratarla en el main
         * Cabe señalar que el metodo llama al constructor de la clase Vehiculo dentro de si
         * mismo y devuelve el objeto creado
         * @return coche es el objeto creado de la clase Vehiculo que devuelve el metodo
         */
        Scanner lectura = new Scanner (System.in);/**Aquí guardaremos la lectura de la linea auxiliarmente*/
        /**
         * A partir de aquí están los atributos locales del método que serán los que formen el
         * objeto coche, todos introducidos por el usuario a excepcion de fechaMatriculacion
         * que es un atributo formado mediante el método conversorFecha con los datos introducidos
         * por el usuario
         */
        String marca;
        String matricula;
        int km;
        int anio;
        int mes;
        int dia;
        LocalDate fechaMatriculacion;
        float precio;
        String nombre;
        String DNI;
        /**
         * A partir de aquí tenemos los atributos que nos darán un control sobre la validez
         * de los datos introducidos por el usuario
         * 
         * Las validaciones se hacen en la Clase ValidaUtil,
         * validoKm nos indicará usando el metodo ValidaUtil.ValidaKm(km) si los km son válidos
         * validoFecha nos indicara usando el metodo ValidaUtil.validaFecha(fechaMatriculacion) si la fecha es valida
         * Este metodo tambien llamará a ValidaUtil.validarNIF(DNI) de manera que tendrá que capturar
         * si hay una excepcion en ese metodo.
         * He decidido que si alguno de los datos no es valido, el metodo lanzará una Exception
         * para que el main sepa que alguno de los datos no es válido y no se siga ejecutando el 
         * metodo.
         * Si no lanza excepcion significa que todos los datos son validos y, por tanto, llama
         * al constructor de la Clase Vehiculo y general el objeto coche que será su
         * @return coche objeto de la clase Vehiculo que se crea si los datos son validos.
         */
        boolean validoKm;
        boolean validoFecha;
        Vehiculo coche;
        
        System.out.println("Creación de nuevo vehículo");
        System.out.println("Introduzca la Marca del vehículo");
        marca=lectura.nextLine();
        System.out.println("Introduzca la matrícula del vehículo");
        matricula=lectura.nextLine();
        /**
         * Aquí comienza la parte donde pedimos los km, para saber si los km son validos
         * llamaremos al metodo ValidaUtil.validaKm(km) que nos dará un boolean que 
         * guardamos auxiliarmente en validoKm, si ese boolean es false, entonces los
         * km no son válido y por tanto arrojamos una Exception
         */
        System.out.println("Introduzca los kilómetros recorridos por el vehículo");
        km=lectura.nextInt();
        lectura.nextLine();
        validoKm=ValidaUtil.validaKm(km);
        if (!validoKm) { 
            System.out.println("Los kilómetros no son válidos");
            throw new Exception();
        }
        /**
         * Aquí comenzamos a pedir los datos de matriculacion del Vehiculo, primero los almacenamos
         * llamamos al metodo conversorFecha(anio,mes,dia) para conseguir un objeto de clase
         * LocalDate que guardamos en fechaMatriculacion de manera que tenemos la fecha
         * esa fecha la mandamos a ValidaUtil.validaFecha(fechaMatriculacion) de manera que obtenemos otro 
         * boolear auxiliar que almacenamos en validoFecha, como en el caso anterior
         * si ese boolean es false, entonces arrojamos una excepcion porque la fecha no es valida
         */
        System.out.println("Introduzca el año de matriculación");
        anio=lectura.nextInt();
        lectura.nextLine();
        System.out.println("Introduzca el mes de matriculación");
        mes=lectura.nextInt();
        lectura.nextLine();
        System.out.println("Introduzca el dia de matriculación");
        dia=lectura.nextInt();
        lectura.nextLine();
        fechaMatriculacion=conversorFecha(anio,mes,dia);
        validoFecha=ValidaUtil.validaFecha(fechaMatriculacion);
        if (!validoFecha) { 
            System.out.println("La fecha no es válida");
            throw new Exception();
        }
        System.out.println("Introduzca el precio del vehículo");
        precio=lectura.nextFloat();
        lectura.nextLine();
        System.out.println("Introduzca el nombre del propietario");
        nombre=lectura.nextLine();
        /**
         * Aquí comenzamos a pedir el dato del DNI del propietario.
         * Una vez leido el dato, lo hacemos validar con ValidaUtil.validarNIF(DNI), de manera
         * que, al ser un metodo void, no tendrá salida, sino que de lo que estamos atentos
         * es de si arroja su excepcion, la atrapamos porque significa que nuestro DNI no es
         * válido.
         * Si el método no arroja excepcion significa que nuestro DNI es valido
         */
        System.out.println("Introduzca el DNI del propietario");
        DNI=lectura.nextLine();
        try {
            ValidaUtil.validarNIF(DNI);
        } catch (Exception e) {
            System.out.println("El DNI no es válido");
            throw new Exception();
        }
        /**
         * Como siempre que hay algún error en los datos leidos lanzamos una excepción en el metodo
         * significa que si hemos llegado a esta linea de codigo, es porque no hay ninguna
         * excepcion lanzada por este metodo y por tanto, todos los datos son validos, por
         * tanto llamamos al constructor de la clase Vehiculo y creamos nuestro Vehiculo coche.
         * El método devuelve este objeto coche de la clase Vehiculo despues de crearlo.
         */
        coche=new Vehiculo(marca,matricula,km,fechaMatriculacion,precio,nombre,DNI);
        return coche;
    }
    
    
}
