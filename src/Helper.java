
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windows
 */
public class Helper implements Runnable{
    private Settings settings;
    private String input = "";
    private char[] faces = {'L','U','F','R','D','B'};
    private CubePosition cube;
    private int f,q,seqPos,sollen;
    public boolean running = false;
    
    
    public Helper(Settings s){
        settings=s;
        cube=settings.cubePos;
    }
    
    public String getInput(){
        return input;
    }
    
    public void print(){
        
        int c=9;
        
        System.out.println();
        for(int i=0;i<3;i++){
            System.out.print("      ");
            for(int j=0;j<3;j++){
                System.out.print(faces[settings.cubePos.faceletColor[c]]);
                System.out.print(" ");
                c++;
            }
            System.out.println();
        }
        
        c=0;
        for(int k=0;k<3;k++){
            for(int j=0;j<3;j++){    
                System.out.print(faces[settings.cubePos.faceletColor[c+j]]);
                System.out.print(" ");
            }
            for(int j=18;j<21;j++){    
                System.out.print(faces[settings.cubePos.faceletColor[c+j]]);
                System.out.print(" ");
            }
            for(int j=27;j<30;j++){    
                System.out.print(faces[settings.cubePos.faceletColor[c+j]]);
                System.out.print(" ");
            }
            for(int j=45;j<48;j++){    
                System.out.print(faces[settings.cubePos.faceletColor[c+j]]);
                System.out.print(" ");
            }
            System.out.println();
            c+=3;
        }
        
        c=36;
        for(int i=0;i<3;i++){
            
            System.out.print("      ");
            for(int j=0;j<3;j++){
                System.out.print(faces[settings.cubePos.faceletColor[c]]);
                System.out.print(" ");
                c++;
            }
            System.out.println();
        }
        
        System.out.println();
    }

    @Override
    public void run() {
        running=true;
        
        MoveSequence generator = settings.generator;
        seqPos=generator.getLength();
        sollen=seqPos;
        while(seqPos>0){
            seqPos--;
            f=generator.getMoves()[seqPos];
            q=generator.getAmount()[seqPos];
            System.out.println("Paso "+(sollen-seqPos)+":");
            settings.cubePos.doMove(f, 4-q, true);
            cube.getFaceletColors();
            print();
        }
        running=false;
    }
    
}
