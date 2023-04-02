package Task_IZ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
   public static void main(String[] args) {
      Notebook notebook1 = new Notebook("Asus", "4", "1000", "Windows", "grey");
      Notebook notebook2 = new Notebook("Asus", "4", "1000", "Lunex", "black");
      Notebook notebook3 = new Notebook("Asus", "4", "2000", "Windows", "black");
      Notebook notebook4 = new Notebook("Asus", "16", "1000", "Windows", "grey");
      Notebook notebook5 = new Notebook("Huawei", "8", "1000", "Windows", "black");

      Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
            notebook3, notebook4, notebook5));

      Map<String, String> sel = selectCriteria();
      sort(sel, notebooks);

   }

   public static String scanner() {
      Scanner scanner = new Scanner(System.in);
      String scan = scanner.nextLine();
      return scan;
   }

   public static Map<String, String> selectCriteria() {
      Map<String, String> resultCriterias = new HashMap<>();
      while (true) {
         System.out.println("Хотите выбрать критерий?  да 'y', нет 'n'");
         String question = scanner();
         if (question.equals("n")) {
            break;
         } else {

            System.out.println("1 - Производитель");
            System.out.println("2 - ОЗУ");
            System.out.println("3 - Объем жесткого диска");
            System.out.println("4 - Операционная система");
            System.out.println("5 - Цвет");
            System.out.println("Введите цифру, соответствующую критерию:");
            String key = scanner();
            System.out.println("Введите значения для выбранного критерия: ");
            String value = scanner();

            resultCriterias.put(key, value);
         }
      }
      System.out.println(resultCriterias);
      return resultCriterias;

   }

   public static void sort(Map<String, String> criterias, Set<Notebook> notebooks) {

      Set<Notebook> temp = new HashSet<>(notebooks);
      for (Notebook notebook : notebooks) {

         for (Object pair : criterias.keySet()) {

            if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
               temp.remove(notebook);
            }
            for (Object pair1 : criterias.keySet()) {

               if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                  temp.remove(notebook);

               }
               for (Object pair2 : criterias.keySet()) {

                  if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                     temp.remove(notebook);

                  }
                  for (Object pair3 : criterias.keySet()) {

                     if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                        temp.remove(notebook);

                     }
                     for (Object pair4 : criterias.keySet()) {

                        if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                           temp.remove(notebook);

                        }
                     }
                  }
               }
            }
         }

      }
      if (temp.isEmpty()) {
         System.out.println("Нет ноутбуков, удовлетворяющих критериям фильтрации.");
      } else {
         System.out.println("Найдено ноутбуков, удовлетворяющих критериям фильтрации: \n" + temp.toString());
      }

   }

}
