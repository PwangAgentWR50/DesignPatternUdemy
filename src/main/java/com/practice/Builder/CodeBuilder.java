package com.practice.Builder;

import java.util.ArrayList;
import java.util.Collections;

class FieldElement {
    private String name, type;

    public FieldElement(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        String i = String.join("", Collections.nCopies(4, " "));
        return String.format("%spublic %s %s;", i, type, name);
    }
}

public class CodeBuilder {
    private String className;
    private ArrayList<FieldElement> elements = new ArrayList<>();
    private static String newLine = System.lineSeparator();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        elements.add(new FieldElement(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("public class " + className).append(newLine);

        for (FieldElement e : elements) {
            sb.append(e.toString()).append(newLine);
        }

        sb.append("}").append(newLine);
        return sb.toString();
    }

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}
