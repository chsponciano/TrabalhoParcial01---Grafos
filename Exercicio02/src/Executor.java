/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Executor {    
    public static void main(String[] args) {
        String t = "10 11\nB A\nEntrada A\nB GT\nGT H\nH *\nB *\n* C\nC I\nI D\nC D\nD Saida";
        Grafo g = new Grafo();
        g.montarGrafo(t);
        g.buscar();
    }
    
}
