package com.test.seleniumcodegnerator;

class ClickedElement {
    private String xPath;
    private String type;

    public ClickedElement(String xPath, String type) {
        this.xPath = xPath;
        this.type = type;
    }

    public String getXPath() {
        return xPath;
    }

    public String getType() {
        return type;
    }
}
