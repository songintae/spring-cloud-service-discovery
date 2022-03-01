# spring-cloud-service-discovery
스프링 클라우드 서비스 디스커버리 예제코드

## 프로젝트 구성
1. Build Tool : Gradle
2. 모듈
    1. spring-cloud-netflix-eureka : netflix eureka 기반의 Registry 서버
    2. spring-cloud-netflix-eureka-client : spring-cloud-netflix-eureka-client 기반의 Client 서버
    
## 프로젝트 내용
스프링 클라우드 Common 프로젝트에서는 DiscoveryClient 및 ServiceRegistry, Cloud LoadBalancer에 대한 추상화 및 구현체 클래스들을 제공한다.
Eureka 구현체를 사용하여 Registry Server 및 Discovery Client를 등록 및 관리하고 Cloud LoadBalancer를 활용하여 다양한 Client를 통해 Cloud 환경의 요청을 관리 할 수 있다. 
- [**Spring Cloud Commons**](https://spring.io/projects/spring-cloud-commons)
- [**Spring Cloud Netflix**](https://spring.io/projects/spring-cloud-netflix)