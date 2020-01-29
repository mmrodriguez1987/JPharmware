package pictureConfiguration;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

public class ImageFileView extends FileView {
    ImageIcon jpgIcon = Utils.createImageIcon("/images/Imagen_JPG.png");
    ImageIcon gifIcon = Utils.createImageIcon("/images/Imagen_GIF.png");
    ImageIcon tiffIcon = Utils.createImageIcon("/images/Imagen_BMP.png");
    ImageIcon pngIcon = Utils.createImageIcon("/images/Imagen_PNG.png");

    public String getName(File file) {
        return null;
    }

    public String getDescription(File file) {
        return null;
    }

    public Boolean isTraversable(File file) {
        return null;
    }

    public String getTypeDescription(File file) {
        String extension = Utils.getExtension(file);
        String type = null;

        if (extension != null) {
            if (extension.equals(Utils.jpeg) || extension.equals(Utils.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(Utils.gif)){
                type = "GIF Image";
            } else if (extension.equals(Utils.tiff) || extension.equals(Utils.tif)) {
                type = "TIFF Image";
            } else if (extension.equals(Utils.png)){
                type = "PNG Image";
            }
        }
        return type;
    }

    public Icon getIcon(File file) {
        String extension = Utils.getExtension(file);
        Icon icon = null;

        if (extension != null) {
            if (extension.equals(Utils.jpeg) || extension.equals(Utils.jpg)) {
                icon = jpgIcon;
            } else if (extension.equals(Utils.gif)) {
                icon = gifIcon;
            } else if (extension.equals(Utils.tiff) || extension.equals(Utils.tif)) {
                icon = tiffIcon;
            } else if (extension.equals(Utils.png)) {
                icon = pngIcon;
            }
        }
        return icon;
    }
}

