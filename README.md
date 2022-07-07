# thymeleaf-board-dev

## 소개

thymeleaf를 사용하여 게시판 구현 
간단하게 게시글 작성과 회원가입/로그인 구현 

## 목적 
- thymeleaf로 게시판 구현해보기
- security를 이용한 로그인 구현
- git flow에 익숙해지기
- 프로젝트 리드미 작성해보기

## 작업 환경
- gradle
- JDK11
- Intellij
- h2
- yml
- layer 단위 패키지 구조

## 의존성 (ver 1.0)
- Lombok
- Spring Data JPA
- Thymeleaf
- Spring Web
- H2 Database

## 실행 방법

- 터미널을 키고 절대경로로 초기화한 후 경로를 데스크탑으로 지정

```
cd Desktop/
```

- 깃 저장소 url을 복사한 후 아래 명령어 작성 [git url](https://github.com/nswon/thymeleaf-board-dev.git)

```
git clone https://github.com/nswon/thymeleaf-board-dev.git
```

- Intellij을 키고 클론한 폴더 선택 후 실행

```
file -> open -> build.gradle in clone folder -> open as project
``` 

- resource -> application.yml 파일에서 사용자의 url로 변경

```
spring:  
  datasource:  
    url: jdbc:h2:tcp://localhost/~/test <-- 이 부분
```

- 오른쪽 위 초록색 삼각형 버튼 클릭 후 chrome창에 아래와 같이 작성


```
http://localhost:8080/
```

- etc
- JVM을 JDK11로 바꿔주지 않으면 오류가 발생할 수 있음
- JDK11로 바꿔주는 법

```
Preferences -> search : gradle -> Gradle JVM JDK11로 변경
```

## 요구사항 (ver 1.0)
- 현재 구현된 기능
	- 게시글 등록
	- 게시글 조회
	- 게시글 단건조회
	- 게시글 수정
	- 게시글 삭제

- 추가할 기능
	- 페이징
	- 로그인/회원가입
	- 프로필 페이지
	- 댓글
	- 조회수/좋아요
