import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


    public List<Sportwear> ReadFile(String url) throws Exception{
        List<Sportwear> candys = new ArrayList<>();
        File file = new File(url);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);
        int coutLine = 1;
        String line;
        Sportwear sportwear = null;
        while ((line = br.readLine()) != null){
            switch (coutLine){
                case 1 :
                    sportwear = new Sportwear();
                    sportwear.setId(Integer.parseInt(line));
                    break;
                case 2:
                    sportwear.setName(line);
                    break;
                case 3:
                    sportwear.setTotal(Integer.parseInt(line));
                    break;
                case 4:
                    sportwear.setPrice(Integer.parseInt(line));
                    candys.add(sportwear);
                    sportwear = null;
                    coutLine = 0;
                    break;
            }
            coutLine++;
        }

        br.close();
        fr.close();
        return candys;
    }

    public boolean saveFile(List<Sportwear> cadys, String url){
        File file = new File(url);
        String content = "";
        for (int i =0; i < cadys.size(); i++){
            if (i == cadys.size() -1){
                content += cadys.get(i).getId() +"\n" + cadys.get(i).getName()
                        + "\n" + cadys.get(i).getTotal() + "\n" + cadys.get(i).getPrice();
            }else {
                content += cadys.get(i).getId() +"\n" + cadys.get(i).getName()
                        + "\n" + cadys.get(i).getTotal() + "\n" + cadys.get(i).getPrice() + "\n";
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            if (!file.exists()){
                file.createNewFile();
            }
            byte[] contentInByte = content.getBytes();
            fos.write(contentInByte);
            fos.flush();
            fos.close();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
