package com.practice.springboot.learningspringboot.dto;



public class ContentDTO {

    /*
    {
            "contentId":1,
            "contentName":"일회용마스크",
            "contentContent:AAA",
            }

     */
    //2.포함할 모든 속성을 정의

    private long contentId;
    private String contentContent;
    private String contentName;

    //constructor

    public ContentDTO(long contentId, String contentContent, String contentName) {
        this.contentId = contentId;
        this.contentContent = contentContent;
        this.contentName = contentName;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public String getContentContent() {
        return contentContent;
    }

    public void setContentContent(String contentContent) {
        this.contentContent = contentContent;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    @Override
    public String toString() {
        return "ContentDTO{" +
                "contentId=" + contentId +
                ", contentContent='" + contentContent + '\'' +
                ", contentName='" + contentName + '\'' +
                '}';
    }
}