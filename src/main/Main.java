package main;

import main.exception.PositionNotAvailableException;
import main.tool.file.FileParser;
import main.object.Field;

import java.io.IOException;

/**
 * Class de lancement
 *
 * @author Joris Charlois
 * @version 1.0.0, 23/01/2022
 */

public class Main {

    /**
     * Start
     * @param args lunching args :
     *             - 1 : URI datafile to load
     */
    public static void main(String[] args){
        String uri = "data.txt";
        if (args.length > 0) {
            uri = args[0];
        }
        try {
            FileParser fileParser = new FileParser(uri);
            fileParser.loadData();
            Field field = fileParser.getField();
            field.doAllMoveAllMower();
        } catch (IOException e) {
            System.out.println("ERROR : error during loading file");
        } catch (PositionNotAvailableException e) {
            System.out.println("ERROR : error malformed file, please check");
        } catch (NullPointerException e) {
            System.out.println("ERROR : the file doesn't exist");
        } catch (Exception e) {
            System.out.println("ERROR : an error occured");
        }
    }
}
