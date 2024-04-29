/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;

/** 
 * @author Pablo Jiménez de Lara
 * @version 29/04/2024/A
 */
public class Apuesta {

   /**
    * Acceso a variable goles_local
    * @return La cantidad de goles marcados por el equipo local
    */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Sobreescritura manual para la variable goles_local
     * @param goles_local Cantidad de goles marcados por el equipo local
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * Acceso a variable goles_local
     * @return Cantidad de goles marcados por el equipo visitante
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Sobreescritura manual para la variable goles_visitante
     * @param goles_visitante Cantidad de goles marcados por el equipo visitante
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Acceso a variable apostado
     * @return Cantidad apostada
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Sobreescritura manual para la variable apostado
     * @param apostado Cantidad apostada
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /**
     * Constructor por defecto de la clase
     */
    /*Contructor por defecto*/
    public Apuesta() {
    }

    /**
     * Constructor con parámetros de la clase
     * @param dinero_disp Dinero dispuesto
     * @param goles_local Goles del equipo local
     * @param goles_visitante Goles del equipo visitante
     */
    /*Contructor con parámetros*/
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    
    /**
     * Acceso a variable apostado
     * @return Dinero dispuesto
     */
    /*Método para obtener el valor del atributo dinero_disp*/
    public int getDinero_disp() {
        return dinero_disp;
    }

    /**
     * Sobreescritura manual para la variable apostado
     * @param dinero_disp Dinero dispuesto
     */
    /*Método para modificar el valor del atributo dinero_disp*/
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para subir una apuesta, debe de ser mayor de un euro y no se puede apostar más de lo que tienes
     * @param dinero Dinero apostado
     * @throws java.lang.Exception
     */
    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    
    /**
     * Método para comprobar los resultados, los goles no pueden ser menor que cero
     * @param local Cantidad de goles del equipo local
     * @param visitante Cantidad de goles del equipo visitante
     * @return Devuelve si la apuesta a sido ganadora
     * @throws java.lang.Exception
     */
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /**
     * Método para cobrar la apuesta
     * @param cantidad_goles_local Cantidad de goles del equipo local
     * @param cantidad_goles_visit Cantidad de goles del equipo visitante
     * @throws java.lang.Exception
     */
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}