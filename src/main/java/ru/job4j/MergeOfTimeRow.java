package ru.job4j;

import java.util.Set;
import java.util.TreeMap;


/**
 * Класс для объединения временных рядов {@code Row}
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
class MergeOfTimeRow {

    /**
     * Метод для получения нового временного ряда на
     * интервале {@code Datetime} второго временного ряда {@code row2}
     * и содержащий значения из обоих рядов.
     * Если для некоторого момента времени есть данные двух рядов,
     * то выбирается значение второго временного ряда {@code row2}
     *
     * @param row1 первый временной ряд
     * @param row2 второй временной ряд
     * @return временной ряд, полученный после слияния двух рядов
     */
    Row merge(Row row1, Row row2) {
        TreeMap<Datetime, Value> data = new TreeMap<>();
        Set<Datetime> dt_row1 = row1.getData().keySet();
        for (Datetime dt1 : dt_row1) {
            if ((dt1.getTime() >= row2.getStartdt().getTime()) &&
                    (dt1.getTime() <= row2.getEnddt().getTime())) {
                data.put(dt1, row1.getData().get(dt1));
            }
        }
        Set<Datetime> dt_row2 = row2.getData().keySet();
        for (Datetime dt2 : dt_row2) {
            data.put(dt2, row2.getData().get(dt2));
        }
        return new Row(data);
    }
}