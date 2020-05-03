package com.toys.app;

    public class NewsModel {
        private String author,title,description,content,coverImage;

        public NewsModel() {
        }

        public NewsModel(String author, String title, String description, String content,String coverImage) {

            this.author = author;
            this.title = title;
            this.description = description;
            this.content = content;
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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String country) {
            this.author = author;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


    }
