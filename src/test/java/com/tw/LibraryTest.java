package com.tw;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryTest {
    @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    private Library libraryMock,library;

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }
    @Before
    public void beforeTests() {
        libraryMock=mock(Library.class);
        library=new Library();
    }
    @Test
    public void testCalculate() {
        Integer[] tmp= new Integer[]{1,3,7,8,9,2,4};
        List<Integer> resulteOdd= Arrays.asList(tmp);

        Integer[] tmp2=new Integer[]{1,3,18,9,8,12};
        List<Integer> resulteEve= Arrays.asList(tmp2);

        when(libraryMock.calculate(resulteOdd)).thenReturn(7);
        when(libraryMock.calculate(resulteEve)).thenReturn(8);

    }

  @Test
    public void testAddStudent() {
        String right="张三,1,数学:98,语文:67,英语:78,编程:78";
        when(libraryMock.addStudent(right)).thenReturn(true);
        when(libraryMock.addStudent(anyString())).thenReturn(false);
    }

    @Test
    public void testPrintGrade() {
      String right1="23";
      String right2="23,78";
      when(libraryMock.printGrade(right1)).thenReturn(true);
      when(libraryMock.printGrade(right2)).thenReturn(true);
      when(libraryMock.printGrade(anyString())).thenReturn(false);

    }

    @Test
    public void testGetGrade() {
     String right="数学:78";
     String wrong="语文，89";
    when(libraryMock.getGrade(right)).thenReturn(78);
    when(libraryMock.getGrade(wrong)).thenReturn(-1);
    }


}
