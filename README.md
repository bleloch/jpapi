# jpapi

`jpapi` exposes a REST API for querying various sources of Japanese language data built with Java & Spring Boot.

## Building & running

1. Due to the size of the data sources, they are not included with this project. You may download them from the following locations:
    - [JMDict](http://ftp.monash.edu.au/pub/nihongo/JMdict.gz) - either the full version or `JMDict_e.gz` will work, but I have developed using the full version.
    - [JMDict furigana](https://github.com/Doublevil/JmdictFurigana/releases/download/2.3.1%2B2024-11-25/JmdictFurigana.json) (latest version at time of writing)
    - [JMnedict](https://web.archive.org/web/20161119124321/http://ftp.monash.edu.au/pub/nihongo/JMnedict.xml.gz)
    - [JMnedict furigana](https://github.com/Doublevil/JmdictFurigana/releases/download/2.3.1%2B2024-11-25/JmnedictFurigana.json) (latest version at time of writing)
    - [Kanjidic2](http://ftp.monash.edu.au/pub/nihongo/kanjidic.gz)
2. Unzip and move source files to `src/main/resources`:
    ```shell
    # JMDict
    gunzip JMDict.gz
    mv JMDict.xml ${PROJECT_ROOT}/src/main/resources
   
    # JMnedict
    gunzip Jmnedict.xml.gz
    mv Jmnedict.xml ${PROJECT_ROOT}/src/main/resources
   
    # Kanjidic2
    gunzip kanjidic2.gz
    mv Kanjidic2.xml ${PROJECT_ROOT}/src/main/resources
    
    # Furigana
    mv JmDictFurigana.json ${PROJECT_ROOT}/src/main/resources
    mv JmnedictFurigana.json ${PROJECT_ROOT}/src/main/resources
    ```
3. Compile the application:
   ```shell
   ./mvnw compile
   ```
4. Before use, the database must be loaded with the source data. To populate the database, run the application with the `ingestion` profile enabled:
    ```shell
    ./mvnw spring-boot:run -Dspring-boot.run.profiles=ingestion
    ```
5. Re-run the application without the profile:
   ```shell
   ./mvnw spring-boot:run
   ```
   
## Usage
The following endpoints may be used to query data:
- `/search/word/{searchTerm}` queries JMDict data. It is possible to search by kanji representation ("立入禁止"), kana ("たちいりきんし"), or translation ("Off Limits")
- `/search/word/{entrySequence}` can be used to retrieve data on a given JMDict entry where the entry sequence is known. See JMDict documentation for more information. 
- `/search/kanji/{searchTerm}` queries Kanjidic2 data
- `/search/name/{searchTerm}` queries JMnedict data

## Contributing

Contributions are welcomed - feel free raise a PR. 

## Credit

- [JMDict](http://ftp.usf.edu/pub/ftp.monash.edu.au/pub/nihongo/edict_doc.html), [JMNnedict](http://ftp.net.usf.edu/pub/ftp.monash.edu.au/pub/nihongo/enamdict_doc.html) & [Kanjidic2](http://ftp.usf.edu/pub/ftp.monash.edu.au/pub/nihongo/kanjidic.html) are kindly provided by Jim Breen and his team at Monash University.
- JMDict & JMnedict furigana mappings are provided by [Doublevil's algorithm](https://github.com/Doublevil/JmdictFurigana). Some entries are known to be missing from this data - a list of those entries can be found at `${PROJECT_ROOT}/missing_furigana.csv`





