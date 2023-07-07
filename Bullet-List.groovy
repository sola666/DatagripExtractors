SEPARATOR = " - "
QUOTE     = ""
NEWLINE   = System.getProperty("line.separator")
PREFIX    = "• "
SUFFIX    = ""

def printRow = { values, valueToString ->
  OUT.append(PREFIX)
  values.eachWithIndex { value, idx ->
    def str = valueToString(value)
    OUT.append(QUOTE)
      .append(str.replace(QUOTE, QUOTE + QUOTE))
      .append(QUOTE)
      .append(idx != values.size() - 1 ? SEPARATOR : "")
  }
  OUT.append(SUFFIX + NEWLINE)
}

if (!TRANSPOSED) {
  ROWS.each { row -> printRow(COLUMNS, { FORMATTER.format(row, it) }) }
}
else {
  def values = COLUMNS.collect { new ArrayList<String>() }
  ROWS.each { row -> COLUMNS.eachWithIndex { col, i -> values[i].add(FORMATTER.format(row, col)) } }
  values.each { printRow(it, { it }) }
}
