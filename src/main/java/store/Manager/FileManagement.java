package store.Manager;

import static store.Constants.productFile;
import static store.Constants.promotionFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void productOpen() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(productFile));
        productReadFile(reader);
    }

    private void productReadFile(BufferedReader reader) throws IOException {
        List<Product> products = new ArrayList<>();
        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 4) {
                productDataParsing(data, products);
            }
        }
        reader.close();
    }

    private void productDataParsing(String[] data, List<Product> products) {
        String name = data[0].trim();
        int price = Integer.parseInt(data[1].trim());
        int quantity = Integer.parseInt(data[2].trim());
        String promotion = data[3].trim().equals("null") ? null : data[3].trim();
        products.add(new Product(name, price, quantity, promotion));
    }

    public void promotionOpen() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(promotionFile));
        promotionReadFile(reader);
    }

    private void promotionReadFile(BufferedReader reader) throws IOException {
        List<PromotionDetails> promotionsList = new ArrayList<>();
        String line = reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                promotionDataParsing(data,promotionsList);

            }
        }
        reader.close();
    }

    private void promotionDataParsing(String[] data, List<PromotionDetails> promotionsList) {
        String promoName = data[0].trim();
        int buy = Integer.parseInt(data[1].trim());
        int get = Integer.parseInt(data[2].trim());
        LocalDate startDate = LocalDate.parse(data[3].trim(), formatter);
        LocalDate endDate = LocalDate.parse(data[4].trim(), formatter);

        Promotion promotion = Promotion.fromName(promoName); // 프로모션 이름을 enum으로 변환
        promotionsList.add(new PromotionDetails(promotion, startDate, endDate));  // PromotionDetails 객체 생성 후 리스트에 추가
    }
}
