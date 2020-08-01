package com.practice.Builder;

import java.util.ArrayList;
import java.util.Collections;

class HtmlElement {
    public String name, text;
    public ArrayList<HtmlElement> elements = new ArrayList<>();
    private int indentSize = 4;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {}

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", Collections.nCopies(indentSize*indent, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies(indentSize*(indent+1), " ")));
            sb.append(text);
            sb.append(newLine);
        }
        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }
        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class HtmlBuilder {
    private String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.name = rootName;
    }

    public void addChild(String childName, String childText) {
        root.elements.add(new HtmlElement(childName, childText));
    }

    public void clear() {
        root = new HtmlElement();
        root.name = rootName;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}

public class Builder {
    public static void main(String[] args) {
        // 1. build a simple HTML paragraph
        String hello = "hello";
        System.out.println("<p>" + hello + "</p>");

        // 2. build a list with 2 words
        String[] words = {"hello", "world"};
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>\n");
        for (String word : words) {
            sb.append(String.format("\t<li>%s</li>\n", word));
        }
        sb.append("</ul>\n");
        System.out.println(sb);

        // 3. ordinary non-fluent builder
        HtmlBuilder builder = new HtmlBuilder("ul");
        builder.addChild("li", "hello");
        builder.addChild("li", "china");
        System.out.println(builder);
    }
}
