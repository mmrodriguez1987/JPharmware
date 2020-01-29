
package utilities;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Utils {

    public static void MyDialog(String message,String title,String image,String sound)
    {
      PlaySound(sound);
     JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE,new javax.swing.ImageIcon("C:\\JPharmware_2.0\\src\\images\\dialogs\\"+image));	
    }
    
     public static void PlaySound(String sound)
    {
       
        
       File FileSound = new File("C:\\JPharmware_2.0\\src\\sounds\\"+sound);
       AudioFileFormat AFF;
       AudioInputStream AIS;
       
       try
       {
       AFF = AudioSystem.getAudioFileFormat(FileSound);
       AIS = AudioSystem.getAudioInputStream(FileSound);
       AudioFormat af = AFF.getFormat();				

        DataLine.Info info = new DataLine.Info(
        Clip.class,
        AIS.getFormat(),
        ((int) AIS.getFrameLength() *
        af.getFrameSize()));

        Clip ol = (Clip) AudioSystem.getLine(info);
        ol.open(AIS); ol.loop(0);  		
        }
        catch(Exception e1){}      
    }
     
    public static void Console(String message)
    {
     System.out.println(message);
    }
    
    public static Double Round(double quantity)
   {
     double roundquantity = quantity;

      roundquantity = roundquantity*100; 
      roundquantity = Math.floor(roundquantity);

      if(roundquantity%10 > 5 && roundquantity%10 < 9)
      {
            roundquantity += 1;
      }
      roundquantity = roundquantity/100;

      return roundquantity;
    }

}
