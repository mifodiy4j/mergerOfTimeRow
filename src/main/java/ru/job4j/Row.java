package ru.job4j;

import java.util.Map;
import java.util.TreeMap;

/**
 * Класс временного ряда,
 * где по оси абсцисс - интервал времени {@code Datetime}
 * по оси ординат - некоторая величина {@code Value}
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
class Row {
    private Datetime startdt = null;
    private Datetime enddt = null;
    private Map<Datetime, Value> data = new TreeMap<>();

    public Row(TreeMap<Datetime, Value> data) {
        this.startdt = data.firstKey();
        this.enddt = data.lastKey();
        this.data = data;
    }

    public Datetime getStartdt() {
        return startdt;
    }

    public void setStartdt(Datetime startdt) {
        this.startdt = startdt;
    }

    public Datetime getEnddt() {
        return enddt;
    }

    public void setEnddt(Datetime enddt) {
        this.enddt = enddt;
    }

    public Map<Datetime, Value> getData() {
        return data;
    }

    public void setData(Map<Datetime, Value> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Row row = (Row) o;

        return data != null ? data.equals(row.data) : row.data == null;

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}