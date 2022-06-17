package de.maximilianmleziva;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.io.IOUtils.close;

class TextFile {
    private static final Path DEFAULT_PATH_TO_TEMP =
            Paths.get(System.getProperty("user.home"), ".config", "dnd-currency", "currency.txt");

    static void write(HashMap<String, List<Integer>> map) {
        try {
            if(Files.exists(DEFAULT_PATH_TO_TEMP)){
                Files.delete(DEFAULT_PATH_TO_TEMP);
            } else{
                Files.createDirectories(DEFAULT_PATH_TO_TEMP.getParent());
            }
            Files.createFile(DEFAULT_PATH_TO_TEMP);
            File file = new File(String.valueOf(DEFAULT_PATH_TO_TEMP));
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                bf.write(entry.getKey() + ":" + entry.getValue());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void read() {
        HashMap<String, List<Integer>> map = new HashMap<>();

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(DEFAULT_PATH_TO_TEMP)));
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(":");

                String name = parts[0].trim();
                String numberList = parts[1].trim();

                String[] list = numberList.substring(1,numberList.length()-1).split(",");

                List<Integer> number = new ArrayList<>();
                for (String s : list) {
                    number.add(Integer.parseInt(s.trim()));
                }
                map.put(name, number);
               if (!name.equals("") && !number.toString().equals("")){
                   map.put(name, number);
               }


            }
            close(br);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CurrencyMap.setMap(map);
    }
}
