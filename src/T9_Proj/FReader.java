package T9_Proj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FReader implements File_Reader {

    String FName;

    public FReader(String FName) {
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
                String str = scan.next();
                Cut cut = new Cut();
                tr.add(cut.Cut_Last(str), 0);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tr;
    }
}
