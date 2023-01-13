package test;

import java.util.*;

public class test {
    public static ArrayList<ArrayList<String>>shalve = new ArrayList<>(5);
    public static void main(String[] args) {
//        1. На вход получаем список названий книг
//        2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
//        3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
//        4. Количество полок константное - 5 штук
//        5. Вернуть книги распределенные по полкам

        ArrayList<ArrayList<String>> shalves = new ArrayList<>(5);
        ArrayList<String> shalfe1 = new ArrayList<>();
        ArrayList<String> shalfe2 = new ArrayList<>();
        ArrayList<String> shalfe3 = new ArrayList<>();
        ArrayList<String> shalfe4 = new ArrayList<>();
        ArrayList<String> shalfe5 = new ArrayList<>();
//        shalfe1.add()
        shalve.add(shalfe1);
        shalve.add(shalfe2);
        shalve.add(shalfe3);
        shalve.add(shalfe4);
        shalve.add(shalfe5);
        ArrayList<String> books = new ArrayList<>();
        books.add("War and Peace");
        books.add("Tom and Soyer");
        books.add("Dads and sons");
        books.add("Harry potter");
        books.add("Lord of the rings");
        books.add("Matrix");
        books.add("Mortal combat");
        books.add("The Walking dead");
        books.add("Marvel");
        books.add("Spider man");
        books.add("Batman");
        books.add("Iron man");
        books.add("Kingsman");
        books.add("Star wars");
        books.add("Star wars episode 1");
        books.add("Star wars episode 2");
        books.add("Star wars episode 3");
        books.add("Star wars episode 4");
        books.add("Star wars episode 5");
        books.add("Star wars episode 6");
        System.out.println(books);
        float howMuch = books.size()/5;
        System.out.println(howMuch);
        Collections.sort(books);
        System.out.println(books);
        System.out.println(books.get(0));
        System.out.println(books.get(1));
        System.out.println(shalve.get(0));
        System.out.println(shalve.get(0).size());
        addBook(books);
        System.out.println(shalve);
        System.out.println(shalve.get(0));
        System.out.println(shalve.get(1));
        System.out.println(shalve.get(2));
        System.out.println(shalve.get(3));
        System.out.println(shalve.get(4));
        System.out.println(books.size());
    }

    public static void addBook(List<String> book) {
        float howMuch =Math.round( book.size()/shalve.size());
        for (String s : book) {
            if (shalve.get(0).size() < howMuch + 1) {
                shalve.get(0).add(s);
            } else if (shalve.get(1).size() < howMuch) {
                shalve.get(1).add(s);
            } else if (shalve.get(2).size() < howMuch) {
                shalve.get(2).add(s);
            } else if (shalve.get(3).size() < howMuch) {
                shalve.get(3).add(s);
            } else if (shalve.get(4).size() < howMuch) {
                shalve.get(4).add(s);
            } else {
                shalve.get(4).add(s);
            }
        }
        int count = shalve.get(0).size()+shalve.get(1).size()+shalve.get(2).size()+shalve.get(3).size()+shalve.get(4).size();
        System.out.println("Всего на полках " + count +  " книг:" + '\n' +
                "На 1 полке " + shalve.get(0).size() + " книги и на ней лежат: " + shalve.get(0) + '\n'+
                "На 2 полке " + shalve.get(1).size() + " книги и на ней лежат: " + shalve.get(1) + '\n'+
                "На 3 полке " + shalve.get(2).size() + " книги и на ней лежат: " + shalve.get(2) + '\n'+
                "На 4 полке " + shalve.get(3).size() + " книги и на ней лежат: " + shalve.get(3) + '\n'+
                "На 5 полке " + shalve.get(4).size() + " книги и на ней лежат: " + shalve.get(4) + '\n');
    }
}
