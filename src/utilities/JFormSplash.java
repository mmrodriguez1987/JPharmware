

package utilities;
import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.*;
import utilities.Utils.*;

public class JFormSplash {
 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
 int width = 0, height = 0; 
 int Xm = 0, Ym = 0;

 public static JProgressBar ProgressBar = new JProgressBar();
public static Thread tread = new Thread();

 public void setWidth(int w)
 {
  this.width = w;
 }
 
 public int getWidth()
 {
 return width;
 }
 
 public void setHeight(int h)
 {
  this.height = h;
}
 
 public int getHeight()
 {
 return height;
 }
 public int setXm(int w)
 {
  setWidth(w);
  Xm = (screen.width - getWidth()) / 2;
  return Xm;
 }
 
 public int setYm(int h)
 {
  setHeight(h);   
  Ym = (screen.height - getHeight());
  return Ym;
 }
 
 public void Load()
 {
   ProgressBar.setVisible(true);
            try {
                int min = 0, max = 100, i = min;
                
                ProgressBar.setValue(min);
                ProgressBar.setMinimum(min);
                ProgressBar.setMaximum(max);
                ProgressBar.setVisible(false);
                
                for( i=min; i <= max; i++ ) {
                    ProgressBar.setValue( i );
                    // linea.setBounds(5,280,i*4,10);
                    try {
                        tread.sleep(140);
                        if(i >= 0 && i <= 24) {
                       //     loading.setText("Loading Datas ... "+i+"%");
                        Utils.Console("Loading Datas ... "+i+"%");    
                        }
                        if(i >= 25 && i <= 49) {
                       //    loading.setText("Loading Storages ... "+i+"%");
                       //    javacup.setBounds(455,60,133,200);
                        Utils.Console("Loading Storages ... "+i+"%");
                            
                        }
                        if(i >= 50 && i <= 73) {
                       //     loading.setText("Loading Modules ... "+i+"%");
                       //     javacup.setVisible(true);
                        Utils.Console("Loading Modules ... "+i+"%");    
                        }
                        if(i >= 74 && i <= 99) {
                       //     loading.setText("Loading Components ... "+i+"%");
                        Utils.Console("Loading Components ... "+i+"%");    
                        }
                        if(i == 100) {
                       //    loading.setText("Loading Information Completed!");
                        Utils.Console("Loading Information Completed!");    
                        }
                    } catch(InterruptedException ie){}
                }     
            } catch(Exception mi){}
 }
   
 public void showSplash(int Duration, int h, int w, String Sound) {

		JWindow Splash = new JWindow();
		JPanel ConteinerPanel = (JPanel) Splash.getContentPane();
		
                this.setXm(w); this.setYm(h); this.setWidth(w); this.setHeight(h);
                
                Splash.setBounds(Xm,this.Ym, width,height);
//	   	panel.setLayout(null);
//		label2.setBounds(0,0,631,328);
//		loading.setBounds(415,270,310,30);
             
//		loading.setFont(new java.awt.Font("Papyrus", 1, 12));
//		loading.setForeground(Color.white);
		
//              panel.add(linea);
//		panel.add(label2);
//		content.add(loading);
//              content.add(javacup);
//              ProgressBar.setBounds(15,280,300,10);
//              ConteinerPanel.add(panel);
		ConteinerPanel.add(ProgressBar);		
		ConteinerPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));
                Splash.setVisible(true);
               
                Utils.PlaySound(Sound);
		try {
			Load();
			Thread.sleep(Duration);
		} catch (Exception e) {
		}
                
		Splash.setVisible(false);
	}
}

