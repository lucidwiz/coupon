# 쿠폰 발급 웹 애플리케이션

본 웹 애플리케이션은 특정 목적에 의해 만들어진 프로젝트 입니다.

무단 복제 및 수정은 엄격히 환영합니다.

## 프로젝트 개요
* SPA를 통한 쿠폰 발급 및 조회 애플리케이션
* Email 주소를 입력하면 임의의 16자리 숫자, 알파벳 조합의 쿠폰이 발급됨
  - 동일 Email 주소로 등록 불가
* 발급된 쿠폰 정보를 볼 수 있는 페이지 제공




## 프로젝트 문제 해결 전략

* **Spring Boot**를 통한 간단한 Java Web Application 개발
* Maven을 이용한 Build
* REST API 를 통한 쿠폰 발급 및 조회
* **JPA**를 이용한 데이터 제어 (In-memory DB)
* Thymeleaf + Bootstrap 을 이용한 Front-end 구현

## 프로젝트 빌드 및 실행 방법
* [다운로드](https://github.com/lucidwiz/coupon/archive/master.zip) 및 압축해제 하거나 Git clone 받음 [Git](https://spring.io/understanding/Git): `git clone  [https://github.com/lucidwiz/coupon.git]`

* Project 폴더에서 Maven 빌드 수행
```
- Mac :  ./mvnw clean install
- Windows : mvnw clean install
```
* target 폴더 진입 후 다음과 같이 실행
``` java -jar coupon-0.0.1-SNAPSHOT.jar ```

* 웹 브라우저에서 다음 주소로 접속하여 실행
``` http://localhost:8080 ```

## REST API 가이드
* POST /api/v1/issue/{email}
  - Request body 필요 없음
* GET /api/v1/getlist
  - Request Parameter 
    - pagenum : int -> 페이징 처리를 위한 한 페이지 번호
    - pagesize : int -> 페이징 처리를 위한 한 페이지 최대 아이템 개수
  - Return Sample
  '''
  {
    "count": 1,
    "couponList": [
        {
            "id": 1,
            "email": "jj@ss.com",
            "coupon": "M8t1-JhTJ-brKW-ZYgJ",
            "issued_time": "Tue Apr 03 00:35:01 KST 2018"
        }
    ]
  }
  '''


## Screen Shots
![Main Issue Screen](https://github.com/lucidwiz/coupon/blob/master/1.png)
![List Screen](https://github.com/lucidwiz/coupon/blob/master/2.png)


----------


# 감사합니다!!
