# DatagripExtractors
This repository contains a collection of Groovy data extractors for use with JetBrains' DataGrip. Each script is designed to format extracted data in a different way, offering flexibility for your specific needs.

## Extractors
The collection includes the following extractors:
| Extractor | Description | Quotation | Row Prefix | Row Suffix | Output Prefix | Output Suffix |
| --- | --- | --- | --- | --- | --- | --- |
| py-string-list-doublequote | Formats data as a list of Python strings with double quotes. | Double quote (") | [ | ] | [ | ] |
| py-string-list-singlequote | Formats data as a list of Python strings with single quotes. | Single quote (') | [ | ] | [ | ] |
| py-tuple-list-singlequote | Formats each row as a Python tuple with single quotes inside, wrapped in a list. | Single quote (') | ( | ) | [ | ] |
| py-tuple-list-doublequote | Formats each row as a Python tuple with double quotes inside, wrapped in a list. | Double quote (") | ( | ) | [ | ] |
| sql-string-list-nowrap | Converts data into single quote strings, separated by a comma with no trailing comma for correct SQL formatting. No bracket wrapping. | Single quote (') |  |  |  |  |
| sql-string-list-wrap | Converts data into single quote strings, separated by a comma with no trailing comma for correct SQL formatting. Includes wrapping in brackets. | Single quote (') | ( | ) | ( | ) |


## Installation
To use these scripts, clone this repository or download the .groovy files directly. In DataGrip, open your project files and place the .groovy scripts in the below folder: 
`Scratches and Consoles > Extensions > Database Tools and SQL > data > extractors`

## Usage
After running your query, select the extractor as the output method as you normally would. This will work as either a data export to file, or a raw copy/paste into the correct format.

These have been primarily made with the intention of quickly copying and pasting out of the data results window for workflow efficiency while programming, and not for data export.

## Contributing
Contributions to improve these extractors are welcome. Please ensure that you test any changes thoroughly before submitting a pull request.
