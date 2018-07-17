[![Build Status](https://travis-ci.org/mifodiy4j/mergerOfTimeRow.svg?branch=master)](https://travis-ci.org/mifodiy4j/mergerOfTimeRow)
[![codecov](https://codecov.io/gh/mifodiy4j/mergerOfTimeRow/branch/master/graph/badge.svg)](https://codecov.io/gh/mifodiy4j/mergerOfTimeRow)

# mergerOfTimeRow

Слияние временных рядов.
1. У нас есть последовательность пар (dt: datetime, у: value) — график некоторой величины,
назовем ее row_l. Последовательность располагается на интервале времени [startdt_1,enddt].
(Этот интервал определяется первым и последним элементом последовательности).
Интервалы между точками произвольные.
2. Нам пришли новые данные row_2. Они располагаются на интервале [startdt_2,enddt_2].
Этот интервал смещен относительно исходного, и частично перекрывается с ним.

Необходимо построить новую последовательность row_3 (dt: datetime, у rvalue),
которая будет соответствовать интервалу [startdt_2, enddt_2] и содержать значения из обоих рядов.
Если для некоторого момента времени есть данные из row_l, и одновременно из row_2,
то необходимо выбрать значение из row_2