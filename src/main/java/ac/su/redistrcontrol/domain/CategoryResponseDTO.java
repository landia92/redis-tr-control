package ac.su.redistrcontrol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private int depth;

    private Long parentId;

    public static CategoryResponseDTO fromCategory(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDepth(),
                category.getParent() != null ? category.getParent().getId() : null
        );
    }
}
