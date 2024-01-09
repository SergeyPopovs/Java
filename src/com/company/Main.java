package com.company;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

                                             //КЛАСС "СКЛАД"
class warehouse_int{
      String [] overproduction=new String[5];     // массив излишек продукции по авто
      boolean duster;
      boolean arkana;
      boolean kaptur;
      boolean terrano;
      boolean nothing=false;
      function_ func=new function_();
      void input_overproduct() {
          System.out.println("Доступны ли излишки на складе по продукции да/нет:");
          System.out.println("Автомобили Duster");
          duster= func.input();                   //метод ввода и преобразования (да-true/нет-false)
          if (duster==true){overproduction[0] = "duster";}
          System.out.println("Автомобили Arkana");
          arkana= func.input();
          if (arkana==true){overproduction[1]="arkana";}
          System.out.println("Автомобили Kaptur");
          kaptur= func.input();
          if (kaptur==true){overproduction[2]="kaptur";}
          System.out.println("Автомобили Terrano");
          terrano= func.input();
          if (terrano==true){overproduction[3]="terrano";}
          if (false) {overproduction[4]="нет";}
          System.out.println("Доступны излишки на складе по продукции: ");
          for (String word : overproduction) {
               if (word != null)                  //вывод списка продукции с излишками
                  System.out.print(word+" ");  }
          System.out.println();
                }
                                               //метод для связи переменной-наименования product типа string и переменной излишек типа boolean
      boolean prod_type(String product) {
          if (product.equals("duster")) {return duster;}
          else if (product.equals("arkana")) {return arkana;}
          else if (product.equals("kaptur")) {return kaptur;}
          else if (product.equals("terrano")) {return terrano;}
          else {return nothing;}
                                        }
                                              //метод для сравнения излишек продукции на складе (массив overproduction) и продукции на конвейерах для ППР(словарь conv_ppr_prod)
      void comparing_prod (Map<String, Integer>conv_ppr_prod,int count_run_conv){
          if(6-count_run_conv==0) {
              System.out.println("Свободных неработающих конвейеров нет, необходимо обратиться к начальнику производства.");
          }else {
             System.out.println("Имеется по меньшей мере один свободный неработающий конвейер в наличии.");
             for (String key :conv_ppr_prod.keySet()) { if(key==null) {continue;}
             if (Arrays.asList(overproduction).contains(key)) {
                System.out.println("Продукция " + key + " имеет излишки на складе, ППР на конвейер # " + conv_ppr_prod.get(key)+
                        " без перенастройки дополнительного конвейера.");
                } else {
                        System.out.println("Продукция " + key + " не имеет излишек на складе,ППР на конвейер # " + conv_ppr_prod.get(key)+
                                " c перенастройкой дополнительного конвейера.");
                                                   }
                                               }
                                           }
                                   }
}
                                           // КЛАСС "РАСПИСАНИЕ"
class schedule_int{
                                          //создаем метод для вычисления необходимости ППР в зависимости от даты прошлого ППР
      boolean main_need (String last_PPR) {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
          LocalDate last_report = LocalDate.parse(last_PPR, formatter);
                                          //прибавим к дате ППР 45 дней и сравним с текущей датой
          LocalDate future_PPR = last_report.plusDays(45);
                                          //инициализация текущей даты
          LocalDate currentDate = LocalDate.now();
                                          //сравним даты последнего ППР и текущую(прошло 45 дней?)
          int result = currentDate.compareTo(future_PPR);
          if (result < 0) { return false;}
          else if (result > 0) { return true;}
          else { return true;}                }
}
                                          //КЛАСС "ДОПОЛНИТЕЛЬНЫЕ ФУНКЦИИ"
class function_ {
      boolean input () {                  //метод ввода и преобразования значения (да-true/нет-false)
         boolean x;
         Scanner scanner=new Scanner(System.in);
         String input = scanner.next();
         if (input.equals("да")) {return x=true;}
            else {return x=false;}
     }
      String input_str() {                 //метод ввода значений типа string
         Scanner scanner=new Scanner(System.in);
         String input_str = scanner.next();
         return input_str;
         }
                                           //метод отображения сводных данных о конвейерах
      void info_1(int count_duster,int count_arkana,int count_kaptur,int count_terrano,int count_run_conv,int count_ppr,int count_over_prod){
          System.out.println("Итого: ");
          System.out.println("Количество конвейеров для cборки авто Duster равно: " + count_duster);
          System.out.println("Количество конвейеров для cборки авто Arkana равно: " + count_arkana);
          System.out.println("Количество конвейеров для cборки авто Kaptur равно: " + count_kaptur);
          System.out.println("Количество конвейеров для cборки авто Terrano равно: " + count_terrano);
          System.out.println("Количество работающих конвейеров для cборки авто равно: " + count_run_conv);
          System.out.println("Количество конвейеров, для которых необходим ППР, равно: " + count_ppr);
          System.out.println("Количество работающих конвейеров, для которых есть излишки на складе, равно: " + count_over_prod);
                                                    }
                                           //метод вывода значений массива типа int
      void array_output(int [] array) {
          for (int i = 1; i <=6; i++) { if (array[i]!=0)
              System.out.print(array[i] + " ");
          }
          System.out.println();
      }
                                           //метод отображения сводных данных о конвейерах
      void info_2(int [] conv_run_over,int [] conv_ppr,int []conv_run,int []conv_Ark,int []conv_Dust,int []conv_Kap,int []conv_Ter){
          System.out.println("Номера конвейеров с продукцией Duster: ");
          array_output(conv_Dust);
          System.out.println("Номера конвейеров с продукцией Arkana: ");
          array_output(conv_Ark);
          System.out.println("Номера конвейеров с продукцией Kaptur: ");
          array_output(conv_Kap);
          System.out.println("Номера конвейеров с продукцией Terrano: ");
          array_output(conv_Ter);
          System.out.println("Номера работающих конвейеров: ");
          array_output(conv_run);
          System.out.println("Номера конвейеров, для которых необходим ППР: ");
          array_output(conv_ppr);
          System.out.println("Номера работающих конвейеров, для которых есть излишки на складе: ");
          array_output(conv_run_over);
          }
                                           //метод отображения сводных данных о конвейерах
      void info_3(){
          System.out.println("Правило проведения ППР конвейера без перенастройки дополнительного конвейера:");
          System.out.println("1.Наличие излишек по данной продукции на складе.");
          System.out.println("2.Наличие по меньшей мере одного свободного неработающего конвейера для быстрой переналадки.");
          System.out.println("================================================================================");
      }
      }
                                            //КЛАСС "КОНВЕЙЕР"
