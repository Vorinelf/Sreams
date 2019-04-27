package com.artem.training;

import java.util.*;
import java.util.stream.Collectors;


class AllMethods {


    void getMapWithKeyParentValueAgeTheOldestChild(List<User> parents) {
        System.out.println("22. Получить Map, где ключом будет родитель, а значение - возраст самого старшего ребенка: ");
        Map mapWithKeyParentValueListNameChildren = parents
                .stream().filter((p) -> p.getChildren() != null)
                .collect(Collectors.toMap(user -> user, t -> t.getChildren().stream().mapToInt(p -> p.getAge()).max()));
        mapWithKeyParentValueListNameChildren.forEach((k, v) -> System.out.println(k + " " + v));


    }


    void getMapWithKeyNameParentValueListNameChildren(List<User> parents) {
        System.out.println("21. Получить Map, где ключом будет родитель, а значение - список имен детей: ");
        Map mapWithKeyParentValueListNameChildren = parents
                .stream().filter((p) -> p.getChildren() != null)
                .collect(Collectors.toMap(user -> user, t -> t.getChildren().stream().map(User::getName).collect(Collectors.toList())));
        mapWithKeyParentValueListNameChildren.forEach((k, v) -> System.out.println(k + " " + v));


    }


    void getMapWithKeyIdValueListChildren(List<User> parents) {
        System.out.println("20. Получить Map, где ключом будет id родителя, а значение - список детей: ");
        Map<Long, List<User>> mapWithKeyIdValueListChildren = parents
                .stream().filter((p) -> p.getChildren() != null)
                .collect(Collectors.toMap(User::getId, t -> t.getChildren()));
        mapWithKeyIdValueListChildren.forEach((k, v) -> System.out.println(k + " " + v));


    }

    public void getNameParentsStringWithСommas(List<User> parents) {
        String nameParentsString = parents
                .stream().map(User::getName).collect(Collectors.joining(", "));

        System.out.println("19. Получить строку, состоящую из имен родителей, разделенных запятыми: " + nameParentsString);
    }


    void getNameChildrenSortedByAgeNumberFrom_To_(List<User> parents, int k, int n) {
        System.out.println("18. Получить из списка детей, отсортированных по возрасту, список детей c " + k + "-го по " + (k + n) + "-й");
        parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).sorted(Comparator.comparingInt(User::getAge)).map(User::getName).skip(k).limit(n)
                .forEach(System.out::println);
    }


    public void getAllChildrenSortedByAgeAndByName(List<User> parents) { //доделать, разобраться с сортировкой
        System.out.println("17. Получить список всех детей, отсортированых по возрасту и по имени:");

        List<List<User>> listChildrenSortedByName = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream())
                .sorted((o1, o2) -> o1.getName() != o2.getName() ? o1.getName().compareTo(o2.getName()) : (User::getAge));
        System.out.println(listChildrenSortedByName);

    }


    void getCountAllParentsSomeAge(List<User> parents, int k, int n) {
        long countAllParentsSomeAge = parents
                .stream().filter((p) -> p.getAge() > k && p.getAge() < n).count();
        System.out.println("16. Получить количество родителей от" + k + " до " + n + ": " + countAllParentsSomeAge);
    }


    void getFirstIdChildren(List<User> parents, int n) {
        try {
            Optional firstIdNameChildren = parents
                    .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).filter((p) -> p.getAge() < n).map(User::getId).findFirst();

            System.out.println("15. Получить первое ид ребенка, возраст которого меньше " + n + " : " + firstIdNameChildren.get());
        } catch (NoSuchElementException e) {
            System.out.println("Нет такого ребенка, возраст которого меньше " + n + " Ошибка: " + e);
        }
    }


    void getNameParentsFirstMoreThanAge(List<User> parents, int k) {
        String nameParentsFirstMoreThanAge = parents
                .stream().filter((p) -> p.getAge() > k).map(User::getName).findFirst().orElse("None");
        System.out.println("14. Получить первое имя родителя, возраст которого больше " + k + " лет: " + nameParentsFirstMoreThanAge);
    }


    void getAgeParentsMultiplication(List<User> parents) {
        OptionalInt ageParentsMultiplication = parents
                .stream().mapToInt(User::getAge).reduce((s1, s2) -> s1 * s2);
        System.out.println("13. Получить произведение всех возрастов родителей: " + ageParentsMultiplication.getAsInt());
    }


    OptionalDouble getAgeChildrenAverage(List<User> parents) {
        OptionalDouble ageChildrenAverage = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt(User::getAge).average();
        System.out.println("12. Получить средний возраст всех детей: " + ageChildrenAverage.getAsDouble());
        return ageChildrenAverage;
    }


    void getAgeChildrenMin(List<User> parents) {
        OptionalInt ageChildrenMin = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt(User::getAge).min();
        System.out.println("11. Получить минимальный возраст ребенка: " + ageChildrenMin.getAsInt());
    }


    void getAgeParentsMax(List<User> parents) {
        OptionalInt ageParentsMax = parents
                .stream().mapToInt(User::getAge).max();
        System.out.println("10. Получить максимальный возраст родителя: " + ageParentsMax.getAsInt());
    }

    void getAreThereAllChildrenYongerThan(List<User> parents, int k) {
        boolean areThereAllChildrenOlderThan = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((p) -> p.getChildren().stream()).allMatch((p) -> p.getAge() < k);
        System.out.println("9. Получить boolean, все ли дети младше " + k + " лет: " + areThereAllChildrenOlderThan);
    }


    void getAreThereSomeChildrenOlderThan(List<User> parents, int k) {
        boolean areThereSomeChildrenOlderThan = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((p) -> p.getChildren().stream()).anyMatch((p) -> p.getAge() > k);
        System.out.println("8. Получить boolean, есть ли дети старше " + k + " лет: " + areThereSomeChildrenOlderThan);
    }


    void getUniqueChildrenName(List<User> parents) {
        System.out.println("7. Cписок уникальных имен детей:");
        parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).map(User::getName).distinct()
                .forEach(System.out::println);
    }


    void getNameChildrenYoungeThan(List<User> parents, int n) {
        System.out.println("6. Cписок всех детей младше" + n + " лет:");
        parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).filter((o) -> o.getAge() < n).map(User::getName)
                .forEach(System.out::println);
    }


    void getNameChildrenSortedByAge(List<User> parents) {
        System.out.println("5. Cписок всех детей, отсортированный по возрасту:");
        parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).sorted(Comparator.comparingInt(User::getAge)).map(User::getName)
                .forEach(System.out::println);
    }


    void getSumAgeChildren(List<User> parents) {
        int sumAgeChildren = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt(User::getAge).sum();
        System.out.println("4. Сумма возрастов детей: " + sumAgeChildren);
    }


    void getCountAllChildren(List<User> parents) {
        int countAllChildren = parents
                .stream().filter((p) -> p.getChildren() != null).mapToInt((p) -> p.getChildren().size()).sum();
        System.out.println("3. Количество всех детей: " + countAllChildren);
    }


    void getCountParentsAgeOlderThan(List<User> parents, int n) {
        long countParentsAgeOlderThan = parents
                .stream().filter((p) -> p.getAge() > n).count();
        System.out.println("2. Kоличество родителей старше " + n + " : " + countParentsAgeOlderThan);
    }


    void getAgeParentsSum(List<User> parents) {
        int ageParentsSum = parents
                .stream().mapToInt(User::getAge).sum();
        System.out.println("1. Сумма возрастов родителей: " + ageParentsSum);
    }


}



