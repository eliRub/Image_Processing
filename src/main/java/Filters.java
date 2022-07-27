import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Filters {

    public Filters (BufferedImage image , int number) throws IOException {

        Color color1;
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel);
                switch (number){
                    case 1:
                        color1 = blackAndWhite(color);
                        image.setRGB(x,y,color1.getRGB());
                        break;
                    case 2:
                        image.setRGB(width -x -1 ,y , color.getRGB() );
                        break;
                    case 3:
                        color1 = colorShiftRight(color);
                        image.setRGB(x,y,color1.getRGB());
                        break;
                    case 4:
                        color1 = colorShiftLeft(color);
                        image.setRGB(x,y,color1.getRGB());
                        break;
                    case 5:
                        color1 = eliminate(color);
                        image.setRGB(x,y,color1.getRGB());
                        break;
                    default:
                        color1 = ligher(color);
                        image.setRGB(x,y,color1.getRGB());
                        break;
                }


            }
        }
        System.out.println("d");

        File output = new File("C:\\Users\\User\\OneDrive\\שולחן העבודה\\image\\src\\main\\java\\image205.jpg");
        ImageIO.write(image,"png",output);

    }

    public Color blackAndWhite (Color color){
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        int average = (red + green + blue) / 3;
        return new Color(average , average , average);
    }

    public Color colorShiftRight (Color color){
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        return new Color(green,blue,red);
    }

    public Color colorShiftLeft (Color color){
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        return new Color(blue , red , green);
    }

    public Color eliminate (Color color){

        Random random = new Random();
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

       int chosen = random.nextInt(3);

        return switch (chosen) {
            case 0 -> new Color(0, green, blue);
            case 1 -> new Color(red, 0, blue);
            default -> new Color(red, green, 0);
        };
    }

    public Color ligher (Color color){
        int red = intenseColor(color.getRed(),1.2);
        int green = intenseColor(color.getGreen(),1.2);
        int blue = intenseColor(color.getBlue(),1.2);

        return new Color(red , green , blue);
    }

    public static int intenseColor (int original, double by){
        original *= by;
        if (original>255){
            original =255;
        }
        return original;
    }

}
