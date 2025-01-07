package test;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

//ctor

    public Message(byte[] data) {
        this.data = data;
        this.asText = new String(data);
        this.asDouble = parseToDouble(this.asText);
        this.date = new Date();
    }

    public Message(String AsText) {
        this.data = AsText.getBytes();
        this.asText = AsText;
        this.asDouble = parseToDouble(this.asText);
        this.date = new Date();
     }

    public Message(double AsDouble) {
        this.data = Double.toString(AsDouble).getBytes();
        this.asText = Double.toString(AsDouble);
        this.asDouble = AsDouble;
        this.date = new Date();
    }

    private double parseToDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException exception) {
            return Double.NaN; // Return NaN if parsing fails
        }
    }
}
