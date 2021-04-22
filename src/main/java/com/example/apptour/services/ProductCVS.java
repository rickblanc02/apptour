package com.example.apptour.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			return true;
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
				

				Product product = new Product();

				// Make calculte

				product.setName(csvRecord.get("name"));
				product.setCost(Double.parseDouble(csvRecord.get("cost")));
				product.setCount(Integer.parseInt(csvRecord.get("count")));
				// product.setDate_start(Timestamp.valueOf(csvRecord.get("date_start")));
				Double precioIva = Double.parseDouble(csvRecord.get("cost")) * 0.19;				
				product.setType(Integer.parseInt(csvRecord.get("type")));

				if (csvRecord.get("type").equals("1")) {

					// 12%
					Double comision = Double.parseDouble(csvRecord.get("cost")) * 0.12;
					product.setPrize(Double.parseDouble(csvRecord.get("cost")) + precioIva + comision);
					product.setGain(comision);

				}
				if (csvRecord.get("type").equals("2")) {

					// 30.5%
					Double comision = Double.parseDouble(csvRecord.get("cost")) * 0.30;
					product.setPrize(Double.parseDouble(csvRecord.get("cost")) + precioIva + comision);
					product.setGain(comision);

				}
				if (csvRecord.get("type").equals("3")) {

					// 8.95%
					Double comision = Double.parseDouble(csvRecord.get("cost")) * 0.8;
					product.setPrize(Double.parseDouble(csvRecord.get("cost")) + precioIva + comision);
					product.setGain(comision);

				}
				if (csvRecord.get("type").equals("4")) {

					// 10.33%
					Double comision = Double.parseDouble(csvRecord.get("cost")) * 0.10;
					product.setPrize(Double.parseDouble(csvRecord.get("cost")) + precioIva + comision);
					product.setGain(comision);

				}

				product.setIva(precioIva);
				product.setTotal(product.getPrize() * product.getCount());

				products.add(product);
			}

			return products;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}