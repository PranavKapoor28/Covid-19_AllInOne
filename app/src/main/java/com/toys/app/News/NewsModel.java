package com.toys.app.News;

    public class NewsModel {
        private String flag1,author,title,description,content;

        public NewsModel() {
        }

        public NewsModel(String flag1, String author, String title, String description, String content) {
            this.flag1 = flag1;
            this.author = author;
            this.title = title;
            this.description = description;
            this.content = content;
            }

        public String getFlag() {
            return flag1;
        }

        public void setFlag(String flag1) {
            this.flag1 = flag1;
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
