package com.example.javaspringtutorial.DTO;


import com.example.javaspringtutorial.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private String thumbnail;
    private CategoryDTO category;

    public static ProductDTO productDTO (Product product) {
        ProductDTO tmp = new ProductDTO();
        tmp.setId(product.getId());
        tmp.setName(product.getName());
        tmp.setPrice(product.getPrice());
        tmp.setThumbnail(product.getThumbnail());
        tmp.setCategory(CategoryDTO.categoryDTO(product.getCategory()));
        return tmp;
    }
}
