package ac.su.redistrcontrol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id
    private Long id;
    private String name;

    private int depth;  // 최상위 1, 그 아래부터 2, 3, 4, ...

    @ManyToOne  // ToOne이 FK의 정의에 해당한다. 대상 키를 하나만 지정할 수 있으므로
    @JoinColumn(name = "parent_id")
    private Category parent;    // 상위 카테고리 참조

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Category> children;    // 하위 카테고리 목록

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products; // 카테고리 지정된 상품 목록

    @JsonIgnore
    public List<Category> getParentsList() {
        // id 번호가 오름차순 -> 카테고리 계층구조가 상위에서 하위로
        List<Category> parents = new ArrayList<>();
        // 상위 항목만 검색해서 리스트 완성하기
        Category parentPointer = this.parent;
        while (parentPointer != null) {
            parents.add(parentPointer);
            parentPointer = parentPointer.getParent();
        }
        Collections.reverse(parents);
        return parents;
    }
}

// 상품 카테고리 예제 : 의류 쇼핑몰
//브랜드의류 depth 1
//  - parent : null
//  - children : 브랜드 여성의류, 브랜드 남성의류, 브랜드 캐주얼의류
//브랜드 여성의류 depth 2
//  - parent : 브랜드의류
//  -children : null
//브랜드 남성의류 depth 2
//  - parent : 브랜드의류
//  -children : null
//브랜드 캐주얼의류 depth 2
//  - parent : 브랜드의류
//  -children : null

//브랜드잡화 depth 1
//브랜드 잡화
//브랜드 쥬얼리//시계
//수입명품

//스포츠브랜드 depth 1
//브랜드 아웃도어
//브랜드 스포츠패션
