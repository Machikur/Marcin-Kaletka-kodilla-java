package com.kodilla.testing.forum.statistics.mock;

import com.kodilla.testing.forum.statistics.CalkulateStatistic;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestStatistics {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testCalkulateWithMockZeroPosts() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        users.add("Krzysztof");
        users.add("Tomasz");

        //When
        when(statistics.commentsCount()).thenReturn(10);
        when(statistics.postsCount()).thenReturn(0);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(0, calkulateStatistic.getAveragePostsPerUser(), 0);
        Assert.assertEquals(0, calkulateStatistic.getPostsQuantity());
        Assert.assertEquals(0, calkulateStatistic.getAverageCommentsPerPost(), 0);
    }

    @Test
    public void testCalkulateWithMockZeroComments() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        users.add("Krzysztof");
        users.add("Tomasz");

        //When
        when(statistics.commentsCount()).thenReturn(0);
        when(statistics.postsCount()).thenReturn(10);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(0, calkulateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(0, calkulateStatistic.getCommentsQuantity());
    }

    @Test
    public void testCalkulateWithMockZeroUsers() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();

        //When
        when(statistics.commentsCount()).thenReturn(10);
        when(statistics.postsCount()).thenReturn(0);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(0, calkulateStatistic.getAveragePostsPerUser(), 0);
        Assert.assertEquals(0, calkulateStatistic.getUsersQuantity());
        Assert.assertEquals(0, calkulateStatistic.getAverageCommentsPerUser(), 0);
    }

    @Test
    public void testCalkulateWithMockThousandPosts() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        users.add("Krzysztof");
        users.add("Tomasz");

        //When
        when(statistics.commentsCount()).thenReturn(10);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(500, calkulateStatistic.getAveragePostsPerUser(), 0);
        Assert.assertEquals(1000, calkulateStatistic.getPostsQuantity());
        Assert.assertEquals(0.01, calkulateStatistic.getAverageCommentsPerPost(), 0);
    }

    @Test
    public void testCalkulateWithMockThousandUsers() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            users.add("Krzysztof");
        }

        //When
        when(statistics.commentsCount()).thenReturn(10);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(1, calkulateStatistic.getAveragePostsPerUser(), 0);
        Assert.assertEquals(1000, calkulateStatistic.getUsersQuantity());
        Assert.assertEquals(0.01, calkulateStatistic.getAverageCommentsPerUser(), 0);
    }

    @Test
    public void testCalkulateWithMockMorePostsThanComments() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            users.add("Krzysztof");
        }

        //When
        when(statistics.commentsCount()).thenReturn(10);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(10, calkulateStatistic.getCommentsQuantity());
        Assert.assertEquals(1000, calkulateStatistic.getPostsQuantity());
        Assert.assertEquals(0.01, calkulateStatistic.getAverageCommentsPerPost(), 0);
    }

    @Test
    public void testCalkulateWithMockMoreCommentsThanPosts() {
        //Given
        CalkulateStatistic calkulateStatistic = new CalkulateStatistic();
        Statistics statistics = mock(Statistics.class);
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            users.add("Krzysztof");
        }

        //When
        when(statistics.commentsCount()).thenReturn(1000);
        when(statistics.postsCount()).thenReturn(10);
        when(statistics.usersNames()).thenReturn(users);

        calkulateStatistic.calculateAdvStatistics(statistics);

        //Then
        Assert.assertEquals(1000, calkulateStatistic.getCommentsQuantity());
        Assert.assertEquals(10, calkulateStatistic.getPostsQuantity());
        Assert.assertEquals(100, calkulateStatistic.getAverageCommentsPerPost(), 0);
    }
}
