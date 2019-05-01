package com.artem.training;

import org.apache.log4j.Logger;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class AllMethods {

    private static org.apache.log4j.Logger logger = Logger.getLogger(AllMethods.class);


    static <T> Predicate<T> distinctByKey(
            Function<? super T, Object> keyExtractor) {
        Map<Object, String> map = new ConcurrentHashMap<>();
        return t -> map.put(keyExtractor.apply(t), "") != null;
    }


    List<User> getSameChildrenName(List<User> parents) {
        List<User> sameChildrenName = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap(p -> p.getChildren().stream()).filter(distinctByKey(User::getName)).collect(Collectors.toList());
        logger.info("23. * Получить список детей с одинаковым именем используя 1 стрим: \n" + sameChildrenName);
        return sameChildrenName;
    }


    Map<User, Integer> getMapWithKeyParentValueAgeTheOldestChild(List<User> parents) {
        Map<User, Integer> mapWithKeyParentValueListNameChildren = parents
                .stream().filter((p) -> p.getChildren() != null)
                .collect(Collectors.toMap(user -> user, t -> t.getChildren().stream().mapToInt(User::getAge).max().getAsInt()));
        mapWithKeyParentValueListNameChildren.forEach((k, v) -> logger.info("22. Получить Map, где ключом будет родитель, а значение - возраст самого старшего ребенка: \n" + k + " " + v));
        return mapWithKeyParentValueListNameChildren;
    }


    Map<User, List<String>> getMapWithKeyNameParentValueListNameChildren(List<User> parents) {
        Map<User, List<String>> mapWithKeyParentValueListNameChildren = parents
                .stream().filter((p) -> p.getChildren() != null)
                .collect(Collectors.toMap(user -> user, t -> t.getChildren().stream().map(User::getName).collect(Collectors.toList())));
        mapWithKeyParentValueListNameChildren.forEach((k, v) -> logger.info("21. Получить Map, где ключом будет родитель, а значение - список имен детей: \n" + k + " " + v));
        return mapWithKeyParentValueListNameChildren;
    }


    Map<Long, List<User>> getMapWithKeyIdValueListChildren(List<User> parents) {
        Map<Long, List<User>> mapWithKeyIdValueListChildren = parents
                .stream().filter((p) -> p.getChildren() != null)
                .collect(Collectors.toMap(User::getId, t -> t.getChildren()));
        mapWithKeyIdValueListChildren.forEach((k, v) -> logger.info("20. Получить Map, где ключом будет id родителя, а значение - список детей:\n" + k + " " + v));
        return mapWithKeyIdValueListChildren;
    }


    String getNameParentsStringWithСommas(List<User> parents) {
        String nameParentsString = parents
                .stream().map(User::getName).collect(Collectors.joining(", "));
        logger.info("19. Получить строку, состоящую из имен родителей, разделенных запятыми: " + nameParentsString);
        return nameParentsString;
    }


    List<User> getChildrenSortedByAgeNumberFrom_To_(List<User> parents, int k, int n) {
        List<User> childrenSortedByAgeNumberFrom_To_ = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).sorted(Comparator.comparingInt(User::getAge)).skip(k).limit(n).collect(Collectors.toList());
        logger.info("18. Получить из списка детей, отсортированных по возрасту, список детей c " + k + "-го по " + (k + n - 1) + "-й: \n" + childrenSortedByAgeNumberFrom_To_);
        return childrenSortedByAgeNumberFrom_To_;
    }


    List<User> getAllChildrenSortedByAgeAndByName(List<User> parents) {
        List<User> allChildrenSortedByAgeAndByName = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream())
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getName)).collect(Collectors.toList());
        logger.info("17. Получить список всех детей, отсортированых по возрасту и по имени: \n" + allChildrenSortedByAgeAndByName);
        return allChildrenSortedByAgeAndByName;
    }


    Long getCountAllParentsSomeAge(List<User> parents, int k, int n) {
        long countAllParentsSomeAge = parents
                .stream().filter((p) -> p.getAge() > k && p.getAge() < n).count();
        logger.info("16. Получить количество родителей от " + k + " до " + n + ": " + countAllParentsSomeAge);
        return countAllParentsSomeAge;
    }


    long getFirstIdChildren(List<User> parents, int n) {
        try {
            long firstIdNameChildren = parents
                    .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).filter((p) -> p.getAge() < n).map(User::getId).findFirst().get();
            logger.info("15. Получить первое ид ребенка, возраст которого меньше " + n + " : " + firstIdNameChildren);
            return firstIdNameChildren;
        } catch (NoSuchElementException e) {
            logger.info("Нет такого ребенка, возраст которого меньше " + n + " Ошибка: " + e);
        }
        return 0;
    }



    String getNameParentsFirstMoreThanAge(List<User> parents, int k) {
        String nameParentsFirstMoreThanAge = parents
                .stream().filter((p) -> p.getAge() > k).map(User::getName).findFirst().orElse("None");
        logger.info("14. Получить первое имя родителя, возраст которого больше " + k + " лет: " + nameParentsFirstMoreThanAge);
        return nameParentsFirstMoreThanAge;
    }


    int getAgeParentsMultiplication(List<User> parents) {
        int ageParentsMultiplication = parents
                .stream().mapToInt(User::getAge).reduce((s1, s2) -> s1 * s2).getAsInt();
        logger.info("13. Получить произведение всех возрастов родителей: " + ageParentsMultiplication);
        return ageParentsMultiplication;
    }


    double getAgeChildrenAverage(List<User> parents) {
        double ageChildrenAverage = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt(User::getAge).average().getAsDouble();
        logger.info("12. Получить средний возраст всех детей: " + ageChildrenAverage);
        return ageChildrenAverage;
    }


    int getAgeChildrenMin(List<User> parents) {
        int ageChildrenMin = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt(User::getAge).min().getAsInt();
        logger.info("11. Получить минимальный возраст ребенка: " + ageChildrenMin);
        return ageChildrenMin;
    }


    int getAgeParentsMax(List<User> parents) {
        if (parents.size() == 0)
            return 0;
        else {
            int ageParentsMax = parents
                    .stream().mapToInt(User::getAge).max().getAsInt();
            logger.info("10. Получить максимальный возраст родителя: " + ageParentsMax);
            return ageParentsMax;
        }
    }

    boolean getAreThereAllChildrenYoungerThan(List<User> parents, int k) {
        if (parents.size() == 0)
            return false;
        else {
            boolean areThereAllChildrenYoungerThan = parents
                    .stream().filter((p) -> p.getChildren() != null).flatMap((p) -> p.getChildren().stream()).allMatch((p) -> p.getAge() < k);
            logger.info("9. Получить boolean, все ли дети младше " + k + " лет: " + areThereAllChildrenYoungerThan);
            return areThereAllChildrenYoungerThan;
        }
    }


    boolean getAreThereSomeChildrenOlderThan(List<User> parents, int k) {
        boolean areThereSomeChildrenOlderThan = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((p) -> p.getChildren().stream()).anyMatch((p) -> p.getAge() > k);
        logger.info("8. Получить boolean, есть ли дети старше " + k + " лет: " + areThereSomeChildrenOlderThan);
        return areThereSomeChildrenOlderThan;
    }


    List<String> getUniqueChildrenName(List<User> parents) {
        List<String> uniqueChildrenName = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).map(User::getName).distinct().collect(Collectors.toList());
        logger.info("7. Cписок уникальных имен детей:\n" + uniqueChildrenName);
        return uniqueChildrenName;
    }


    List<User> getChildrenYoungerThan(List<User> parents, int n) {
        List<User> childrenYoungerThan = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).filter((o) -> o.getAge() < n).collect(Collectors.toList());
        System.out.println("6. Cписок всех детей, младше" + n + " лет:\n" + childrenYoungerThan);
        return childrenYoungerThan;
    }


    List<User> getChildrenSortedByAge(List<User> parents) {
        List<User> childrenSortedByAge = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
        logger.info("5. Cписок всех детей, отсортированный по возрасту:\n" + childrenSortedByAge);
        return childrenSortedByAge;
    }


    int getSumAgeChildren(List<User> parents) {
        int sumAgeChildren = parents
                .stream().filter((p) -> p.getChildren() != null).flatMap((o) -> o.getChildren().stream()).mapToInt(User::getAge).sum();
        logger.info("4. Сумма возрастов детей: " + sumAgeChildren);
        return sumAgeChildren;
    }


    int getCountAllChildren(List<User> parents) {
        int countAllChildren = parents
                .stream().filter((p) -> p.getChildren() != null).mapToInt((p) -> p.getChildren().size()).sum();
        logger.info("3. Количество всех детей: " + countAllChildren);
        return countAllChildren;
    }


    long getCountParentsAgeOlderThan(List<User> parents, int n) {
        long countParentsAgeOlderThan = parents
                .stream().filter((p) -> p.getAge() > n).count();
        logger.info("2. Kоличество родителей старше " + n + " : " + countParentsAgeOlderThan);
        return countParentsAgeOlderThan;
    }


    int getAgeParentsSum(List<User> parents) {
        int ageParentsSum = parents
                .stream().mapToInt(User::getAge).sum();
        logger.info("1. Сумма возрастов родителей: " + ageParentsSum);
        return ageParentsSum;
    }
}



