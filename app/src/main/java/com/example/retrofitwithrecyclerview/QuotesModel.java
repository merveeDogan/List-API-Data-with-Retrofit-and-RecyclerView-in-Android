package com.example.retrofitwithrecyclerview;

import com.google.gson.annotations.SerializedName;

public class QuotesModel {
    @SerializedName("q")
    private String quote;
    @SerializedName("a")
    private String author;
    @SerializedName("c")
    private String characterCount;
    @SerializedName("h")
    private String htmlTag;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(String characterCount) {
        this.characterCount = characterCount;
    }

    public String getHtmlTag() {
        return htmlTag;
    }

    public void setHtmlTag(String htmlTag) {
        this.htmlTag = htmlTag;
    }
}
