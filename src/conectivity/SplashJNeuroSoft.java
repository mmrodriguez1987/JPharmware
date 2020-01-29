
package conectivity;

import com.jpackages.jflashplayer.FlashPanel;
import com.jpackages.jflashplayer.FlashPanelListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashJNeuroSoft extends JWindow implements FlashPanelListener {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final int width = 389, height = 180; 
    final int x = (screen.width - width) / 2, y = (screen.height - height) / 2;

    JWindow splash = new JWindow();
    JPanel content = (JPanel) splash.getContentPane();    
    public static Thread thread = new Thread();
    FlashPanel flashPanel;    
    
   public void showSplash(int Duration)
   {

    JWindow splash = new JWindow();
    JPanel content = (JPanel) splash.getContentPane();
    Image imageAlternative = getImageOfString("No Flash", Color.black);
    flashPanel = new FlashPanel(new File("C:\\JPharmware_2.0\\src\\images\\flash\\intro.swf"), imageAlternative, true);
    this.getContentPane().add(flashPanel, BorderLayout.CENTER);
    flashPanel.addFlashPanelListener(this);
    
    splash.setBounds(x, y, width, height);
    content.add(flashPanel, BorderLayout.CENTER);
     
    splash.setVisible(true); 
    try 
    {
        Thread.sleep(Duration);
    } 
    catch (Exception e) {}

    splash.setVisible(false);	
   }
   
   static Image getImageOfString(String s, Color c) {
      BufferedImage myDemoImage = new BufferedImage(300,200,BufferedImage.TYPE_INT_ARGB);
      Graphics2D mygD = (Graphics2D)myDemoImage.getGraphics();
      mygD.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      mygD.setColor(c);
      Font DemoTopFont = new Font("Dialog",Font.BOLD,60);
      mygD.setFont(DemoTopFont);
      mygD.drawString(s,20,120);
      return myDemoImage;
  }
   
   public void FSCommand(String command, String arg) {
    System.out.println("java FSCommand " + command + " " + arg);

    if (command.equals("javaLink")) {
      try {
        Runtime.getRuntime().exec("explorer " + arg);
      } catch (Exception e) {}
    }
    else if (command.equals("javaExecute")) {
      JOptionPane.showMessageDialog(this, "Flash events can be passed along to java");
    }    
  }
}

