package com.greg.beans;

import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

// A Bean field used to display a detail from a movie with a fontawesome icon
public class SimpleField extends ContainerTag<SimpleField> {
    public SimpleField(String value, String... classes) {
        super("SimpleField");
        final String rowStyle = "display: flex; flex-direction: row; align-items: center;";
        final String defaultMargin = "margin-left: 1em;";
        children.add(div(i().withClasses(classes).withStyle("margin-bottom: 1rem;"), p(value).withClass("text-muted")).withStyle(rowStyle + defaultMargin));
    }
}
