package com.ohgiraffers.association.section01.manytoone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToOneAssociationTests {

    //Association Mapping은 Entity 간의 관계를 매핑하는 것을 의미함
    //이를 통해 객체를 가지고 데이터베이스 테이블 간의 관계를 매핑 가능

    //매핑의 분류는 크게 두 가지로 나뉨

    //다중성에 의한 분류
    //연관관계가 있는 객체 관계에서 실제로 연관을 가지는 객체의 수에 따라 분류
    //N:1(ManyToOne), 1:N(OneToMany), 1:1(OneToOne), N:M(ManyToMany) -> 실제 조인되는 행의 수

    //방향에 따른 분류
    //테이블의 연관 관계는 외래키를 이용하여 양방향 연관관계의 특징을 가짐
    //참조에 의한 객체의 연관관계는 단방향
    //단방향 연관관계, 양방향 연관관계
    //객체 간의 연관관계를 양방향으로 만들고 싶은 경우 반대쪽에서도 필드를 추가해서 참조를 보관
    //이는 엄밀하게 말해 양방향 관계가 아닌 2개의 단방향 관계

    //ManyToOne : 다수의 엔티티가 하나의 엔티티를 참조하는 상황에서 사용

    @Autowired
    private MenuFindService menuFindService;

    @DisplayName("메뉴 코드로 메뉴 조회하여 메뉴 이름이 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource({"1, 열무김치라떼", "2, 우럭스무디"})
    void testSelectMenuCompareToMenuName(int menuCode, String menuName) {

        Menu foundMenu = menuFindService.findMenuByMenuCode(menuCode);

        Assertions.assertEquals(menuName, foundMenu.getMenuName());
    }

    @DisplayName("메뉴 코드로 메뉴 조회하여 카테고리 이름이 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource({"1,커피", "2,기타"})
    //지연 로딩의 경우 트랜잭션이 종료되면 session이 close되면서 준영속 상태가 됨
    //엔티티 매니저가 관리하지 않는 객체가 되는 것이기 때문에 세션이 종료되었다는 에러가 발생
    //지연로딩을 이용하는 경우 동일한 트랜잭션 내에서 사용해야 함
    void testSelectMenuCompareToCategoryName(int menuCode, String categoryName) {

        Menu foundMenu = menuFindService.findMenuByMenuCode(menuCode);
        //FetchType - LAZY를 사용하면 트랜잭션이 종료될 때 session이 close되면서 영속 -> 준영속 전환

        Assertions.assertEquals(categoryName, foundMenu.getCategory().getCategoryName());
    }
}
