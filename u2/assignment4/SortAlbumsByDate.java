package u2.assignment4;

import java.util.*;

public class SortAlbumsByDate implements Comparator<Album> {

    public int compare(Album a1, Album a2) {
        if (a1.getDate().getYear() == a2.getDate().getYear()) {
            if (a1.getDate().getMonth() == a2.getDate().getMonth()) {
                return a1.getDate().getDate() - a2.getDate().getDate();
            } else {
                return a1.getDate().getMonth() - a2.getDate().getMonth();
            }
        } else {
            return a1.getDate().getYear() - a2.getDate().getYear();
        }
    }
}
