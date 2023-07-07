/*
 * Available context bindings:
 *   COLUMNS     List<DataColumn>
 *   ROWS        Iterable<DataRow>
 *   OUT         { append() }
 *   FORMATTER   { format(row, col); formatValue(Object, col); getTypeName(Object, col); isStringLiteral(Object, col); }
 *   TRANSPOSED  Boolean
 * plus ALL_COLUMNS, TABLE, DIALECT
 *
 * where:
 *   DataRow     { rowNumber(); first(); last(); data(): List<Object>; value(column): Object }
 *   DataColumn  { columnNumber(), name() }
 */

SEPARATOR = ","
QUOTE     = "\""
NEWLINE   = System.getProperty("line.separator")
INDENT    = "  (" // 2-space indentation
SUFFIX    = "),"

def printRow = { values, valueToString, isLast ->
  values.eachWithIndex { value, idx ->
    def str = valueToString(value)
    OUT.append(QUOTE)
      .append(str.replace(QUOTE, QUOTE + QUOTE))
      .append(QUOTE)
      .append(idx != values.size() - 1 ? SEPARATOR : "")
  }
  OUT.append((!isLast ? SUFFIX : ")") + NEWLINE + (!isLast ? INDENT : ""))
}

OUT.append("[")
OUT.append(NEWLINE + INDENT)

if (!TRANSPOSED) {
  def iterator = ROWS.iterator()
  def row = iterator.hasNext() ? iterator.next() : null
  while (row != null) {
    def nextRow = iterator.hasNext() ? iterator.next() : null
    printRow(COLUMNS, { FORMATTER.format(row, it) }, nextRow == null)
    row = nextRow
  }
}
else {
  def values = COLUMNS.collect { new ArrayList<String>() }
  def iterator = ROWS.iterator()
  def row = iterator.hasNext() ? iterator.next() : null
  while (row != null) {
    COLUMNS.eachWithIndex { col, i -> values[i].add(FORMATTER.format(row, col)) }
    row = iterator.hasNext() ? iterator.next() : null
  }
  values.eachWithIndex { value, idx ->
    printRow(value, { it }, idx == values.size() - 1)
  }
}

OUT.append("]")
