package com.fp.api_client.product.util;



import com.fp.api_client.product.domain.Dimensions;
import com.fp.api_client.product.domain.Meta;
import com.fp.api_client.product.domain.Product;
import com.fp.api_client.product.domain.Review;

import java.util.Arrays;
import java.util.List;

public class MockUtils {

    public static Product getMockProduct() {
        Product product = getMockProductWithoutId();
        product.setId(1);
        return product;
    }

    public static Product getMockProductWithoutId() {
        Product product = new Product();
        product.setTitle("Essence Mascara Lash Princess");
        product.setDescription("The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.");
        product.setCategory("beauty");
        product.setPrice(9.99);
        product.setDiscountPercentage(10.48);
        product.setRating(2.56);
        product.setStock(99);
        product.setTags(Arrays.asList("beauty", "mascara"));
        product.setBrand("Essence");
        product.setSku("BEA-ESS-ESS-001");
        product.setWeight(4);
        Dimensions dimensions = new Dimensions();
        dimensions.setWidth(15.14);
        dimensions.setHeight(13.08);
        dimensions.setDepth(22.99);
        product.setDimensions(dimensions);
        product.setWarrantyInformation("1 week warranty");
        product.setShippingInformation("Ships in 3-5 business days");
        product.setAvailabilityStatus("In Stock");
        product.setReturnPolicy("No return policy");
        product.setMinimumOrderQuantity(48);

        // Create the reviews
        Review review1 = new Review();
        review1.setRating(3);
        review1.setComment("Would not recommend!");
        review1.setDate("2025-04-30T09:41:02.053Z");
        review1.setReviewerName("Eleanor Collins");
        review1.setReviewerEmail("eleanor.collins@x.dummyjson.com");

        Review review2 = new Review();
        review2.setRating(4);
        review2.setComment("Very satisfied!");
        review2.setDate("2025-04-30T09:41:02.053Z");
        review2.setReviewerName("Lucas Gordon");
        review2.setReviewerEmail("lucas.gordon@x.dummyjson.com");

        Review review3 = new Review();
        review3.setRating(5);
        review3.setComment("Highly impressed!");
        review3.setDate("2025-04-30T09:41:02.053Z");
        review3.setReviewerName("Eleanor Collins");
        review3.setReviewerEmail("eleanor.collins@x.dummyjson.com");

        List<Review> reviews = Arrays.asList(review1, review2, review3);
        product.setReviews(reviews);

        // Create the meta
        Meta meta = new Meta();
        meta.setCreatedAt("2025-04-30T09:41:02.053Z");
        meta.setUpdatedAt("2025-04-30T09:41:02.053Z");
        meta.setBarcode("5784719087687");
        meta.setQrCode("https://cdn.dummyjson.com/public/qr-code.png");
        product.setMeta(meta);

        // Set the images and thumbnail
        List<String> images = Arrays.asList(
                "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp"
        );
        product.setImages(images);
        product.setThumbnail("https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp");

        product.setDeleted(false);

        return product;
    }
}