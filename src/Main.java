
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Settings settings = new Settings();
        solver.settings(settings);
        settings.cubePos.getFaceletColors();
        Helper helper = new Helper(settings);
        
        helper.print();
        
        solver.mix(settings.cubePos);
        settings.cubePos.getFaceletColors();
        
        helper.print();
        
        solver.setPosition(settings.cubePos, false);
        
        new Thread(solver).start();
        
        while (solver.running){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Exception ignored;
            }
        }
        settings.cubePos.doSequence( settings.generator );
        settings.cubePos.getFaceletColors();
        helper.print();
        helper.pCube();
        
    }
}
