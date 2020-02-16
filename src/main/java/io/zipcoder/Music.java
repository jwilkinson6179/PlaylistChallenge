package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
        for(int clicks = 0; clicks < playList.length; clicks++) {

            if (playList[(startIndex + clicks + playList.length) % playList.length].equals(selection) ||
                    playList[(startIndex - clicks + playList.length) % playList.length].equals(selection)) {
                return clicks;
            }
        }

        return -1;
    }
}