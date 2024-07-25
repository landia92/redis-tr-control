package ac.su.redistrcontrol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private int price;

    // 재고량 및 판매량
    private int stockQuantity;
    private int salesQuantity;

    // 카테고리
    private CategoryResponseDTO category;

    public static ProductResponseDTO fromProduct(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getSalesQuantity(),
                product.getStockQuantity(),
                CategoryResponseDTO.fromCategory(product.getCategory())
        );
    }

    public static List<ProductResponseDTO> fromProducts(List<Product> products) {
        List<ProductResponseDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(fromProduct(product));
        }
        return productDTOS;
    }
}
