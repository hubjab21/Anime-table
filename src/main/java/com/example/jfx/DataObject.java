package com.example.jfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataObject {
    private StringProperty value1 = new SimpleStringProperty();
    private StringProperty value2 = new SimpleStringProperty();
    private StringProperty value3 = new SimpleStringProperty();
    private StringProperty value4 = new SimpleStringProperty();
    private StringProperty value5 = new SimpleStringProperty();
    private StringProperty value6 = new SimpleStringProperty();
    private StringProperty value7 = new SimpleStringProperty();
    private StringProperty value8 = new SimpleStringProperty();

    public DataObject(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8) {
        this.value1.set(value1);
        this.value2.set(value2);
        this.value3.set(value3);
        this.value4.set(value4);
        this.value5.set(value5);
        this.value6.set(value6);
        this.value7.set(value7);
        this.value8.set(value8);
    }

    public boolean matchesKeyword(String keyword) {
        return getValue1().toLowerCase().contains(keyword) ||
                getValue2().toLowerCase().contains(keyword) ||
                getValue3().toLowerCase().contains(keyword);
    }


    public String getValue1() {
        return value1.get();
    }

    public StringProperty value1Property() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1.set(value1);
    }

    public String getValue2() {
        return value2.get();
    }

    public StringProperty value2Property() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2.set(value2);
    }

    public String getValue3() {
        return value3.get();
    }

    public StringProperty value3Property() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3.set(value3);
    }

    public String getValue4() {
        return value4.get();
    }

    public StringProperty value4Property() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4.set(value4);
    }

    public String getValue5() {
        return value5.get();
    }

    public StringProperty value5Property() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5.set(value5);
    }

    public String getValue6() {
        return value6.get();
    }

    public StringProperty value6Property() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6.set(value6);
    }

    public String getValue7() {
        return value7.get();
    }

    public StringProperty value7Property() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7.set(value7);
    }

    public String getValue8() {
        return value8.get();
    }

    public StringProperty value8Property() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8.set(value8);
    }
}
