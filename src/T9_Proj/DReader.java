package T9_Proj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DReader implements File_Reader {

    String FName;

    public DReader(String FName) {
        this.FName = FName;
    }

    @Override
    public Tries read() {

        FName += ".txt";
        File file = new File(FName);
        Tries tr = new Tries();

        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                Cut cut = new Cut();
                Object[] word_digit = new Object[2];
                word_digit = cut.Cut_Digit(str);
                tr.add(word_digit[0].toString(), (int) word_digit[1]);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tr;
    }
}
