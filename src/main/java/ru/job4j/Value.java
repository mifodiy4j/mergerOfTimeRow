package ru.job4j;

/**
 * Класс величины для временного ряда
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
class Value {
    int value = 0;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Value value1 = (Value) o;

        return value == value1.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}