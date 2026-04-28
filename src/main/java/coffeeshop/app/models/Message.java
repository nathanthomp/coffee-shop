package coffeeshop.app.models;

public final class Message {

    private final String title;
    private final String body;

    public Message(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String title() {
        return title;
    }

    public String body() {
        return body;
    }
}
