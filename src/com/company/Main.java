package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
//        writeUserToFile();
        readUserFromFile();

    }

    public static void readUserFromFile() throws IOException {
        Map<String, String> map = new HashMap();
        User user = new User();
        List<String> list = new ArrayList<>();
        String fileName = "C:/stud/user.txt" ;
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("},\n");
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        for (String s : list) {
            String[] temp = s.replace("\"", "").replace("{", "").replace("}", "").split(",");
            for (int i = 0; i < temp.length; i++) {
                String[] r = temp[i].split(":");
                map.put(r[0], r[1]);
            }
            user.setId(Long.parseLong(map.get("userID")));
            user.setUserName(map.get("username"));
            user.setFirstName(map.get("Firstname"));
            user.setSecondName(map.get("SecondName"));
            user.setLastName(map.get("LastName"));
            user.setUserMail(map.get("UserMail"));
            user.setUserPassword(map.get("UserPassword"));
            System.out.println(user.toString());
        }
//        scanner.useDelimiter(",");

//        while (scanner.hasNext()) {
//            String[] s = scanner.next().replace("\"", "").replace("{", "").replace("}", "").split(":");
//            map.put(s[0], s[1]);
//        }
//
//        user.setId(Long.parseLong(map.get("userID")));
//        user.setUserName(map.get("username"));
//        user.setFirstName(map.get("Firstname"));
//        user.setSecondName(map.get("SecondName"));
//        user.setLastName(map.get("LastName"));
//        user.setUserMail(map.get("UserMail"));
//        user.setUserPassword(map.get("UserPassword"));
//        System.out.println(user.toString());
    }

    public static void writeUserToFile() throws IOException {
        File file = new File("C:/stud/user.txt");
        User user = new User();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ник");
        user.setUserName(scan.nextLine());
        System.out.println("Введите Имя");
        user.setFirstName(scan.nextLine());
        System.out.println("Введите Фамилия");
        user.setSecondName(scan.nextLine());
        System.out.println("Введите Отчество");
        user.setLastName(scan.nextLine());
        System.out.println("Введите вашу почту");
        user.setUserMail(scan.nextLine());
        System.out.println("Введите Пароль");
        user.setUserPassword(scan.nextLine());
        generateId(user);

        if (file.length() == 0) {
            Files.write(Paths.get(file.getPath()), user.toString().getBytes(), StandardOpenOption.APPEND);
        } else {
            String usr = ",\n" ;
            usr += user.toString();
            Files.write(Paths.get(file.getPath()), usr.getBytes(), StandardOpenOption.APPEND);
        }

//        writer.write(user.toString());
//        System.out.println(user.toString());

    }

    public static void generateId(User user) {
        long x = 1L;
        long y = 23456789L;
        Random r = new Random();
        long userID = x + ((long) (r.nextDouble() * (y - x)));
        user.setId(userID);

    }
//    public static void userID() {
//        long x = 1234567L;
//        long y = 23456789L;
//        Random r = new Random();
//        long userID = x + ((long) (r.nextDouble() * (y - x)));
//        System.out.println(userID);
//    }


//    public static void txtFile() throws IOException {
//        FileReader reader = new FileReader("C:/stud/stud.txt");
//        FileWriter writer = new FileWriter("C:/stud/stud2.txt");
//        BufferedReader read = new BufferedReader(reader);
//        while (read.ready()) {
//            writer.write(read.readLine());
//        }
//        reader.close();
//        writer.close();
//    }
//     }
//   public static void Random() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите первое число");
//        int nums1 = Integer.parseInt(reader.readLine());
//        System.out.println("Введите второе число");
//        int nums2 = Integer.parseInt(reader.readLine());
//        int rand = nums1 + (int) (Math.random() * nums2);
//        System.out.println(rand);
//
//        Random random = new Random();
//        System.out.println(random.nextInt(nums2));
//
//    }
//
//
//    public static void userWord() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Ведите предложение");
//        String[] word2 = reader.readLine().split(" ");
//
//        for (int i = 0; i < word2.length; i++) {
//            System.out.println(word2[i]);
//        }
//
//    }
//
//    public static void user() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите предложение или букву");
//        String word = reader.readLine();
//        System.out.println("Введите число повторений");
//        int j = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < j; i++) {
//            System.out.println(word);
//
//
//        }
//    }
//
//
//    public static void calc2() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите число:");
//        String s = reader.readLine();
//        String[] nums = s.split("");
//
//        int[] nums2 = new int[3];
//
//        for (int i = 0; i < nums.length; i++) {
//            nums2[i] = Integer.parseInt(nums[i]);
//        }
//        int a = nums2[0];
//        int b = nums2[1];
//        int c = nums2[2];
//        if (a < b && b < c) {
//            System.out.println("Число восходящее");
//        } else if (a > b && b > c) {
//            System.out.println("Число нисходящее");
//        } else System.out.println("среднее число");
//    }
//
//
//      for(int )
//        int length = s.length();
//        if (length > 0) {
//            int[] digits = new int[length];
//            for (int i = 0; i < length; i++) {
//                digits[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
//            }
//            for (int i = 0; i < digits.length; i++) {
//                System.out.print(digits[i]);
//                if (a < b || b < c) {
//                    System.out.println("Число восходящее");
//                } else System.out.println("Число нисходящее");
//
//            }
//        }
//
//
//    public static void calc() {
//        while (true) {
//            double a;
//            double b;
//            double c;
//            char symb;
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Введите два числа");
//            try {
//                a = scanner.nextDouble();
//                b = scanner.nextDouble();
//            } catch (InputMismatchException e) {
//                System.out.println("Ввели не число");
//                continue;
//            }
//
//
//            System.out.println("Введите знак равенства");
//            symb = scanner.next().charAt(0);
//            switch (symb) {
//                case '+':
//                    c = a + b;
//                    break;
//                case '-':
//                    c = a - b;
//                    break;
//                case '/':
//                    c = a / b;
//                    break;
//                case '*':
//                    c = a * b;
//                    break;
//                default:
//                    System.out.println("Ошибка введённого знака");
//                    return;
//            }
//            System.out.print("\n Результат \n");
//            System.out.println(a + "" + symb + "" + b + "=" + c);
//            parsing(c);
//        }
//    }
//
//
//    public static void parsing(double c) {
//        String str = String.valueOf(c);
//        String[] numb = str.split("\\.");
//        int i = Integer.parseInt(numb[1]);
//        if (i > 0) {
//            System.out.println(c);
//        } else System.out.println((int) c);
//    }
}






