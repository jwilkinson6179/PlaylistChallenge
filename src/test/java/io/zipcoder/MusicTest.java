package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class MusicTest {

    @Test
    public void selectionTest1() {

        String[] playlist = {"wheniseeyouagain", "borntorun", "nothingelsematters", "cecelia"};
        Music music = new Music(playlist);
        Integer startingIndex = 1;
        String selection = "cecelia";
        Integer expected = 2;
        Integer actual = music.selection(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void selectionTest2() {

        String[] playlist = {"dancinginthedark", "rio", "liveoak", "liveoak"}; // len = 4, start = 1,
        Music music = new Music(playlist);
        Integer startingIndex = 0;
        String selection = "liveoak";
        Integer expected = 1;
        Integer actual = music.selection(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void forwardClicks() {
        String[] playlist = {"norman $%!* rockwell", "mariners apartment complex", "venice", "doing time", "cinnamon girl", "how to disappear", "bartender"};
        Music music = new Music(playlist);
        Integer startingIndex = 0;
        String selection = "norman $%!* rockwell";
        Integer expected = 0;
        Integer actual = music.forwardClicks(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void forwardClicksThree() {
        String[] playlist = {"norman $%!* rockwell", "mariners apartment complex", "venice", "doing time", "cinnamon girl", "how to disappear", "bartender"};
        Music music = new Music(playlist);
        Integer startingIndex = 2;
        String selection = "how to disappear";
        Integer expected = 3;
        Integer actual = music.forwardClicks(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void forwardClicksWraps() {
        String[] playlist = {"norman $%!* rockwell", "mariners apartment complex", "venice", "doing time", "cinnamon girl", "how to disappear", "bartender"};
        Music music = new Music(playlist);
        Integer startingIndex = 5;
        String selection = "venice";
        Integer expected = 4;
        Integer actual = music.forwardClicks(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void backwardsClicks() {
        String[] playlist = {"jingle bells", "frosty", "rudolph", "merry christmas"};
        Music music = new Music(playlist);
        Integer startingIndex = 1;
        String selection = "frosty";
        Integer expected = 0;
        Integer actual = music.forwardClicks(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void backwardsClicksWrap() {
        String[] playlist = {"mgs", "zelda", "mario", "corax", "crash", "metroid"};
        Music music = new Music(playlist);
        Integer startingIndex = 1;
        String selection = "crash";
        Integer expected = 3;
        Integer actual = music.forwardClicks(startingIndex, selection);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseListTest() {
        // GIVEN
        String[] playlist = { "aa", "bb", "cc", "dd", "ee" };
        String[] expected = { "ee", "dd", "cc", "bb", "aa" };
        Music music = new Music(playlist);

        // WHEN
        String[] actual = music.reversePlaylist();

        // THEN
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseListTestRepeatEntries() {

        String[] playlist = {"aaa", "bbb", "ccc", "ccc"};
        String[] expected = { "ccc", "ccc", "bbb", "aaa" };
        Music music = new Music(playlist);

        // WHEN
        String[] actual = music.reversePlaylist();

        // THEN
        Assert.assertArrayEquals(expected, actual);
    }
}