package com.ohgiraffers.chap00intro;

import com.ohgiraffers.chap00intro.problem.Menu;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemsOfUsingDirectSQLTests {

//    @BeforeAll
//    public static void all(){
//        System.out.println("ALL TESTS STARTED");
//    }
//
//    @BeforeEach
//    public void setUp() {
//        System.out.println("Set Up Before each test");
//    }
//
//    @Test
//    void testMethod() {
//        System.out.println("테스트 메소드 실행");
//    }
//
//    @Test
//    void testMethod2() {
//        System.out.println("테스트 메소드2 실행");
//    }
//
//    @AfterEach
//    public void close() {
//        System.out.println("Close After Each test");
//    }
//
//    @AfterAll
//    public static void closeAll(){
//        System.out.println("ALL TESTS FINISHED");
//    }

    private Connection con;

    @BeforeEach
    public void setConnection() throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);
    }

    @AfterEach
    public void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    @Test
    public void testConnection() {
        Assertions.assertNotNull(con);
    }

    @DisplayName("Check the problem of find manu using SQL in person")
    @Test
    public void testDirectSelectSQL() throws SQLException {

        //given
        String query = "SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS FROM TBL_MENU";

        //when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menus = new ArrayList<>();
        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
            menu.setMenuPrice(rset.getInt("MENU_PRICE"));
            menu.setCategoryCode(rset.getInt("CATEGORY_CODE"));
            menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

            menus.add(menu);
        }

        //then (verify)
        Assertions.assertNotNull(menus);
        menus.forEach(System.out::println);
        rset.close();
        stmt.close();
    }

    @DisplayName("직접 SQL을 작성하여 신규 메뉴를 추가할 시 발생하는 문제 확인")
    @Test
    public void testDirectInsertSQL() throws SQLException {

        //given
        Menu menu = new Menu();
        menu.setMenuName("멸치알쉐이크");
        menu.setMenuPrice(10000);
        menu.setCategoryCode(9);
        menu.setOrderableStatus("Y");

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) VALUES(?,?,?,?)";

        //when
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, menu.getMenuName());
        pstmt.setDouble(2, menu.getMenuPrice());
        pstmt.setInt(3, menu.getCategoryCode());
        pstmt.setString(4, menu.getOrderableStatus());

        int result = pstmt.executeUpdate();

        //then
        Assertions.assertEquals(1, result);
        pstmt.close();
    }

    //만약 데이터베이스가 아닌 자바 컬렉션에 데이터를 보관하거나 가져오는 방식이라면?
    //list.add(menu);
    //list.get(1);


    @Test
    public void testChangeSelectColumns() throws SQLException {

        String query = "SELECT MENU_CODE, MENU_NAME FROM TBL_MENU";

        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menus = new ArrayList<>();
        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));

            menus.add(menu);
        }

        rset.close();
        stmt.close();

        Assertions.assertNotNull(menus);
        menus.forEach(System.out::println);
    }

    @DisplayName()
}
