
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windows
 */
public class Helper {
    private Settings settings;
    private Scanner sc = new Scanner(System.in);
    private String input = "";
    
    public Helper(Settings s){
        settings=s;
    }
    
    public void setInput(){
        input = sc.next();
    }
    
    public String getInput(){
        return input;
    }
    
    public void print(){
        
        int c=9;
        for(int i=0;i<3;i++){
            System.out.print("      ");
            for(int j=0;j<3;j++){
                System.out.print(settings.cubePos.faceletColor[c]);
                System.out.print(" ");
                c++;
            }
            System.out.println();
        }
        
        c=0;
        for(int k=0;k<3;k++){
            for(int j=0;j<3;j++){    
                System.out.print(settings.cubePos.faceletColor[c+j]);
                System.out.print(" ");
            }
            for(int j=18;j<21;j++){    
                System.out.print(settings.cubePos.faceletColor[c+j]);
                System.out.print(" ");
            }
            for(int j=36;j<39;j++){    
                System.out.print(settings.cubePos.faceletColor[c+j]);
                System.out.print(" ");
            }
            for(int j=45;j<48;j++){    
                System.out.print(settings.cubePos.faceletColor[c+j]);
                System.out.print(" ");
            }
            System.out.println();
            c+=3;
        }
        
        c=27;
        for(int i=0;i<3;i++){
            
            System.out.print("      ");
            for(int j=0;j<3;j++){
                System.out.print(settings.cubePos.faceletColor[c]);
                System.out.print(" ");
                c++;
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    public void pCube(){
        for(int i=0;i<26;i++){
            
            System.out.print(settings.cubePos.cubeletPerm[i]+"_");
        }
    }
}
