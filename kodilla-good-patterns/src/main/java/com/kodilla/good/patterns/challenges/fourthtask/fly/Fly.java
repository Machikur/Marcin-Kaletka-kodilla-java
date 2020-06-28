package com.kodilla.good.patterns.challenges.fourthtask.fly;


import java.util.Objects;

public class Fly {
    private String from;
    private String to;
    private String transfer;

    public Fly(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public Fly(String from, String transfer, String to) {
        this.from = from;
        this.to = to;
        this.transfer = transfer;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fly fly = (Fly) o;
        return Objects.equals(from, fly.from) &&
                Objects.equals(to, fly.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        String result = "Lot z " + from + " do " + to;
        if (Objects.nonNull(transfer)) {
            return result + " z przesiadką w " + transfer;
        }
        return result;
    }
}
