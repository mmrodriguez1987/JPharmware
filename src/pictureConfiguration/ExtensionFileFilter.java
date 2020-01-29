/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pictureConfiguration;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ExtensionFileFilter extends FileFilter {
  String description;

  String extensions[];

  public ExtensionFileFilter(String description, String extension) {
    this(description, new String[] { extension });
  }

  public ExtensionFileFilter(String description, String extensions[]) {
    String descriptionfiles; 
      if (description == null) {      
       descriptionfiles = "{ " + extensions[0] +" }";
       for(int i = 1 ; i < extensions.length; i++)
       descriptionfiles += " { ".concat(extensions[i])+" } ";            
      this.description =  descriptionfiles+"{ " + extensions.length + "} ";
      } else {                 
      this.description = description;
    }
   this.extensions = (String[]) extensions.clone();
    toLower(this.extensions);
  } 

  private void toLower(String array[]) {
    for (int i = 0, n = array.length; i < n; i++) {
      array[i] = array[i].toLowerCase();
    }
  }

  public String getDescription() {
    return description;
  }

  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    } else {
      String path = file.getAbsolutePath().toLowerCase();
      for (int i = 0, n = extensions.length; i < n; i++) {
        String extension = extensions[i];
        if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
          return true;
        }
      }
    }
    return false;
  }

}


