package com.stork.jetpackapplication.bean;

import java.util.List;

/**
 * 歌手Bean
 * created by xiaojun at 2020/8/7
 */
public class SingerList {

    private Object nums;
    private String noFirstChar;
    private int havemore;
    private List<ArtistBean> artist;

    public Object getNums() {
        return nums;
    }

    public void setNums(Object nums) {
        this.nums = nums;
    }

    public String getNoFirstChar() {
        return noFirstChar;
    }

    public void setNoFirstChar(String noFirstChar) {
        this.noFirstChar = noFirstChar;
    }

    public int getHavemore() {
        return havemore;
    }

    public void setHavemore(int havemore) {
        this.havemore = havemore;
    }

    public List<ArtistBean> getArtist() {
        return artist;
    }

    public void setArtist(List<ArtistBean> artist) {
        this.artist = artist;
    }

    public static class ArtistBean {

        private String ting_uid;
        private String name;
        private String firstchar;
        private String gender;
        private String area;
        private String country;
        private String avatar_big;
        private String avatar_middle;
        private String avatar_small;
        private String avatar_mini;
        private String albums_total;
        private String songs_total;
        private String artist_id;
        private String testValue;

        public String getTing_uid() {
            return ting_uid;
        }

        public void setTing_uid(String ting_uid) {
            this.ting_uid = ting_uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstchar() {
            return firstchar;
        }

        public void setFirstchar(String firstchar) {
            this.firstchar = firstchar;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAvatar_big() {
            return avatar_big;
        }

        public void setAvatar_big(String avatar_big) {
            this.avatar_big = avatar_big;
        }

        public String getAvatar_middle() {
            return avatar_middle;
        }

        public void setAvatar_middle(String avatar_middle) {
            this.avatar_middle = avatar_middle;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public void setAvatar_mini(String avatar_mini) {
            this.avatar_mini = avatar_mini;
        }

        public String getAlbums_total() {
            return albums_total;
        }

        public void setAlbums_total(String albums_total) {
            this.albums_total = albums_total;
        }

        public String getSongs_total() {
            return songs_total;
        }

        public void setSongs_total(String songs_total) {
            this.songs_total = songs_total;
        }

        public String getArtist_id() {
            return artist_id;
        }

        public void setArtist_id(String artist_id) {
            this.artist_id = artist_id;
        }

        public String getTestValue() {
            return testValue;
        }

        public void setTestValue(String testValue) {
            this.testValue = testValue;
        }
    }
}
