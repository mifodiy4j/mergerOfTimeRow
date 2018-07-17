package ru.job4j;

/**
 * Класс интервала времени для временного ряда
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
class Datetime implements Comparable {
    private long time = 0;

    public Datetime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        Datetime dt = (Datetime) o;
        return (int) (time - dt.getTime());
    }

    @Override
    public String toString() {
        return "Datetime{" +
                "time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Datetime datetime = (Datetime) o;

        return time == datetime.time;

    }

    @Override
    public int hashCode() {
        return (int) (time ^ (time >>> 32));
    }
}