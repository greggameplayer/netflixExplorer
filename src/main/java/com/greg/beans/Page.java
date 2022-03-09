package com.greg.beans;

import j2html.tags.DomContent;

import static j2html.TagCreator.*;

// Bean page which holds the html for an html page with bootstrap and font-awesome included
public class Page {
    private DomContent body;
    private DomContent head;
    private final String title;

    public DomContent getBody() {
        return body;
    }

    public DomContent getHead() {
        return head;
    }

    public void setBody(DomContent body) {
        this.body = body;
    }

    public void setHead(DomContent head) {
        this.head = head;
    }

    public Page(String title) {
        this.title = title;
    }

    public String render() {
        return html(
                head(
                        title(title),
                        link().withHref("https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css").withRel("stylesheet"),
                        script().withSrc("https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"),
                        link().withHref("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css").withRel("stylesheet"),
                        head
                ),
                body(
                        body
                )
        ).render();
    }
}
