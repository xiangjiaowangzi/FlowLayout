package com.example.administrator.dragflexboxlayout;

/**
 * Created by Lbin on 2017/11/1.
 */

public class TagModel {

    int bgColor;
    int textColor;
    int strokeColor;
    String text;
    int cornerDip;
    int strokeWidthDip;

    public TagModel(){}

    public TagModel(int bgColor, int textColor, int strokeColor, String text, int cornerDip, int strokeWidthDip) {
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.strokeColor = strokeColor;
        this.text = text;
        this.cornerDip = cornerDip;
        this.strokeWidthDip = strokeWidthDip;
    }


    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getCornerDip() {
        return cornerDip;
    }

    public void setCornerDip(int cornerDip) {
        this.cornerDip = cornerDip;
    }

    public int getStrokeWidthDip() {
        return strokeWidthDip;
    }

    public void setStrokeWidthDip(int strokeWidthDip) {
        this.strokeWidthDip = strokeWidthDip;
    }

    @Override
    public String toString() {
        return "TagModel{" +
                "bgColor=" + bgColor +
                ", textColor=" + textColor +
                ", strokeColor=" + strokeColor +
                ", text='" + text + '\'' +
                ", cornerDip=" + cornerDip +
                ", strokeWidthDip=" + strokeWidthDip +
                '}';
    }
}
