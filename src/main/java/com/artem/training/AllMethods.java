package com.artem.training;

import java.util.*;


class AllMethods {


    {


//        System.out.println("6. Cписок всех детей до 10 лет:");
//        parents
//                .stream().filter((p) -> p.getChildren() != null).flatMap((p) -> p.getChildren().stream().filter((m) -> m.getAge() <= 10).map(((m)->m.getName())))
//                .forEach((p) -> System.out.println(p));


    }


    public void getFirstIdChildren(List<User> parents, int n) {
        try {
            Optional firstIdNameChildren = parents
                    .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).filter((p) -> p.getAge() < n).map((p) -> p.getId()).findFirst();
            System.out.println("15. Получить первое ид ребенка, возраст которого меньше " + n + " : " + firstIdNameChildren.get());
        } catch (NoSuchElementException e) {
            System.out.println("Нет такого ребенка, возраст которого меньше " + n + " Ошибка: " + e);
        }

    }


    public void getNameParentsFirstMoreThanAge(List<User> parents, int k) {
        String nameParentsFirstMoreThanAge = parents
                .stream().filter((p) -> p.getAge() > k).map((p) -> p.getName()).findFirst().orElse("None");
        System.out.println("14. Получить первое имя родителя, возраст которого больше " + k + " лет: " + nameParentsFirstMoreThanAge);
    }


    public void getAgeParentsMultiplication(List<User> parents) {
        OptionalInt ageParentsMultiplication = parents
                .stream().mapToInt((p) -> p.getAge()).reduce((s1, s2) -> s1 * s2);
        System.out.println("13. Получить произведение всех возрастов родителей: " + ageParentsMultiplication.getAsInt());
    }


    public OptionalDouble getAgeChildrenAverage(List<User> parents) {
        OptionalDouble ageChildrenAverage = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt((l) -> l.getAge()).average();
        System.out.println("12. Получить средний возраст всех детей: " + ageChildrenAverage.getAsDouble());
        return ageChildrenAverage;
    }


    public void getAgeChildrenMin(List<User> parents) {
        OptionalInt ageChildrenMin = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt((l) -> l.getAge()).min();
        System.out.println("11. Получить минимальный возраст ребенка: " + ageChildrenMin.getAsInt());
    }


    public void getAgeParentsMax(List<User> parents) {
        OptionalInt ageParentsMax = parents
                .stream().mapToInt((p) -> p.getAge()).max();
        System.out.println("10. Получить максимальный возраст родителя: " + ageParentsMax.getAsInt());
    }


    public void getNameChildren(List<User> parents) {//доделать, выводит всегда false
        boolean ageMore17 = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((p) -> p.getChildren().stream()).map((n) -> n.getAge()).allMatch("1"::equals);
        System.out.println("8. Получить boolean, есть ли дети старше 17: " + ageMore17);
    }


    public void getUniqueChildrenName(List<User> parents) {
        System.out.println("6. Cписок уникальных имен детей:");
        parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).map((n) -> n.getName()).distinct()
                .forEach((p) -> System.out.println(p));
    }


//    public void getNameChildrenSortedByAge(List<User> parents) { // не работает, доделать
//        parents
//                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream().sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge())).map((p) -> p.getName()))
//                .forEach((p) -> System.out.println("5. Cписок всех детей, отсортированный по возрасту:" + p));
//    }


    public void getSumAgeChildren(List<User> parents) {
        int sumAgeChildren = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt((l) -> l.getAge()).sum();
        System.out.println("4. Сумма возрастов детей: " + sumAgeChildren);
    }


    public void getCountAllChildren(List<User> parents) {
        int countAllChildren = parents
                .stream().filter((p) -> p.getChildren() != null).mapToInt((p) -> p.getChildren().size()).sum();
        System.out.println("3. Количество всех детей: " + countAllChildren);
    }


    public void getCountParentsAgeOlderThen(List<User> parents, int n) {
        long parentsAgeOld27 = parents
                .stream().filter((p) -> p.getAge() > n).count();
        System.out.println("2. Kоличество родителей старше " + n + " : " + parentsAgeOld27);
    }


    public void getAgeParentsSum(List<User> parents) {
        int ageParentsSum = parents
                .stream().mapToInt((p) -> p.getAge()).sum();
        System.out.println("1. Сумма возрастов родителей: " + ageParentsSum);
    }


}



