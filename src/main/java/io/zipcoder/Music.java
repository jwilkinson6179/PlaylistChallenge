package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        Integer forwards = forwardClicks(startIndex, selection);
        Integer backwards = backwardsClicks(startIndex, selection);

        if(forwards <= backwards) {
            return forwards;
        }
        else
        {
            return backwards;
        }
    }

    public Integer forwardClicks(Integer startIndex, String selection)
    {
        for(int clicks = 0; clicks < playList.length; clicks++)
        {
            int currentTrack = (startIndex + clicks) % playList.length;
            if(playList[currentTrack].equals(selection))
            {
                return clicks;
            }
        }
        return playList.length;
    }

    public Integer backwardsClicks(Integer startIndex, String selection)
    {
        int clicks = 0;
        for(int i = playList.length - 1; i >= 0; i++)
        {
            int currentTrack = Math.abs((startIndex - clicks) % playList.length);
            if(playList[currentTrack].equals(selection))
            {
                return clicks;
            }
            clicks++;
        }
        return playList.length;
    }
}


// Two helper functions
// Iterate forward, looking for matching String value.  If Starting position + buttonClicks >= songlist length, search
// wraps to 0 via (start + buttonClicks) % (playlist.length)
// Iterate backwards similarly, except if start - buttonClicks < 0, (start - buttonClicks) % playlist.length