class conveyor_int {
     boolean running;                      //переменная состояния работы конвейера
     String product;                       //переменная продукции выпускаемой на конвейере
     String last_PPR;                      //переменная даты последнего ППР конвейера
     function_ func=new function_();
     schedule_int schedule = new schedule_int();
     boolean input_conv_running(int i){     //метод ввода для переменной running
         System.out.println("Введите данные о конвейере # "+i);
         System.out.print("Конвейер работает (да/нет): ");
         running=func.input();
         return running;
        }
     String input_conv_product(int i){      //метод ввода для переменной product
         System.out.print("Наименование автомобиля собираемого на конвейре # "+i+" (формат ввода: duster): ");
         product= func.input_str();
         return product;
        }
     boolean input_conv_ppr(int i){        //метод ввода даты последнего ППР и вычисления необходимости ППР на данный момент времени
         System.out.println("Введите дату последнего ППР конвейера # "+i+" в формате 'dd.MM.yyyy':");
         last_PPR= func.input_str();       //метод ввода
         boolean PPR_time = schedule.main_need(last_PPR);     //метод определения необходимости ППР
         if (PPR_time == true) {System.out.println("Для конвейера необходим ППР.");return true;}
         else {System.out.println("Для конвейера ППР не требуется.");return false;}
                                 }
                                           //метод определения наличия излишек по продукции выпускаемой на конвейере
     boolean prod_type_overprod(boolean a,int i){
         if (a == true) {
         System.out.println("Продукция авто с конвейера # "+i+" имеет излишки на складе.");return true;}
         else {System.out.println("Продукция авто с конвейера # "+i+" не имеет излишки на складе."); return false;}
                               }
}
                                          //КЛАСС "РЕГЛАМЕНТ"
class rule {
      public static void main(String[] args) {
      System.out.println("================================================================================");
                                          //ввод данных о наличии излишек на складе
      warehouse_int warehouse=new warehouse_int();
      warehouse.input_overproduct();
      System.out.println("================================================================================");
                                          //ввод данных о конвейерах в режиме цикла,преобразуем данные,сортируем,проверяем даты ППР и т.д.
      int count_duster = 0, count_arkana = 0, count_kaptur = 0, count_terrano = 0, count_run_conv = 0, count_ppr = 0,count_over_prod=0;
      conveyor_int[] conv_ = new conveyor_int[7];
      int[]conv_Dust=new int[7];
      int[]conv_Ark=new int[7];
      int[]conv_Kap=new int[7];
      int[]conv_Ter=new int[7];
      int[]conv_run=new int[7];
      int[]conv_ppr=new int[7];
      int[]conv_run_over=new int[7];
      Map<String, Integer> conv_ppr_prod = new HashMap<>();
      for (int i=1;i<7;i++){
      conv_[i] = new conveyor_int();
      conv_[i].input_conv_running(i);
      if (conv_[i].running){count_run_conv++;conv_run[i] =i;}
      conv_[i].input_conv_product(i);
      if(conv_[i].product.equals("duster")){count_duster++;conv_Dust[i] =i;}
      else if(conv_[i].product.equals("arkana")){count_arkana++;conv_Ark[i] =i;}
      else if(conv_[i].product.equals("kaptur")){count_kaptur++;conv_Kap[i] =i;}
      else {count_terrano++;conv_Ter[i] =i;}
      if(conv_[i].prod_type_overprod(warehouse.prod_type(conv_[i].product),i)&&conv_[i].running==true){conv_run_over[i] =i;count_over_prod++;}//добавляем в массив индекс работающего конвейера c излишками
      if (conv_[i].input_conv_ppr(i)==true){conv_ppr[i] =i;count_ppr++;conv_ppr_prod.put(conv_[i].product, i);}//добавляем в массив индекс конвейера для ППР
      System.out.println("--------------------------------------------------------------------------------");
      }
      System.out.println("--------------------------------------------------------------------------------");
                                            //вывод сводной статистики по всем конвейерам и продукции
      function_ func=new function_();
      func.info_1(count_duster,count_arkana,count_kaptur,count_terrano,count_run_conv,count_ppr,count_over_prod);
      func.info_2(conv_run_over,conv_ppr,conv_run,conv_Ark,conv_Dust,conv_Kap,conv_Ter);
      System.out.println("================================================================================");
      func.info_3();
                                           //определение необходимости перенастройки дополнительного конвейера
      warehouse.comparing_prod(conv_ppr_prod,count_run_conv);
      System.out.println("================================================================================");
  }
}














