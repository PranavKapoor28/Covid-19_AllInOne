package com.toys.app;

    public class NewsModel {
        private String title,description,link,pubdate,coverImage;

        public NewsModel() {
        }

        public NewsModel(String title, String description, String link,String pubdate,String coverImage) {

            this.title = title;
            this.description = description;
            this.link = link;
            this.pubdate =pubdate;
            this.coverImage=coverImage;
            }

        public static void add(NewsModel news) {
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }
    }
