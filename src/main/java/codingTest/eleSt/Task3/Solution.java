package codingTest.eleSt.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String S) {
        List<Picture> pictures = new ArrayList<>();

        String[] pictureList = S.split("\n");

        for (String s : pictureList) {
            String[] split = s.split(",");
            String extension = "." + split[0].split("\\.")[1];
            pictures.add(new Picture(extension, split[1], split[2]));
        }

        Map<String, List<Picture>> collect = pictures.stream()
            .collect(Collectors.groupingBy(Picture::getCity));

        for (String cityName : collect.keySet()) {
            List<Picture> tmp = collect.get(cityName);
            Collections.sort(tmp);
        }

        // 사진에 이름 붙이기
        for (String cityName : collect.keySet()) {
            List<Picture> tmp = collect.get(cityName);
            int idx = 1;
            if (tmp.size() >= 10 && tmp.size() < 100) {
                for (Picture picture : tmp) {
                    if (idx < 10) {
                        picture.setResultName(picture.getCity() + "0" + idx++ + picture.getExtension());
                    } else {
                        picture.setResultName(picture.getCity() + idx++ + picture.getExtension());
                    }
                }
            } else if (tmp.size() >= 100) {
                for (Picture picture : tmp) {
                    if (idx < 10) {
                        picture.setResultName(picture.getCity() + "00" + idx++ + picture.getExtension());
                    } else if (idx < 100) {
                        picture.setResultName(picture.getCity() + "0" + idx++ + picture.getExtension());
                    } else {
                        picture.setResultName(picture.getCity() + idx++ + picture.getExtension());
                    }
                }
            } else {
                for (Picture picture : tmp) {
                    picture.setResultName(picture.getCity() + idx++ + picture.getExtension());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Picture picture : pictures) {
            sb.append(picture.getResultName().strip()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String solution = s.solution(
        //     "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
        //         + "john.png, London, 2015-06-20 15:13:22\n"
        //         + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
        //         + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
        //         + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
        //         + "BOB.jpg, London, 2015-08-05 00:02:03\n"
        //         + "notredame.png, Paris, 2015-09-01 12:00:00\n"
        //         + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
        //         + "a.png, Warsaw, 2016-02-13 13:33:50\n"
        //         + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
        //         + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
        //         + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
        //         + "e.png, Warsaw, 2016-01-02 09:49:09\n"
        //         + "f.png, Warsaw, 2016-01-02 10:55:32\n"
        //         + "g.jpg, Warsaw, 2016-02-29 22:13:11");
        String solution = s.solution(
            "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "john.png, Warsaw, 2015-06-20 15:13:22\n"
                + "g.jpg, Warsaw, 2016-02-29 22:13:11");
        System.out.println(solution);
    }

    static class Picture implements Comparable<Picture> {
        String resultName;
        String extension;
        String city;
        String day;

        public Picture(String extension, String city, String day) {
            this.extension = extension;
            this.city = city;
            this.day = day;
        }

        public String getCity() {
            return city;
        }

        public String getExtension() {
            return extension;
        }

        public String getResultName() {
            return resultName;
        }

        public void setResultName(String resultName) {
            this.resultName = resultName;
        }

        @Override
        public int compareTo(Picture o) {
            return this.day.compareTo(o.day);
        }
    }
}

