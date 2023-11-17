package com.example.jfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataService {
    private static final Logger logger = LogManager.getLogger(DataService.class);

    private final List<DataObject> dataList = new ArrayList<>();

    public DataService() {
    }

    public ObservableList<DataObject> fetchData() throws IOException {
        try {
            Document doc = Jsoup.connect("https://myanimelist.net/anime/season/2023/spring").timeout(6000).get();

            Elements divBody = doc.select("div.seasonal-anime-list.js-seasonal-anime-list.js-seasonal-anime-list-key-1 div.js-anime-category-producer.seasonal-anime.js-seasonal-anime.js-anime-type-all.js-anime-type-1");

            for (Element div1 : divBody) {
                try {
                    String title = div1.select("div.image img").attr("alt");
                    String studio = div1.select("div.properties  div.property span.item > a").attr("title");
                    String type = div1.select("[class=\"genres js-genre\"]").text();
                    String date = div1.select("div.info span.item:first-child").text();
                    String episode = div1.select("div div.prodsrc div.info > span.item > span:first-child").text();
                    String time = div1.select("div div.prodsrc div.info > span.item > span:last-child").text();
                    String info = div1.select("div.image a").attr("href");
                    String where = "TV";
                    DataObject dataObject = new DataObject(title, studio, type, date, episode, time, where, info);
                    dataList.add(dataObject);
                    logger.info("Downloading data - first step");
                } catch (Exception e) {
                    logger.error("Error parsing data", e);
                }
            }

            Elements divBody2 = doc.select("[class=\"seasonal-anime-list js-seasonal-anime-list js-seasonal-anime-list-key-5\"] [class=\"js-anime-category-producer seasonal-anime js-seasonal-anime js-anime-type-all js-anime-type-5\"]");
            for (Element div2 : divBody2) {
                try {
                    String title = div2.select("div.image img").attr("alt");
                    String studio = div2.select("div.properties  div.property span.item > a").attr("title");
                    String type = div2.select("[class=\"genres js-genre\"]").text();
                    String date = div2.select("div.info span.item:first-child").text();
                    String episode = div2.select("div div.prodsrc div.info > span.item > span:first-child").text();
                    String time = div2.select("div div.prodsrc div.info > span.item > span:last-child").text();
                    String info = div2.select("div.image a").attr("href");
                    String where = "ONA";
                    DataObject dataObject2 = new DataObject(title, studio, type, date, episode, time, where, info);
                    dataList.add(dataObject2);
                    logger.info("Downloading data - second step");
                } catch (Exception e) {
                    logger.error("Error parsing data", e);
                }
            }

            Elements divBody3 = doc.select("[class=\"seasonal-anime-list js-seasonal-anime-list js-seasonal-anime-list-key-2\"] [class=\"js-anime-category-producer seasonal-anime js-seasonal-anime js-anime-type-all js-anime-type-2\"]");
            for (Element div3 : divBody3) {
                try {
                    String title = div3.select("div.image img").attr("alt");
                    String studio = div3.select("div.properties  div.property span.item > a").attr("title");
                    String type = div3.select("[class=\"genres js-genre\"]").text();
                    String date = div3.select("div.info span.item:first-child").text();
                    String episode = div3.select("div div.prodsrc div.info > span.item > span:first-child").text();
                    String time = div3.select("div div.prodsrc div.info > span.item > span:last-child").text();
                    String info = div3.select("div.image a").attr("href");
                    String where = "OVA";
                    DataObject dataObject3 = new DataObject(title, studio, type, date, episode, time, where, info);
                    dataList.add(dataObject3);
                    logger.info("Downloading data - third step");
                } catch (Exception e) {
                    logger.error("Error parsing data", e);
                    throw new IOException("Error while fetching data from the internet", e);
                }
            }

            Elements divBody4 = doc.select("[class=\"seasonal-anime-list js-seasonal-anime-list js-seasonal-anime-list-key-3\"] [class=\"js-anime-category-producer seasonal-anime js-seasonal-anime js-anime-type-all js-anime-type-3\"]");
            for (Element div4 : divBody4) {
                try {
                    String title = div4.select("div.image img").attr("alt");
                    String studio = div4.select("div.properties  div.property span.item > a").attr("title");
                    String type = div4.select("[class=\"genres js-genre\"]").text();
                    String date = div4.select("div.info span.item:first-child").text();
                    String episode = div4.select("div div.prodsrc div.info > span.item > span:first-child").text();
                    String time = div4.select("div div.prodsrc div.info > span.item > span:last-child").text();
                    String info = div4.select("div.image a").attr("href");
                    String where = "Movie";
                    DataObject dataObject4 = new DataObject(title, studio, type, date, episode, time, where, info);
                    dataList.add(dataObject4);
                    logger.info("Downloading data - forth step");
                } catch (Exception e) {
                    logger.error("Error parsing data", e);
                }
            }

            Elements divBody5 = doc.select("[class=\"seasonal-anime-list js-seasonal-anime-list js-seasonal-anime-list-key-4\"] [class=\"js-anime-category-producer seasonal-anime js-seasonal-anime js-anime-type-all js-anime-type-4\"]");
            for (Element div5 : divBody5) {
                try {
                    String title = div5.select("div.image img").attr("alt");
                    String studio = div5.select("div.properties  div.property span.item > a").attr("title");
                    String type = div5.select("[class=\"genres js-genre\"]").text();
                    String date = div5.select("div.info span.item:first-child").text();
                    String episode = div5.select("div div.prodsrc div.info > span.item > span:first-child").text();
                    String time = div5.select("div div.prodsrc div.info > span.item > span:last-child").text();
                    String info = div5.select("div.image a").attr("href");
                    String where = "Special";
                    DataObject dataObject5 = new DataObject(title, studio, type, date, episode, time, where, info);
                    dataList.add(dataObject5);
                    logger.info("Downloading data - fifth step");
                } catch (Exception e) {
                    logger.error("Error parsing data", e);
                }
            }
        } catch (UnknownHostException e) {
            logger.error("No internet connection", e);
            throw new IOException("No internet connection", e);
        } catch (HttpStatusException e) {
            logger.error("HTTP error fetching URL", e);
            throw new IOException("HTTP error fetching URL", e);
        } catch (IOException e) {
            logger.error("Error while fetching data from the internet", e);
            throw new IOException("Error while fetching data from the internet", e);
        }
        return FXCollections.observableArrayList(dataList);
    }

    public ObservableList<DataObject> searchData(String keyword) {
        List<DataObject> filteredData = dataList.stream()
                .filter(dataObject -> dataObject.matchesKeyword(keyword.toLowerCase()))
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(filteredData);
    }
}
