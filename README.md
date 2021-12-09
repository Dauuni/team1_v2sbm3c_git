# 은행별 예금, 적금 상품 비교 사이트 KM Bank

예금, 적금 상품을 들기 위해 사람들은 은행에 직접 방문하거나 온라인 사이트에 접속하게 된다. 이럴 경우 해당 은행의 정보만 제공하고 있기 때문에 다른 은행 상품과 비교했을 때 어느 쪽이 효율적인지 판단하는데 어려움이 발생한다.

KM Bank 사이트는 이 점을 고려하여 사용자가 궁금한 두 은행의 상품을 선택하면 상품의 은행명, 상품이름, 가입 방법, 이자율을 한눈에 보여준다. 해당 은행의 상품을 자세히 보고 싶은 경우 사용자의 편리를 위해 은행 이름 클릭 시 온라인 사이트로 넘어가도록 설계하였다.<br><br>

## Member

**문다은** : 팀장, 웹 퍼블리셔, 데이터 아키텍트(예금, 커뮤니티, 은행사이트)<br>
강민우 : 웹 퍼블리셔, 데이터 아키텍트(적금, 회원)<br><br>

## ERD(Entity-Relationship Diagram)

- **Logical**
![37](https://user-images.githubusercontent.com/64301855/145398406-b53cb240-c259-43a4-bdd0-15b8bf0c291f.jpg)

- **Physical**
![38](https://user-images.githubusercontent.com/64301855/145398409-14a8bebf-21e8-428c-9b24-5254ebc70475.jpg)

## Development Sequence

1. 구현 기능 분석
2. DB 모델링
3. SQL 생성 및 테스트
4. VO(DTO) 생성
	- SQL을 MyBATIS XML로 변환
	- SQL XML Mapping File 생성
5. DAO Interface 생성
6. DAO Interface 구현
7. Process Interface 생성(Business Logic, Manager/Service class)
8. Process Interface 구현
9. Spring Controller MVC Action class 생성
10. Controller, Beans(Tool(Utility 날짜 처리등 각종 메소드), Paging, Download)
11. JSP 제작, Controller, Beans와 연동
12. Test
<br><br>

## Techique

- **Spring Boot**

	<img src="https://user-images.githubusercontent.com/64301855/145398589-fb3234c0-a350-4111-acd3-61e3ee49a812.jpg" width="80" height="60"> 스프링 개발과 관련된 기능들을 개발자가 사용하기 편리하도록 지원하는 **STS(Spring Tool Suite)** 4.6 버전을 사용하여 개발하였다.

- **MyBATIS**

	- SQL을 JAVA와 분리함으로 **독립적인 팀 개발**이 가능하여 개발 시간을 단축시켰고, SQL과 JAVA의 연결을 **XML을 이용**하여 선언하였다.
    ![34](https://user-images.githubusercontent.com/64301855/145398590-65c37172-9823-462c-aecf-2f8a19306a2c.JPG)

- **Oracle**

	- **Oracle 11G**를 사용하여 데이터를 관리하였다.

	- **SQL Developer** 19.2.1버전을 사용하여 Oracle 11G에서 생성한 계정으로 접속하여 테이블과 데이터를 관리하였다.
    ![35](https://user-images.githubusercontent.com/64301855/145398591-43a711e1-a470-4702-bbaa-9e10b32494ae.JPG)

- **UI Style**

	- **Bootstrap**<br>
    HTML, CSS, JS 프레임워크인 Bootstrap을 사용하여 웹사이트를 디자인을 구성하였다.
    <br><br>
    Bootstrap은 하나의 CSS로 Mobile(휴대폰), 태블릿, 데스크탑 등 많은 기기에서 작동하고, 여러 기능을 제공하여 사용자가 쉽게 웹 사이트를 제작 및 유지 보수 할 수 있도록 도와준다.

	- **HTML5**<br>
    Layout 구성 및 데이터 출력의 목적으로 사용하였다.

  - **CSS**<br>
    출력되는 HTML에 시각적인 효과를 적용하기 위해 사용하였다.

- **JSP**

	- **서버** 프로그램 구현을 위해 HTML 코드 내에 직접 자바 코드를 삽입하는 JSP를 사용하였다.

	- JSTL에서 제공하는 태그들을 사용하여 선언하였다.

  - JAVA 코드를 처리하여 출력 결과를 HTML과 CSS로 변환하여 출력한다.

  - WEB에서 JAVA를 이용한 DBMS 접근을 처리한다.

- **JavaScript**

	- JSP에서 호출할 함수를 선언하고 WEB 요소의 id를 사용하여 해당 요소의 동작을 지정한다.

- **jQuery**

	- JavaScript 라이브러리로 **동적 이벤트 처리**를 담당한다.
    <br>
    ex) 체크박스 갯수 제한, 버튼 클릭, 마우스 on/over 등

- **AJAX**

	- **페이지 이동없이** 화면을 전환하기 위해 사용하였다.

	- Controller에서 JSON 형태의 변수를 전달하여 JSP에서 선언하고, **동작들을 처리**한다.

- **JSON**

	- Controller에서 VO에서 선언한 각각의 필드를 AJAX가 사용하기 위해 데이터를 전달하는 개방형 표준 포맷이다.<br><br>

## Web site

- **main**

<br>
![39](https://user-images.githubusercontent.com/64301855/145399102-41d27796-e8f1-40f6-8f52-c6abe0c15076.jpg)<br>
> 웹 사이트에 접속하자마자 나오는 메인 화면이다.<br>
아래 메인 컨텐츠 부분은 메인 화면에서 많이 사용 되는 이미지 슬라이드를 추가하였다.

<br>

- **로그인**

<br>
![47](https://user-images.githubusercontent.com/64301855/145399147-487d9540-7608-45ee-9fe1-c79149188f7e.JPG)
> 신규 사용자가 회원가입 버튼을 눌렀을 때 배너 아래에 나오는 화면이다.<br>
\* 표시가 되어 있는 부분은 필수로 입력하도록 하였고, 우편번호는 Daum API를 사용하여 편리하게 검색할 수 있도록 하였다.

<br>

![46](https://user-images.githubusercontent.com/64301855/145399186-6945ef0c-a47c-49aa-a414-f01ac6ea2b2a.JPG)
> 사용자가 로그인 버튼을 눌렀을 때 나오는 화면이다.<br>
아이디와 비밀번호를 입력하여 로그인할 수 있고, 다음 로그인을 위해 아이디와 비밀번호를 저장할 수 있는 기능을 추가하였다.

<br>

- **예금**

<br>
![40](https://user-images.githubusercontent.com/64301855/145399239-a0e7abd0-5f55-47bd-b807-97f4f5f9bfd6.jpg)
> 배너에 있는 예금 버튼을 눌렀을 때 나오는 화면이다.<br>
상단에 가입 방법, 지역, 검색어에 따라 분류할 수 있는 검색 기능을 추가하였다.

<br>

- **적금**

<br>
![41](https://user-images.githubusercontent.com/64301855/145399287-a02ccc1c-78ec-4dca-83b5-8f160f8033b1.jpg)
> 배너에 있는 적금 버튼을 눌렀을 때 나오는 화면이다.<br>
예금 화면과 마찬가지로 상단에 가입 방법, 지역, 검색어에 따라 분류할 수 있는 검색 기능을 추가하였다.

<br>

- **테이블**

<br>
![42](https://user-images.githubusercontent.com/64301855/145399275-3a37127a-9f05-45de-abb1-f8c05dbda86e.jpg)
> 예금, 적금 화면에서 검색 기능 아래 데이터 테이블이 출력 되게 하였다.<br>
아래 페이징 기능을 추가하였고, 은행 이름 왼쪽의 체크 박스를 선택하고 비교하기 버튼을 누를 수 있도록 하였다.

<br>

- **비교**

<br>
![43](https://user-images.githubusercontent.com/64301855/145399281-967848ce-5f29-4f8f-8abc-830ffd6021d8.jpg)
> 사용자가 체크 박스를 선택하고 버튼을 눌렀을 때 나오는 화면이다.<br>
테이블로 보았을 때보다 한눈에 보기 편하다.

<br>

- **API 수집**

<br>
![44](https://user-images.githubusercontent.com/64301855/145399361-89683d7b-55fd-4c75-8bbd-2d9d6aef5a26.jpg)
> 현재 관리자 권한으로 로그인한 상태여서 오른쪽 상단에 관리자 버튼이 활성화 되어 있는 상태이다. 여기서, 관리자 버튼의 하위 메뉴에서 데이터 수집 버튼을 누르면 나오는 화면이다.<br>
수집 버튼을 누르면 **금융감독원 사이트**에서 제공하는 open api의 데이터를 받아오게 된다.

<br>

- **커뮤니티**

<br>
![45](https://user-images.githubusercontent.com/64301855/145399366-61f46919-1357-4478-8d0b-7c86a2d2936a.JPG)
> 배너에 있는 커뮤니티 버튼을 눌렀을 때 나오는 화면이다.<br>
사용자 간의 소통할 수 있고, 마음에 드는 게시물에 좋아요 표시를 할 수 있도록 하였다.

<br>

- **은행**

<br>
![48](https://user-images.githubusercontent.com/64301855/145399403-06484dac-0a36-45a0-b36e-8d6b412e4de7.JPG)
> 배너에 있는 은행 버튼을 눌렀을 때 나오는 화면이다.<br>
전체 은행의 사이트를 모아두었고, 사용자가 궁금한 은행을 검색할 수 있다. 이미지나 사이트 주소를 눌렀을 경우 해당 사이트로 넘어가도록 하였다.

<br>
