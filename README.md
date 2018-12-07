# MybatisSpring
MybatisSpring 연동하기

1. Dependency 추가
- 마이바티스 스프링 연동모듈을 사용하기 위해서, 클래스패스에 mybatis-spring-x.x.x.jar를 포함시켜야 한다.
- Gradle : compile group: 'org.mybatis', name: 'mybatis-spring', version: '1.3.2'

2. Context 추가 ( 설정파일 )
- SqlSessionFactory와 mapper 설정
````xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  <property name="dataSource" ref="dataSource" />
  <property name="mapper" value="classpath:/com/**/*Mapper.xml"></property>
</bean>
````
