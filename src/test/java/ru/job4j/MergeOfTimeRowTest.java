package ru.job4j;

import org.junit.Test;
import java.util.TreeMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MergeOfTimeRowTest {
    @Test
    public void whenRow1CrossesRow2FromBelowShouldReturnTotalRow () {
        MergeOfTimeRow mergeOfTimeRow = new MergeOfTimeRow();
        TreeMap<Datetime, Value> row1_data = new TreeMap<>();
        row1_data.put(new Datetime(4), new Value(4));
        row1_data.put(new Datetime(5), new Value(5));
        row1_data.put(new Datetime(6), new Value(6));
        row1_data.put(new Datetime(7), new Value(7));
        row1_data.put(new Datetime(8), new Value(8));
        Row row1 = new Row(row1_data);

        TreeMap<Datetime, Value> row2_data = new TreeMap<>();
        row2_data.put(new Datetime(5), new Value(10));
        row2_data.put(new Datetime(7), new Value(14));
        row2_data.put(new Datetime(9), new Value(18));
        row2_data.put(new Datetime(11), new Value(22));
        row2_data.put(new Datetime(13), new Value(26));
        Row row2 = new Row(row2_data);

        Row actual = mergeOfTimeRow.merge(row1, row2);

        TreeMap<Datetime, Value> expectedData = new TreeMap<>();
        expectedData.put(new Datetime(5), new Value(10));
        expectedData.put(new Datetime(6), new Value(6));
        expectedData.put(new Datetime(7), new Value(14));
        expectedData.put(new Datetime(8), new Value(8));
        expectedData.put(new Datetime(9), new Value(18));
        expectedData.put(new Datetime(11), new Value(22));
        expectedData.put(new Datetime(13), new Value(26));
        Row expected = new Row(expectedData);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenRow1CrossesRow2FromAboveShouldReturnTotalRow () {
        MergeOfTimeRow mergeOfTimeRow = new MergeOfTimeRow();
        TreeMap<Datetime, Value> row1_data = new TreeMap<>();
        row1_data.put(new Datetime(10), new Value(10));
        row1_data.put(new Datetime(11), new Value(11));
        row1_data.put(new Datetime(12), new Value(12));
        row1_data.put(new Datetime(13), new Value(13));
        row1_data.put(new Datetime(14), new Value(14));
        Row row1 = new Row(row1_data);

        TreeMap<Datetime, Value> row2_data = new TreeMap<>();
        row2_data.put(new Datetime(5), new Value(10));
        row2_data.put(new Datetime(7), new Value(14));
        row2_data.put(new Datetime(9), new Value(18));
        row2_data.put(new Datetime(11), new Value(22));
        row2_data.put(new Datetime(13), new Value(26));
        Row row2 = new Row(row2_data);

        Row actual = mergeOfTimeRow.merge(row1, row2);

        TreeMap<Datetime, Value> expectedData = new TreeMap<>();
        expectedData.put(new Datetime(5), new Value(10));
        expectedData.put(new Datetime(7), new Value(14));
        expectedData.put(new Datetime(9), new Value(18));
        expectedData.put(new Datetime(10), new Value(10));
        expectedData.put(new Datetime(11), new Value(22));
        expectedData.put(new Datetime(12), new Value(12));
        expectedData.put(new Datetime(13), new Value(26));
        Row expected = new Row(expectedData);

        assertThat(actual, is(expected));
    }

    @Test
    public void whenRow1NoCrossesWithRow2ShouldReturnRow2 () {
        MergeOfTimeRow mergeOfTimeRow = new MergeOfTimeRow();
        TreeMap<Datetime, Value> row1_data = new TreeMap<>();
        row1_data.put(new Datetime(1), new Value(1));
        row1_data.put(new Datetime(2), new Value(2));
        row1_data.put(new Datetime(3), new Value(3));
        row1_data.put(new Datetime(4), new Value(4));
        row1_data.put(new Datetime(5), new Value(5));
        Row row1 = new Row(row1_data);

        TreeMap<Datetime, Value> row2_data = new TreeMap<>();
        row2_data.put(new Datetime(7), new Value(14));
        row2_data.put(new Datetime(9), new Value(18));
        row2_data.put(new Datetime(11), new Value(22));
        row2_data.put(new Datetime(13), new Value(26));
        row2_data.put(new Datetime(15), new Value(30));
        Row row2 = new Row(row2_data);

        Row actual = mergeOfTimeRow.merge(row1, row2);

        assertThat(actual, is(row2));
    }
}