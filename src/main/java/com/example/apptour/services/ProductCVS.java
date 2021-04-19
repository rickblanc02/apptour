package com.example.apptour.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.example.apptour.models.Product;



public class ProductCVS { 
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return true;//false 
    }

    return true;
  }

  public static List<Product> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Product> products = new ArrayList<Product>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  /*Product tutorial = new Product(
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("Title"),
              csvRecord.get("Description"),
              Boolean.parseBoolean(csvRecord.get("Published"))
            );*/
    	  
    	  Product product = new Product();
    	 
    	  product.setName(csvRecord.get("name"));    	  
    	  product.setCost(Double.parseDouble(csvRecord.get("cost")));
    	  product.setCount(Integer.parseInt(csvRecord.get("count")));
    	  //product.setDate_start(Timestamp.valueOf(csvRecord.get("date_start")));
    	  product.setPrize(Double.parseDouble(csvRecord.get("prize")));

    	  products.add(product);
      }

      return products;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

}