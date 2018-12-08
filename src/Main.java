import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "src/source.txt";
    private static Scanner mScanner;
    private static List<Sportwear> candys;
    private static FileManager mFileManager;
    private static boolean question = true;

    public static void main(String[] args) throws Exception{
        mScanner = new Scanner(System.in);
        mFileManager = new FileManager();
        candys = mFileManager.ReadFile(FILE_PATH);
        while (question){
            question();
        }
    }

    private static void question() throws Exception{
        System.out.println("\n\n\n");
        System.out.println("--------- Sportwear Manager ---------");
        System.out.println("Chọn câu trả lời ......");
        System.out.println("1. Xem tất cả sản phẩm đang có");
        System.out.println("2. Thêm sản phẩm mới");
        System.out.println("3. Nhập thêm hàng");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. quit");
        System.out.print("Number: ");
        int answer = mScanner.nextInt();
        checkFunction(answer);
    }

    private static void checkFunction(int answer) throws Exception{
        switch (answer){
            case 1:
                candys = mFileManager.ReadFile(FILE_PATH);
                System.out.println("*** Tất cả sản phẩm đang có:");
                printData(candys);
                break;
            case 2:
                System.out.println("*** Thêm sản phẩm mới: ");
                addNewProduct(candys);
                break;
            case 3:
                System.out.println("*** Nhập thêm hàng: ");
                addTotal(candys);
                break;
            case 4:
                System.out.println("*** Xóa sản phẩm");
                delete(candys);
                break;
            case 5:
                question = false;
                break;
            default:
                System.out.println("Không có nhiệm vụ! Vui lòng thử lại...");
                break;
        }
    }

   private static void printData(List<Sportwear> candys){
        for (Sportwear model : candys){
            System.out.println(model.toString());
        }
   }

   private static void addNewProduct(List<Sportwear> candys){
       System.out.println("\n\nThêm sản phẩm mới:");
       int id = 0;
        if (candys.size() != 0){
            id = candys.get(candys.size() -1).getId();
        }
        mScanner = new Scanner(System.in);
       System.out.println("Tên sản phẩm: ");
       String name = mScanner.nextLine();

       mScanner = new Scanner(System.in);
       System.out.println("Số lượng: ");
       int total = mScanner.nextInt();

       mScanner = new Scanner(System.in);
       System.out.println("Giá trên mỗi sản phẩm (VND): ");
       int price = mScanner.nextInt();

       System.out.println("Bạn muốn thêm sản phẩm \"" + name + "\" không (y/n)");
       String answer = mScanner.next();
       if (answer.equals("y")){
           Sportwear model = new Sportwear(id += 1, name, total, price);
           candys.add(model);

           if (mFileManager.saveFile(candys, FILE_PATH)) System.out.println("Thêm sản phẩm thành công!");
       }
   }

   private static void addTotal(List<Sportwear> candys){
       System.out.println("*** Bạn muốn nhập hàng vào sản phẩm nào: ");
        for (int i = 0; i < candys.size(); i++){
            System.out.println((i + 1) + ". " + candys.get(i).getName());
        }
       System.out.print("Number: ");
        int answer = mScanner.nextInt();
        if (answer >= candys.size()){
            System.out.print("Bạn muốn thêm bao nhiêu hàng: ");
            int total = mScanner.nextInt();
            if (total > 0) candys.get(answer - 1).setTotal(candys.get(answer - 1).getTotal() + total);
            if (mFileManager.saveFile(candys, FILE_PATH)) System.out.println("Thêm số lượng thành công!");
        }else {
            System.out.println("-> Bạn chọn số không có trong danh sách");
        }
   }

   private static void delete(List<Sportwear> candys){
       System.out.println("Bạn muốn xóa sản phẩm nào: ");
       for (int i = 0; i < candys.size(); i++){
           System.out.println((i + 1) + ". " + candys.get(i).getName());
       }
       System.out.print("Number: ");
       int answer = mScanner.nextInt();
       if (answer >= candys.size()){
           candys.remove(answer - 1);
           if (mFileManager.saveFile(candys, FILE_PATH)) System.out.println("Xóa sản phẩm thành công!");
       }

   }
}
