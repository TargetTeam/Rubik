
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windows
 */
public class Main {
    public static void main(String[] args) {
        
        Solver solver = new SolverKociemba();
        Scanner sc = new Scanner(System.in);
        Settings settings = new Settings();
        CubePosition cube = settings.cubePos; 
        solver.settings(settings);
        cube.getFaceletColors();
        Helper helper = new Helper(settings);
        int f = 0;
        int q = 0;
        String option ="n";
        
        System.out.println("Cubo armado");
        helper.print();
        
        System.out.println("Cubo revuelto");
        
        solver.mix(cube);
        cube.getFaceletColors();
        helper.print();
        
        solver.setPosition(cube, false);
        
        new Thread(solver).start();
        
        while (solver.running){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Exception ignored;
            }
        }
        
        MoveSequence generator = settings.generator;
        settings.cubePos.doSequence( generator );
        
        System.out.println( "SOLUCION: " + generator.toString(true) );
        
        System.out.println("Cada letra representa una cara del cubo:\n"
                + "L: Izquierda, U: Arriba, F: Frente, R: Derecha, D: Abajo, B: Atrás\n\n"
                + "La letra sola indica que se debe rotar la cara a la derecha.\n"
                + "La letra acompañada del simbolo \' indica rotar la cara indicada a la izquierda.\n"
                + "La letra acompañada del número 2 indica que se debe rotar 2 veces la cara.\n"
                + "La letra acompañada de la letra \'s\' indica que se rota el centro de la cara a la derecha, o los costados de esa cara al mismo tiempo para lograr el mismo resultado sin alterar los centros"
                + "\n\n");
        
        System.out.println( "¿Ver ejecución de pasos? [s/n]:");
        option = sc.next();
        if(option.equals("s")) new Thread(helper).start();
        while(helper.running){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Exception ignored;
            }
        } 
    }
}
