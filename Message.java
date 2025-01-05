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
        this.asDouble = Double.parseDouble(this.asText);
        this.date = new Date();
    }

    public Message(String AsText) {
        this.data = AsText.getBytes();
        this.asText = AsText;
        this.asDouble = Double.parseDouble(this.asText);
        this.date = new Date();

        //this(asText.getBytes());
        }

    public Message(double AsDouble) {
        this.data = new byte[] { (byte) AsDouble };
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
