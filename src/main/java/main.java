import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Vui lòng nhập một số nguyên từ 0 đến 9: ");
//        String input = scanner.nextLine();
//        int number=-1;
//        String pattern = "[0-9]";
//        if (input.matches(pattern)) {
//            number= Integer.parseInt(input);
//        } else {
//            while (input.matches(pattern)==false)
//            {
//                System.out.print("Bạn đã nhập sai lựa chọn. Vui lòng nhập lại:");
//                 input = scanner.nextLine();
//            }
//            number=Integer.parseInt(input);
//        }
//        switch (number)
//        {
//            case 1:
//                System.out.println("th1");
//                break;
//            case 2:
//                System.out.println("th2");
//                break;
//            case 0:
//                break;
//        }
//        System.out.println("hahah");

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập một số từ 0-9: ");
//        String input = scanner.nextLine();
//        int a;
//        // Kiểm tra số nhập vào có chỉ chứa kí tự từ 0-9 hay không
//        if (input.matches("[0-9]+")) {
//            System.out.println("Số " + input + " hợp lệ.");
//            a= Integer.parseInt(input);
//            int c=a+5;
//            System.out.println(c);
//        } else {
//            System.out.println("Số " + input + " không hợp lệ.");
//        }
        //try{}
        int a=scanner.nextInt();
        System.out.println(a);

    }
}
