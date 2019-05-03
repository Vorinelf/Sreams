package com.artem.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestAllMethods {

    AllMethods allMethods = new AllMethods();

    private final List<User> listEmptyForTest = new ArrayList<>();
    private final boolean resultListIsEmpty = true;

    public List<User> getListEmptyForTest() {
        return listEmptyForTest;
    }
    boolean isResultListIsEmpty() {
        return resultListIsEmpty;
    }

    List<User> getTestListOfParents() {
        List<User> childrenAnna = new ArrayList<>();
        childrenAnna.add(new User(1, 8, "Mike"));
        childrenAnna.add(new User(2, 4, "Dave"));
        User anna = new User(1, 32, "Anna", childrenAnna);

        List<User> childrenBob = new ArrayList<>();
        childrenBob.add(new User(3, 4, "Sam"));
        User bob = new User(2, 30, "Bob", childrenBob);

        User steve = new User(3, 20, "Steve", null);

        User сolin = new User(4, 45, "Bob", null);

        List<User> childrenLuk = new ArrayList<>();
        childrenLuk.add(new User(4, 11, "Mike"));
        childrenLuk.add(new User(5, 6, "Tad"));
        User luk = new User(5, 30, "Luk", childrenLuk);


        List<User> testListOfParents = new ArrayList<>();
        testListOfParents.add(anna);
        testListOfParents.add(bob);
        testListOfParents.add(steve);
        testListOfParents.add(сolin);
        testListOfParents.add(luk);

        return testListOfParents;
    }

    @Test
    public void testGetAgeParentsSum() throws Exception {
        int expectResult = 157;
        int methodResult = allMethods.getAgeParentsSum(getTestListOfParents());
        Assert.assertEquals(expectResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getAgeParentsSum(listEmptyForTest);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetCountParentsAgeOlderThan() throws Exception {
        int parentsOlder = 30;
        long expectResult = 2;
        long methodResult = allMethods.getCountParentsAgeOlderThan(getTestListOfParents(), parentsOlder);
        Assert.assertEquals(expectResult, methodResult);

        long expectResultEmpty = 0;
        long methodResultEmpty = allMethods.getCountParentsAgeOlderThan(getListEmptyForTest(), parentsOlder);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetCountAllChildren() throws Exception {
        int expectResult = 5;
        int methodResult = allMethods.getCountAllChildren(getTestListOfParents());
        Assert.assertEquals(expectResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getCountAllChildren(getListEmptyForTest());
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetSumAgeChildren() throws Exception {
        int expectResult = 33;
        int methodResult = allMethods.getSumAgeChildren(getTestListOfParents());
        Assert.assertEquals(expectResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getSumAgeChildren(getListEmptyForTest());
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetChildrenSortedByAge() throws Exception {
        List<User> expectedResultTop = new ArrayList<>();
        expectedResultTop.add(getTestListOfParents().get(0).getChildren().get(1));
        List<User> expectedResultLow = new ArrayList<>();
        expectedResultLow.add(getTestListOfParents().get(4).getChildren().get(0));
        List<User> methodResult = allMethods.getChildrenSortedByAge(getTestListOfParents());
        Assert.assertEquals(expectedResultTop.get(0).getName(), methodResult.get(0).getName());
        Assert.assertEquals(expectedResultLow.get(0).getName(), methodResult.get(4).getName());

        List<User> methodResultEmpty = allMethods.getChildrenSortedByAge(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetChildrenYoungerThan() throws Exception {
        int olderThan = 6;
        int expectedCountChildren = 2;
        List<User> methodResult = allMethods.getChildrenYoungerThan(getTestListOfParents(), olderThan);
        Assert.assertEquals(expectedCountChildren, methodResult.size());

        List<User> methodResultEmpty = allMethods.getChildrenYoungerThan(getListEmptyForTest(), olderThan);
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetUniqueChildrenName() throws Exception {
        int expectedCountUniqueNameChildren = 4;
        List<String> methodResult = allMethods.getUniqueChildrenName(getTestListOfParents());
        Assert.assertEquals(expectedCountUniqueNameChildren, methodResult.size());

        List<String> methodResultEmpty = allMethods.getUniqueChildrenName(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetAreThereSomeChildrenOlderThan() throws Exception {
        int olderThanFirst = 8;
        int olderThanSecond = 11;
        boolean expectedResultTrue = true;
        boolean expectedResultFalse = false;
        boolean expectedResultEmpty = false;

        boolean methodResultTrue = allMethods.getAreThereSomeChildrenOlderThan(getTestListOfParents(), olderThanFirst);
        Assert.assertEquals(expectedResultTrue, methodResultTrue);

        boolean methodResultFalse = allMethods.getAreThereSomeChildrenOlderThan(getTestListOfParents(), olderThanSecond);
        Assert.assertEquals(expectedResultFalse, methodResultFalse);

        boolean methodResultEmpty = allMethods.getAreThereSomeChildrenOlderThan(getListEmptyForTest(), olderThanFirst);
        Assert.assertEquals(expectedResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetAreThereAllChildrenYoungerThan() throws Exception {
        int youngerThanFirst = 12;
        int youngerThanSecond = 6;
        boolean expectedResultTrue = true;
        boolean expectedResultFalse = false;
        boolean expectedResultEmpty = false;

        boolean methodResultTrue = allMethods.getAreThereAllChildrenYoungerThan(getTestListOfParents(), youngerThanFirst);
        Assert.assertEquals(expectedResultTrue, methodResultTrue);

        boolean methodResultFalse = allMethods.getAreThereAllChildrenYoungerThan(getTestListOfParents(), youngerThanSecond);
        Assert.assertEquals(expectedResultFalse, methodResultFalse);

        boolean methodResultEmpty = allMethods.getAreThereAllChildrenYoungerThan(getListEmptyForTest(), youngerThanSecond);
        Assert.assertEquals(expectedResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetAgeParentsMax() throws Exception {
        int expectedResult = 45;

        int methodResult = allMethods.getAgeParentsMax(getTestListOfParents());
        Assert.assertEquals(expectedResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getAgeParentsMax(getListEmptyForTest());
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetAgeChildrenMin() throws Exception {
        int expectedResult = 4;

        int methodResult = allMethods.getAgeChildrenMin(getTestListOfParents());
        Assert.assertEquals(expectedResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getAgeChildrenMin(getListEmptyForTest());
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetAgeChildrenAverage() throws Exception {
        double expectedResult = 6.6;

        double methodResult = allMethods.getAgeChildrenAverage(getTestListOfParents());
        Assert.assertEquals(expectedResult, methodResult, 0.01);

        double expectResultEmpty = 0;
        double methodResultEmpty = allMethods.getAgeChildrenAverage(getListEmptyForTest());
        Assert.assertEquals(expectResultEmpty, methodResultEmpty, 0.01);
    }

    @Test
    public void getAgeParentsMultiplication() throws Exception {
        long expectedResult = 25920000;

        long methodResult = allMethods.getAgeParentsMultiplication(getTestListOfParents());
        Assert.assertEquals(expectedResult, methodResult);

        long expectResultEmpty = 0;
        long methodResultEmpty = allMethods.getAgeParentsMultiplication(getListEmptyForTest());
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetNameParentsFirstMoreThanAge() throws Exception {
        int olderThanFirst = 29;
        int olderThanSecond = 46;
        String expectedResultFirst = "Anna";
        String expectedResultSecond = "None";
        String methodResultFirst = allMethods.getNameParentsFirstMoreThanAge(getTestListOfParents(), olderThanFirst);
        Assert.assertEquals(expectedResultFirst, methodResultFirst);
        String methodResultSecond = allMethods.getNameParentsFirstMoreThanAge(getTestListOfParents(), olderThanSecond);
        Assert.assertEquals(expectedResultSecond, methodResultSecond);

        String expectResultEmpty = "None";
        String methodResultEmpty = allMethods.getNameParentsFirstMoreThanAge(getListEmptyForTest(), olderThanFirst);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetFirstIdChildren() throws Exception {
        int youngerThanFirst = 6;
        int youngerThanSecond = 4;
        long expectedResultFirst = 2;
        long expectedResultSecond = 0;
        long methodResultFirst = allMethods.getFirstIdChildren(getTestListOfParents(), youngerThanFirst);
        Assert.assertEquals(expectedResultFirst, methodResultFirst);
        long methodResultSecond = allMethods.getFirstIdChildren(getTestListOfParents(), youngerThanSecond);
        Assert.assertEquals(expectedResultSecond, methodResultSecond);

        long expectResultEmpty = 0;
        long methodResultEmpty = allMethods.getFirstIdChildren(getListEmptyForTest(), youngerThanFirst);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetCountAllParentsSomeAge() throws Exception {
        int olderThan = 20;
        int youngerThan = 45;
        long expectedResult = 3;
        long methodResult = allMethods.getCountAllParentsSomeAge(getTestListOfParents(), olderThan, youngerThan);
        Assert.assertEquals(expectedResult, methodResult);

        long expectResultEmpty = 0;
        long methodResultEmpty = allMethods.getCountAllParentsSomeAge(getListEmptyForTest(), olderThan, youngerThan);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetAllChildrenSortedByAgeAndByName() throws Exception {
        List<User> expectedResultTop1 = new ArrayList<>();
        expectedResultTop1.add(getTestListOfParents().get(0).getChildren().get(1));
        List<User> expectedResultTop2 = new ArrayList<>();
        expectedResultTop2.add(getTestListOfParents().get(1).getChildren().get(0));
        List<User> expectedResultLow = new ArrayList<>();
        expectedResultLow.add(getTestListOfParents().get(4).getChildren().get(0));
        List<User> methodResult = allMethods.getAllChildrenSortedByAgeAndByName(getTestListOfParents());
        Assert.assertEquals(expectedResultTop1.get(0).getName(), methodResult.get(0).getName());
        Assert.assertEquals(expectedResultTop2.get(0).getName(), methodResult.get(1).getName());
        Assert.assertEquals(expectedResultLow.get(0).getName(), methodResult.get(4).getName());

        List<User> methodResultEmpty = allMethods.getAllChildrenSortedByAgeAndByName(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetChildrenSortedByAgeNumberFrom_To_() throws Exception {
        int top = 2;
        int low = 4;
        List<User> expectedResultTop = new ArrayList<>();
        expectedResultTop.add(getTestListOfParents().get(1).getChildren().get(0));
        List<User> expectedResultLow = new ArrayList<>();
        expectedResultLow.add(getTestListOfParents().get(0).getChildren().get(0));
        List<User> methodResult = allMethods.getChildrenSortedByAgeNumberFrom_To_(getTestListOfParents(), top, low);
        Assert.assertEquals(expectedResultTop.get(0).getName(), methodResult.get(1).getName());
        Assert.assertEquals(expectedResultLow.get(0).getName(), methodResult.get(3).getName());

        List<User> methodResultEmpty = allMethods.getChildrenSortedByAgeNumberFrom_To_(getListEmptyForTest(), top, low);
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetNameParentsStringWithСommas() throws Exception {
        String expectedResult = "Anna, Bob, Steve, Bob, Luk";
        String resultMethod = allMethods.getNameParentsStringWithСommas(getTestListOfParents());
        Assert.assertEquals(expectedResult, resultMethod);

        String expectedresultEmpty = allMethods.getNameParentsStringWithСommas(getListEmptyForTest());


    }

    @Test
    public void testGetMapWithKeyIdValueListChildren() throws Exception {
        long keyOne = 2;
        long keyTwo = 5;

        Map<Long, List<User>> methodResult = allMethods.getMapWithKeyIdValueListChildren(getTestListOfParents());
        Assert.assertEquals(getTestListOfParents().get(1).getChildren().get(0).getName(), methodResult.get(keyOne).get(0).getName());
        Assert.assertEquals(getTestListOfParents().get(4).getChildren().size(), methodResult.get(keyTwo).size());

        Map<Long, List<User>> methodResultEmpty = allMethods.getMapWithKeyIdValueListChildren(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetMapWithKeyParentValueListNameChildren() throws Exception {
        User keyOne = getTestListOfParents().get(1);
        User keyTwo = getTestListOfParents().get(0);
        Map<User, List<String>> methodResult = allMethods.getMapWithKeyParentValueListNameChildren(getTestListOfParents());
        Assert.assertEquals(getTestListOfParents().get(1).getChildren().get(0).getName(), methodResult.get(keyOne).get(0));
        Assert.assertEquals(getTestListOfParents().get(0).getChildren().size(), methodResult.get(keyTwo).size());

        Map<User, List<String>> methodResultEmpty = allMethods.getMapWithKeyParentValueListNameChildren(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetMapWithKeyParentValueAgeTheOldestChild() throws Exception {
        User keyOne = getTestListOfParents().get(4);
        User keyTwo = getTestListOfParents().get(0);
        Map methodResult = allMethods.getMapWithKeyParentValueAgeTheOldestChild(getTestListOfParents());
        Assert.assertEquals(getTestListOfParents().get(4).getChildren().get(0).getAge(), methodResult.get(keyOne));
        Assert.assertEquals(getTestListOfParents().get(0).getChildren().get(0).getAge(), methodResult.get(keyTwo));

        Map<User, Integer> methodResultEmpty = allMethods.getMapWithKeyParentValueAgeTheOldestChild(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetSameChildrenName() throws Exception {
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(getTestListOfParents().get(0).getChildren().get(0));
        List<User> methodResult = allMethods.getSameChildrenName(getTestListOfParents());
        Assert.assertEquals(expectedResult.get(0).getName(), methodResult.get(0).getName());

        List<User> methodResultEmpty = allMethods.getSameChildrenName(getListEmptyForTest());
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

}






