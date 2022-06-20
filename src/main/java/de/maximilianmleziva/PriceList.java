package de.maximilianmleziva;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PriceList {

    private static final Path DEFAULT_PATH_TO_Price_List =
            Paths.get(System.getProperty("user.home"), ".config", "dnd-currency", "Preisliste.md");
    private static final URL url;

    static {
        try {
            url = new URL("https://raw.githubusercontent.com/dragonempire96/DnD-Currency-Manager/main/Preisliste.md");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static void readPriceList() {
        File file = new File(String.valueOf(DEFAULT_PATH_TO_Price_List));
        if(!Files.exists(DEFAULT_PATH_TO_Price_List)){
            System.out.println("Preisliste.md not found in " + file.getAbsolutePath() + ". Downloading from " + url);
            downloadMD(file);
        }
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(DEFAULT_PATH_TO_Price_List)));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void updatePriceList(){
        File file = new File(String.valueOf(DEFAULT_PATH_TO_Price_List));
        if(!Files.exists(DEFAULT_PATH_TO_Price_List)){
            System.out.println("Preisliste.md not found in " + file.getAbsolutePath());
            return;
        }
        try {
            Files.delete(DEFAULT_PATH_TO_Price_List);
            System.out.println("Updated Preisliste.md in " + file.getAbsolutePath() + ". Downloading from " + url);
            downloadMD(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void downloadMD(File file) {

        try {
            InputStream input = url.openStream();
            FileOutputStream output = new FileOutputStream(file);

            byte[] buffer = new byte[4096];
            int n;
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
            }

            input.close();
            output.close();

            System.out.println("File '" + file + "' downloaded successfully from " + url + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
