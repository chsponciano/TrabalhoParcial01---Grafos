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
        String t;
        t = "10 11\nB A\nEntrada A\nB GT\nGT H\nH *\nB *\n* C\nC I\nI D\nC D\nD Saida";
        t = "16 20\nEntrada A\nA F\nF C\nC B\nB D\nC D\nF J\nJ H\nH G\nJ G\nJ *\n* I\nI L\nL M\nM K\nK Saida\nA K\nC E\nE I\nI M";
        Grafo g = new Grafo();
        g.montarGrafo(t);
        System.out.println("Total: " + g.buscar());
    }
    
}
