package com.artem.training;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class TestAllMethods {

    AllMethods allMethods = new AllMethods();
    List<User> listEmptyForTest = new ArrayList<>();
    private final boolean resultListIsEmpty = true;

    boolean isResultListIsEmpty() {
        return resultListIsEmpty;
    }

    List<User> getTestListOfParents() {
        List<User> childrenAnna = new ArrayList<>();
        childrenAnna.add(new User(1, 8, "Mike"));
        childrenAnna.add(new User(2, 4, "Dave"));
        User anna = new User(1, 32, "Anna", childrenAnna);

        List<User> childrenBob = new ArrayList<>();
        childrenBob.add(new User(4, 5, "Sam"));
        User bob = new User(2, 30, "Bob", childrenBob);

        User steve = new User(7, 20, "Steve", null);

        User сolin = new User(8, 45, "Bob", null);

        List<User> childrenLuk = new ArrayList<>();
        childrenLuk.add(new User(13, 11, "Mike"));
        childrenLuk.add(new User(15, 6, "Tad"));
        User luk = new User(10, 30, "Luk", childrenLuk);


        List<User> testListOfParents = new ArrayList<>();
        testListOfParents.add(anna);
        testListOfParents.add(bob);
        testListOfParents.add(steve);
        testListOfParents.add(сolin);
        testListOfParents.add(luk);

        return testListOfParents;
    }

    @Test
    public void testGetSameChildrenName() throws Exception {

        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(getTestListOfParents().get(0).getChildren().get(0));

        List<User> methodResult = allMethods.getSameChildrenName(getTestListOfParents());
        Assert.assertEquals(expectedResult.get(0).getName(), methodResult.get(0).getName());

        List<User> methodResultEmpty = allMethods.getSameChildrenName(listEmptyForTest);
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
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
        long methodResultEmpty = allMethods.getCountParentsAgeOlderThan(listEmptyForTest, parentsOlder);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetCountAllChildren() throws Exception {
        int expectResult = 5;
        int methodResult = allMethods.getCountAllChildren(getTestListOfParents());
        Assert.assertEquals(expectResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getCountAllChildren(listEmptyForTest);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetSumAgeChildren() throws Exception {
        int expectResult = 34;
        int methodResult = allMethods.getSumAgeChildren(getTestListOfParents());
        Assert.assertEquals(expectResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getSumAgeChildren(listEmptyForTest);
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

        List<User> methodResultEmpty = allMethods.getChildrenSortedByAge(listEmptyForTest);
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetChildrenYoungerThan() throws Exception {
        int olderThan = 6;
        int expectedCountChildren = 2;
        List<User> methodResult = allMethods.getChildrenYoungerThan(getTestListOfParents(), olderThan);
        Assert.assertEquals(expectedCountChildren, methodResult.size());

        List<User> methodResultEmpty = allMethods.getChildrenYoungerThan(listEmptyForTest, olderThan);
        Assert.assertEquals(isResultListIsEmpty(), methodResultEmpty.isEmpty());
    }

    @Test
    public void testGetUniqueChildrenName() throws Exception {
        int expectedCountUniqueNameChildren = 4;
        List<String> methodResult = allMethods.getUniqueChildrenName(getTestListOfParents());
        Assert.assertEquals(expectedCountUniqueNameChildren, methodResult.size());

        List<String> methodResultEmpty = allMethods.getUniqueChildrenName(listEmptyForTest);
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

        boolean methodResultEmpty = allMethods.getAreThereSomeChildrenOlderThan(listEmptyForTest, olderThanFirst);
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

        boolean methodResultEmpty = allMethods.getAreThereAllChildrenYoungerThan(listEmptyForTest, youngerThanSecond);
        Assert.assertEquals(expectedResultEmpty, methodResultEmpty);
    }

    @Test
    public void testGetAgeParentsMax() throws Exception {
        int expectedResult = 45;

        int methodResult = allMethods.getAgeParentsMax(getTestListOfParents());
        Assert.assertEquals(expectedResult, methodResult);

        int expectResultEmpty = 0;
        int methodResultEmpty = allMethods.getAgeParentsMax(listEmptyForTest);
        Assert.assertEquals(expectResultEmpty, methodResultEmpty);
    }
}


